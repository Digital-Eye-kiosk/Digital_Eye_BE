package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DateSelectionRequestDto(
        @JsonProperty("id") Long id,
        @JsonProperty("year") int year,
        @JsonProperty("month") int month,
        @JsonProperty("day") int day
) {}
