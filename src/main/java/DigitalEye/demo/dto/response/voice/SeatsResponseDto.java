package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record SeatsResponseDto(
        @JsonProperty(value = "train_table_id") Long train_table_id,
        @JsonProperty(value = "choice")int choice,
        @JsonProperty(value = "seat") String seat
) implements Serializable {

    public static SeatsResponseDto of(final Long train_table_id,final int choice, final String seat) {
        return SeatsResponseDto.builder()
                .train_table_id(train_table_id)
                .choice(choice)
                .seat(seat)
                .build();
    }

}

