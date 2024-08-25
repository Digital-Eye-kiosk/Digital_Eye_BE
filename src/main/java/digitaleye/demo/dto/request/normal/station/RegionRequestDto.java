package digitaleye.demo.dto.request.normal.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegionRequestDto(
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "region")
        String region
) {
}