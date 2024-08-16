package DigitalEye.demo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

//공공데이터 train 출발역, 도착역 정보 기반으로 열차정보 가져오는 api 변수선언
@Component
public class TrainInfoClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String SERVICE_KEY = "3L9RQEx6rksngfO6dNnpfgs/VXkAVhLHGg8KVnASxUs9fyGlwmxHaEQHKoF4hRTrZM3wQ2YkoNFWuQoJI70puA=="; // 데이터 포털에서 제공된 인증키(decoding)

    public String getTrainInfo(String depPlaceId, String arrPlaceId, String depPlandTime, String trainGradeCode) {
        String url = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/1613000/TrainInfoService")
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "10")
                .queryParam("_type", "json")
                .queryParam("depPlaceId", depPlaceId)
                .queryParam("arrPlaceId", arrPlaceId)
                .queryParam("depPlandTime", depPlandTime)
                .queryParam("trainGradeCode", trainGradeCode)
                .build()
                .toUriString();

        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            // 예외 처리 로직
            e.printStackTrace();
            return null;
        }
    }
}