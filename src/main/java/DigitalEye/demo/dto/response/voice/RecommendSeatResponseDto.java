package DigitalEye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record RecommendSeatResponseDto(
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "train_id")
        Long trainId,
        @JsonProperty(value = "recommended_seat")
        String recommendedSeat
) implements Serializable {
    public static RecommendSeatResponseDto of(final Long id, final Long trainId, final String recommendedSeat) {
        return RecommendSeatResponseDto.builder()
                .id(id)
                .trainId(trainId)
                .recommendedSeat(recommendedSeat)
                .build();
    }
}