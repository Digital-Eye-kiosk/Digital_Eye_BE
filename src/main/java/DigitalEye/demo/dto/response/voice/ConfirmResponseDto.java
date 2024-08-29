package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record ConfirmResponseDto(
        @JsonProperty(value = "check") int check
)implements Serializable {

    public static ConfirmResponseDto of(final int check){
        return ConfirmResponseDto.builder()
                .check(check)
                .build();
    }

}
