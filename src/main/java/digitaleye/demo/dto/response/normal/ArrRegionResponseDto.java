package digitaleye.demo.dto.response.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record ArrRegionResponseDto(
    @JsonProperty(value = "id")
    Long id
) implements Serializable {
    public static ArrRegionResponseDto of(final Long id) {
        return ArrRegionResponseDto.builder().id(id).build();
    }
}