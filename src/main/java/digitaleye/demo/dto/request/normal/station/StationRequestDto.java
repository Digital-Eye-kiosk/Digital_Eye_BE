package digitaleye.demo.dto.request.normal.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StationRequestDto(
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "station")
        String station
) {
}