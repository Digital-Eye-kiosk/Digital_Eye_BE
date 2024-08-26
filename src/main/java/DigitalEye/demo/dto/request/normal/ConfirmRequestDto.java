package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ConfirmRequestDto(
        @JsonProperty("id") Long id,
        @JsonProperty("check") int check
) {
}
