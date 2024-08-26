package DigitalEye.demo.dto.request.voice;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OnlyIdRequestDto (
    @JsonProperty(value = "id") Long id
    ){
}

