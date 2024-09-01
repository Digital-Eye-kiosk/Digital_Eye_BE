package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record StationResponseDto(
        @JsonProperty("check") boolean check,
        @JsonProperty("id") Long id,
        @JsonProperty("station") String station
) implements Serializable {

    public static StationResponseDto of(final boolean check,final Long id, final String station) {
        return StationResponseDto.builder()
                .check(check)
                .id(id)
                .station(station)
                .build();
    }
}
