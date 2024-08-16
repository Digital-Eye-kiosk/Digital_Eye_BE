package DigitalEye.demo.dto.response;

public class DestinationResponse {
    private String finalDestination;

    // Constructor
    public DestinationResponse(String finalDestination) {
        this.finalDestination = finalDestination;
    }

    // Getter
    public String getFinalDestination() {
        return finalDestination;
    }
}
