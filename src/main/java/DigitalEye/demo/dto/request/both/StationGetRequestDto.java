package DigitalEye.demo.dto.request.both;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StationGetRequestDto(
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "region") String region
) {
}
