package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record HeadcountResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty(value = "adult") int adult,
        @JsonProperty(value = "child") int child,
        @JsonProperty(value = "senior") int senior,
        @JsonProperty(value = "disable") int disable
) implements Serializable {

    public static HeadcountResponseDto of(final Long id, final int adult, final int child, final int senior, final int disable) {
        return HeadcountResponseDto.builder()
                .id(id)
                .adult(adult)
                .child(child)
                .senior(senior)
                .disable(disable)
                .build();
    }
}
