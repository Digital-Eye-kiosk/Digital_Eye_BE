package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record StationResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("check") int check,
        @JsonProperty("station") String station
) implements Serializable {

    public static StationResponseDto of(final Long id, final int check, final String station) {
        return StationResponseDto.builder()
                .id(id)
                .check(check)
                .station(station)
                .build();
    }
}
