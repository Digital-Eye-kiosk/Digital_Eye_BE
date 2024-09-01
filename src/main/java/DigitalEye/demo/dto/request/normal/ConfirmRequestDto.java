package DigitalEye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ConfirmRequestDto(
        @JsonProperty("id") Long id,
        @JsonProperty("train_table_id") Long train_table_id,
        @JsonProperty("seat") String seat
) {
}
