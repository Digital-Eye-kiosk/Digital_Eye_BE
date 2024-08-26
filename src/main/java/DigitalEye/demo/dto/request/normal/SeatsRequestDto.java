package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record SeatsRequestDto(
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "selectSit") List<Sit> selectSit
) {

    public static record Sit(
            @JsonProperty(value = "sitNum") String sitNum
    ) {
    }
}
