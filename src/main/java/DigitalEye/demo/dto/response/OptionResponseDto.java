package DigitalEye.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record OptionResponseDto(
        @JsonProperty(value = "check")
        boolean check,
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "option")
        int option
) implements Serializable {
    public static OptionResponseDto of(final boolean check, final Long id, final int option) {
        return OptionResponseDto.builder()
                .check(check)
                .id(id)
                .option(option)
                .build();
    }
}