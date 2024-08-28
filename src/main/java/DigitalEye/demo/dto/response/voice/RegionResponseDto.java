package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record RegionResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("check") int check,
        @JsonProperty("region") String region
) implements Serializable {

    public static RegionResponseDto of(final Long id, int check, final String region) {
        return RegionResponseDto.builder()
                .id(id)
                .check(check)
                .region(region)
                .build();
    }
}
