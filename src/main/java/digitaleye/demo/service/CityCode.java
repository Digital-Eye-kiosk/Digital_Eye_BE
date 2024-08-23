package digitaleye.demo.service;

import digitaleye.demo.service.api.City;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class CityCode {
    public static int cityCode(String region) {
        //도시 정보 받기
        String cities;
        try {
            cities = City.getCityCodeJson();
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
}
