package digitaleye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DepartureRegionRequestDto(
        @JsonProperty(value = "region")
        String region
) {
}