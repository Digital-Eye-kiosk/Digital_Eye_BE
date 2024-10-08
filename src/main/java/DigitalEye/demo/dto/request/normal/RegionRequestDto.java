package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegionRequestDto(
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "region")
        String region
) {
}