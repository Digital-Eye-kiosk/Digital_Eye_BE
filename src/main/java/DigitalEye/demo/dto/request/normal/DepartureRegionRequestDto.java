package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DepartureRegionRequestDto(
        @JsonProperty("id") Long id,
        @JsonProperty(value = "region")
        String region
) {
}