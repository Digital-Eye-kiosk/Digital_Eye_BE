package DigitalEye.demo.dto.response.voice;


import DigitalEye.demo.dto.request.normal.SeatsRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

@Builder
public record SeatsResponseDto(
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "selectSit") List<SeatsRequestDto.Sit> selectSit
) implements Serializable {

    public static SeatsResponseDto of(final Long id, final List<SeatsRequestDto.Sit> selectSit) {
        return SeatsResponseDto.builder()
                .id(id)
                .selectSit(selectSit)
                .build();
    }

    public static record Sit(
            @JsonProperty(value = "sitNum") String sitNum
    ) {}

}

