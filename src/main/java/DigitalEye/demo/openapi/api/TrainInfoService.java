package DigitalEye.demo.openapi.api;

import DigitalEye.demo.openapi.model.TrainInfo;
import DigitalEye.demo.openapi.util.ApiUtils;

import java.io.IOException;

//출/도착지 기반 열차 정보 조회 서비스
public class TrainInfoService {
    private OpenApiClient client;

    public TrainInfoService() {
        this.client = new OpenApiClient();
    }

    public TrainInfo getTrainInfo(String depPlaceId, String arrPlaceId, String depPlandTime) throws IOException {
        String url = ApiUtils.buildTrainInfoUrl(depPlaceId, arrPlaceId, depPlandTime);
        String response = client.sendRequest(url);
        return ApiResponse.parseTrainInfo(response);
    }
}
