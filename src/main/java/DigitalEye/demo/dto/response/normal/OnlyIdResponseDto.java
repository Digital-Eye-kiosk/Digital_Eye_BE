package DigitalEye.demo.dto.response.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record OnlyIdResponseDto(
        @JsonProperty(value = "id")
        Long id
) implements Serializable {
    public static OnlyIdResponseDto of(final Long id) {

        return OnlyIdResponseDto.builder()
                .id(id)
                .build();
    }
}