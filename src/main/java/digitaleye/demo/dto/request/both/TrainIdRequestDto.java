package digitaleye.demo.dto.request.both;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TrainIdRequestDto(
        @JsonProperty(value = "id")
        Long id
) {
}