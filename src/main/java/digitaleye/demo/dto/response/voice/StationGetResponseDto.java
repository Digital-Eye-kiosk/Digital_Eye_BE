package digitaleye.demo.dto.response.voice;

public class StationGetResponseDto {
    private int check;
    private String station;

    public StationGetResponseDto(int check, String station) {
        this.check = check;
        this.station = station;
    }

    public int getCheck() {
        return check;
    }

    public String getStation() {
        return station;
    }
}
