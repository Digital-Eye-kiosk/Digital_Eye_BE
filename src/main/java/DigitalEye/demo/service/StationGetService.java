package DigitalEye.demo.service;

import DigitalEye.demo.dto.request.both.StationGetRequestDto;
import DigitalEye.demo.dto.response.both.StationGetResponseDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static DigitalEye.demo.service.GetCodeService.getCityCode;
import static DigitalEye.demo.service.api.OpenApiService.getStationJson;

@Service
public class StationGetService {

    public List<StationGetResponseDto> stationService(StationGetRequestDto stationGetRequestDto) throws IOException {
        int cityCode = getCityCode(stationGetRequestDto.region());
        //역 정보 받기
        String stations;
        try {
            stations = getStationJson(String.valueOf(cityCode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(stations);
        JSONArray itemsArray = jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");
        List<StationGetResponseDto> list = new ArrayList<>();
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            String cityName = item.getString("nodename");
             StationGetResponseDto station = StationGetResponseDto.of(cityName);
             list.add(station);
        }
        return list;
    }
}
