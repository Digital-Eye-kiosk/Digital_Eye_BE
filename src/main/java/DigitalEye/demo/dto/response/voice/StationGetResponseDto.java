package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record StationGetResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("check") int check,
        @JsonProperty("station") String station
) implements Serializable {

    public static StationGetResponseDto of(final Long id, final int check, final String station) {
        return StationGetResponseDto.builder()
                .id(id)
                .check(check)
                .station(station)
                .build();
    }
}
