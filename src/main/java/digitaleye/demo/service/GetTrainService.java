package digitaleye.demo.service;

import digitaleye.demo.dto.response.both.TrainResponseDto;
import digitaleye.demo.repository.TrainInfoRepository;
import digitaleye.demo.repository.TrainRepository;
import digitaleye.demo.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static digitaleye.demo.service.GetPriceService.*;
import static digitaleye.demo.service.OpenApiService.getTrainJson;

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
            //열차 정보 받기
            String trains;
            try {
                trains = getTrainJson(depStation, arrStation, date, trainTypeCode);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JSONObject jsonObject = new JSONObject(trains);
            JSONArray itemsArray = jsonObject.getJSONObject("response")
                    .getJSONObject("body")
                    .getJSONObject("items")
                    .getJSONArray("item");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject item = itemsArray.getJSONObject(i);
                String trainType = item.getString("traingradname");
                int train_num = Integer.valueOf(item.getString("trainno"));
                String dep_station = item.getString("depplacename");
                String arr_station = item.getString("arrplacename");
                String dep_time = item.getString("depplandtime").substring(8, 12);
                String arr_time = item.getString("arrplandtime").substring(8, 12);
                boolean sold_out = trainInfoRepository.getSoldOut(train_num, date);
                int adult = Integer.valueOf(item.getString("adultcharge"));
                int child = getChildPrice(adult);
                int senior = getSeniorPrice(adult);
                int disable = getDisablePrice(adult);
                TrainResponseDto trainResponseDto = TrainResponseDto.of(trainType, train_num, dep_station, arr_station, dep_time, arr_time, sold_out, adult, child, senior, disable);
                trainsInformation.add(trainResponseDto);
            }
        }

        return trainsInformation;
    }
}
