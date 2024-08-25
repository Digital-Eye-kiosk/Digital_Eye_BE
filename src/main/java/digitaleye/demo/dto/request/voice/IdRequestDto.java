package digitaleye.demo.dto.request.voice;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IdRequestDto(
        @JsonProperty(value = "id")
        Long id
) {
}
