package digitaleye.demo.dto.request.normal;

public class StationGetRequestDto {
    private String station;

    public StationGetRequestDto(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }
}
