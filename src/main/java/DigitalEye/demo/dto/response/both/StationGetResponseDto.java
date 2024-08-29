package DigitalEye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record StationGetResponseDto(
        @JsonProperty("stationId") String stationId,
        @JsonProperty("station") String station
)implements Serializable {
    public static StationGetResponseDto of(final String stationId, final String station){
        return StationGetResponseDto.builder().stationId(stationId).station(station).build();
    }

}
