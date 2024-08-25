package digitaleye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record RegionResponseDto(
        @JsonProperty(value = "check")
        boolean check,
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "region")
        String region
) implements Serializable {
    public static RegionResponseDto of(final boolean check, final Long id, final String region) {
        return RegionResponseDto.builder()
                .check(check)
                .id(id)
                .region(region)
                .build();
    }
}