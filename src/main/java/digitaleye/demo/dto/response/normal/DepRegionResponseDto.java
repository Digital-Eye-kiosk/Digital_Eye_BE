package digitaleye.demo.dto.response.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record DepRegionResponseDto(
        @JsonProperty(value = "id")
        Long id
) implements Serializable {
    public static DepRegionResponseDto of(final Long id) {
        return DepRegionResponseDto.builder().id(id).build();
    }
}