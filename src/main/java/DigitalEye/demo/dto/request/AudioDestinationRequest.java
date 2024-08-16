package DigitalEye.demo.dto.request;

public class AudioDestinationRequest {

    private String stationName; // STT로 받은 출발역 또는 도착역 이름

    // Getters and Setters
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
