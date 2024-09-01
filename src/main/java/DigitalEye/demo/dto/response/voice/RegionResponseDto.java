package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record RegionResponseDto(
        @JsonProperty("check") boolean check,
        @JsonProperty("id") Long id,
        @JsonProperty("region") String region
) implements Serializable {

    public static RegionResponseDto of(boolean check,final Long id, final String region) {
        return RegionResponseDto.builder()
                .check(check)
                .id(id)
                .region(region)
                .build();
    }
}
