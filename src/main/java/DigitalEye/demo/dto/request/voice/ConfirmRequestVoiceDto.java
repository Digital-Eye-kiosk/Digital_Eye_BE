package DigitalEye.demo.dto.request.voice;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ConfirmRequestVoiceDto (
        @JsonProperty(value = "train_table_id") Long train_table_id,
        @JsonProperty(value = "seat") String seat
) {
}
