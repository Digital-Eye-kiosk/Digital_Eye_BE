package digitaleye.demo.dto.response.voice;

public class RegionGetResponseDto {
    private int check;
    private String region;

    public RegionGetResponseDto(int check, String region) {
        this.check = check;
        this.region = region;
    }

    public int getCheck() {
        return check;
    }

    public String getRegion() {
        return region;
    }
}