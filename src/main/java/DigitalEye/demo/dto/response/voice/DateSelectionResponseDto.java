package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.io.Serializable;

@Builder
public record DateSelectionResponseDto(
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "year") int year,
        @JsonProperty(value = "month") int month,
        @JsonProperty(value = "day") int day
) implements Serializable {

    public static DateSelectionResponseDto of(final Long id,final int year, final int month, final int day) {
        return DateSelectionResponseDto.builder()
                .id(id)
                .year(month)
                .month(month)
                .day(day)
                .build();
    }
}
