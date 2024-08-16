package DigitalEye.demo.openapi.api;

import DigitalEye.demo.openapi.model.CityCode;
import DigitalEye.demo.openapi.util.ApiUtils;

import java.io.IOException;

public class CityCodeService {
    private OpenApiClient client;

    public CityCodeService() {
        this.client = new OpenApiClient();
    }

    public CityCode[] getCityCodes() throws IOException {
        String url = ApiUtils.buildCityCodesUrl();
        String response = client.sendRequest(url);
        return ApiResponse.parseCityCodes(response);
    }
}
