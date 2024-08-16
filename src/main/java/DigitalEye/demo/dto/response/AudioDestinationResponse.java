package DigitalEye.demo.dto.response;


public class AudioDestinationResponse {

    private String stationName;
    private int check;

    // Constructor
    public AudioDestinationResponse(String stationName, int check) {
        this.stationName = stationName;
        this.check = check;
    }

    // Getters
    public String getStationName() {
        return stationName;
    }

    public int getCheck() {
        return check;
    }
}
