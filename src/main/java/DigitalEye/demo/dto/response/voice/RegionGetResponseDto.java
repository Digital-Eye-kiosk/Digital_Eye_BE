package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record RegionGetResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("check") int check,
        @JsonProperty("region") String region
) implements Serializable {

    public static RegionGetResponseDto of(final Long id, int check, final String region) {
        return RegionGetResponseDto.builder()
                .id(id)
                .check(check)
                .region(region)
                .build();
    }
}
