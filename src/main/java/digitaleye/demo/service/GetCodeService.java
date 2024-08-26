package digitaleye.demo.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static digitaleye.demo.service.OpenApiService.*;

public class GetCodeService {
    public static int getCityCode(String region) {
        //도시 정보 받기
        String cities;
        try {
            cities = getCityJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(cities);
        JSONArray itemsArray = jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");

        int cityCode = -1;
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            String cityName = item.getString("cityname");
            if (cityName.equals(region)) {
                cityCode = item.getInt("citycode");
                break;
            }
        }

        return cityCode;
    }
    public static String getStationCode(String cityCode, String station) {
        //역 정보 받기
        String stations;
        try {
            stations = getStationJson(cityCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(stations);
        JSONArray itemsArray = jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");

        String stationCode = null;
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            String nodeName = item.getString("nodename");
            if (nodeName.equals(station)) {
                stationCode = item.getString("nodeid");
                break;
            }
        }

        return stationCode;
    }

    public static List<String> getTrainTypesCode() {
        //열차 종류 정보 받기
        String types;
        try {
            types = getTrainTypeJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(types);
        JSONArray itemsArray = jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");

        List<String> trainTypesCode = new ArrayList<>();;
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            String trainTypeCode = item.getString("vehiclekndid");
            trainTypesCode.add(trainTypeCode);
        }

        return trainTypesCode;
    }
}
