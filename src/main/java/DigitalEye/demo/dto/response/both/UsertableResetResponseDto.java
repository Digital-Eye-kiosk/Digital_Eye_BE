package DigitalEye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record UsertableResetResponseDto (
        @JsonProperty(value = "complete") int complete
)implements Serializable {
    public static UsertableResetResponseDto of (final int complete){
        return UsertableResetResponseDto.builder().complete(complete).build();
    }
}
