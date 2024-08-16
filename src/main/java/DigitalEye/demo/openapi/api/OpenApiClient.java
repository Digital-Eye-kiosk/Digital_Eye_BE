package DigitalEye.demo.openapi.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

//공통 HTTP 클라이언트 코드 - 모든 API호출에서 동일한 HTTP요청로직 사용할 수 있도록
public class OpenApiClient {
    private OkHttpClient client;

    public OpenApiClient() {
        this.client = new OkHttpClient();
    }

    public String sendRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
