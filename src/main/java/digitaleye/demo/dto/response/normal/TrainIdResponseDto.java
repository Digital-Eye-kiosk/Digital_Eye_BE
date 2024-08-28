package digitaleye.demo.dto.response.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record TrainIdResponseDto(
        @JsonProperty(value = "id")
        Long id
) implements Serializable {
    public static TrainIdResponseDto of(final Long id) {
        return TrainIdResponseDto.builder().id(id).build();
    }
}