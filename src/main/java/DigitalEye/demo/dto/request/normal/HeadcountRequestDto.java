package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HeadcountRequestDto(
        @JsonProperty("id") Long id,
        @JsonProperty(value = "adult") int adult,
        @JsonProperty(value = "child") int child,
        @JsonProperty(value = "senior") int senior,
        @JsonProperty(value = "disable") int disable

) {
}