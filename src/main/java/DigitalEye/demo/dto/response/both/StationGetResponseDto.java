package DigitalEye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record StationGetResponseDto(
        @JsonProperty("station") String station
)implements Serializable {
    public static StationGetResponseDto of(final String station){
        return StationGetResponseDto.builder().station(station).build();
    }

}
