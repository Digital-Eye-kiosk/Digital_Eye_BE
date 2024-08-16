package DigitalEye.demo.service;

import DigitalEye.demo.dto.request.DestinationRequest;
import DigitalEye.demo.dto.response.DestinationResponse;

public class DestinationService {
    public DestinationResponse findFinalDestination(DestinationRequest request) {
        // 비즈니스 로직을 여기에 구현합니다. 예를 들어:
        String finalDestination = request.getDestination();
        // 실제로는 출발지나 도착지를 기반으로 로직을 작성할 수 있습니다.

        return new DestinationResponse(finalDestination);
    }
}
