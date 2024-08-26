package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record ConfirmResponseDto(
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "check") int check
)implements Serializable {

    public static ConfirmResponseDto of(final Long id, final int check){
        return ConfirmResponseDto.builder()
                .id(id)
                .check(check)
                .build();
    }

}
