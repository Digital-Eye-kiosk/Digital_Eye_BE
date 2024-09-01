package DigitalEye.demo.service;


import DigitalEye.demo.dto.response.both.TrainResponseDto;
import DigitalEye.demo.repository.TrainInfoRepository;
import DigitalEye.demo.repository.TrainRepository;
import DigitalEye.demo.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static DigitalEye.demo.service.GetPriceService.*;
import static DigitalEye.demo.service.api.OpenApiService.getTrainJson;

@Service
public class GetTrainService {
    private final UserRepository userRepository;
    private final TrainInfoRepository trainInfoRepository;

    public GetTrainService(UserRepository userRepository, TrainRepository trainRepository) {
        this.userRepository = userRepository;
        this.trainInfoRepository = new TrainInfoRepository(userRepository, trainRepository);
    }

    public List<TrainResponseDto> getTrains(String depStation, String arrStation, String date, List<String> trainTypesCode) {
        List<TrainResponseDto> trainsInformation = new ArrayList<>();
        for(String trainTypeCode : trainTypesCode) {
            String trains;
            try {
                trains = getTrainJson(depStation, arrStation, date, trainTypeCode);
                System.out.println("API Response: " + trains);  // API 응답을 출력하여 확인
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // JSON 데이터 파싱
            JSONObject jsonObject = new JSONObject(trains);

            // "item" 부분 추출
            JSONArray items = jsonObject
                    .getJSONObject("response")
                    .getJSONObject("body")
                    .getJSONObject("items")
                    .getJSONArray("item");

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                String trainType = item.getString("traingradename");
                int train_num = item.getInt("trainno");
                String dep_station = item.getString("depplacename");
                String arr_station = item.getString("arrplacename");
                BigInteger dep_time = item.getBigInteger("depplandtime");
                String dep_time2 = String.valueOf(dep_time).substring(8,12);
                BigInteger arr_time = item.getBigInteger("arrplandtime");
                String arr_time2 = String.valueOf(arr_time).substring(8,12);
                boolean sold_out = trainInfoRepository.getSoldOut(train_num, date);
                int adult = item.getInt("adultcharge");
                int child = getChildPrice(adult);
                int senior = getSeniorPrice(adult);
                int disable = getDisablePrice(adult);
                TrainResponseDto trainResponseDto = TrainResponseDto.of(trainType, train_num, dep_station, arr_station, dep_time2, arr_time2, sold_out, adult, child, senior, disable);
                trainsInformation.add(trainResponseDto);
            }
        }

        return trainsInformation;
    }

}