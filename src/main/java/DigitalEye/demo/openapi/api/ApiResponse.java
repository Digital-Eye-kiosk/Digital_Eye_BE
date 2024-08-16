package DigitalEye.demo.openapi.api;

import DigitalEye.demo.openapi.model.CityCode;
import DigitalEye.demo.openapi.model.Station;
import DigitalEye.demo.openapi.model.TrainInfo;
import DigitalEye.demo.openapi.model.VehicleType;
import com.google.gson.Gson;

//API응답 데이터를 Java 객체로 변환하는 클래스
public class ApiResponse {
    public static TrainInfo parseTrainInfo(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, TrainInfo.class);
    }

    public static Station[] parseStations(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Station[].class);
    }

    public static VehicleType[] parseVehicleTypes(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, VehicleType[].class);
    }

    public static CityCode[] parseCityCodes(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, CityCode[].class);
    }
}
