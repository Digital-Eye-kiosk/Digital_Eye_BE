package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record SeatsRequestDto(
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "train_table_id") Long train_table_id,
        @JsonProperty(value = "seat") String seat
) {
}
