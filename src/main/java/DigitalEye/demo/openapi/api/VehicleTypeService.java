package DigitalEye.demo.openapi.api;

import DigitalEye.demo.openapi.model.VehicleType;
import DigitalEye.demo.openapi.util.ApiUtils;

import java.io.IOException;

//차량종류 목록 조회 서비스
public class VehicleTypeService {
    private OpenApiClient client;

    public VehicleTypeService() {
        this.client = new OpenApiClient();
    }

    public VehicleType[] getVehicleTypes() throws IOException {
        String url = ApiUtils.buildVehicleTypeUrl();
        String response = client.sendRequest(url);
        return ApiResponse.parseVehicleTypes(response);
    }
}
