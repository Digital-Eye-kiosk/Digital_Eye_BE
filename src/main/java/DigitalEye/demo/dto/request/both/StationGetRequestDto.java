package DigitalEye.demo.dto.request.both;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StationGetRequestDto(
        @JsonProperty(value = "station") String station
) {
}
