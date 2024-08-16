package DigitalEye.demo.openapi.api;

import DigitalEye.demo.openapi.model.Station;
import DigitalEye.demo.openapi.util.ApiUtils;

import java.io.IOException;

//시/도별 기차역 목록 조회 서비스
public class StationListService {

    private OpenApiClient client;

    public StationListService() {
        this.client = new OpenApiClient();
    }

    public Station[] getStationsByCity(String cityCode) throws IOException {
        String url = ApiUtils.buildStationsUrl(cityCode);
        String response = client.sendRequest(url);
        return ApiResponse.parseStations(response);
    }
}
