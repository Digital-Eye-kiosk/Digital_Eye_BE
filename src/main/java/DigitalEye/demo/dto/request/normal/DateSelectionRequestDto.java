package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DateSelectionRequestDto(
        @JsonProperty("id") Long id,
        @JsonProperty("month") int month,
        @JsonProperty("day") int day,
        @JsonProperty("depDate") String depDate // depDate 필드를 추가
) {}