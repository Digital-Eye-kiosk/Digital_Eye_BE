package DigitalEye.demo.dto.request.voice;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SeatsRequestVoiceDto(
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "train_table_id") Long train_table_id,
        @JsonProperty(value = "recommandSeat") String recommandSeat
) {
}
