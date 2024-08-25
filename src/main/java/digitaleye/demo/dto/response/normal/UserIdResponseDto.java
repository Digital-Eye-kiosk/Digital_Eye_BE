package digitaleye.demo.dto.response.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record UserIdResponseDto(
        @JsonProperty(value = "id")
        Long id
) implements Serializable {
    public static UserIdResponseDto of(final Long id) {
        return UserIdResponseDto.builder().id(id).build();
    }
}