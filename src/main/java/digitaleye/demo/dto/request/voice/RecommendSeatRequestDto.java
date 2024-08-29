package digitaleye.demo.dto.request.voice;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RecommendSeatRequestDto(
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "train_id")
        Long trainId,
        @JsonProperty(value = "try_num")
        int tryNum
) {
}