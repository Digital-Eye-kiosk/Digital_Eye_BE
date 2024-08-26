package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;


public record StationGetRequestDto (
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "station") String station
        ){
}