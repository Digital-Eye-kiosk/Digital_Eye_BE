package digitaleye.demo.dto.request.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TrainChoiceRequestDto(
        @JsonProperty(value = "train_type")
        String trainType,
        @JsonProperty(value = "train_num")
        int trainNum,
        @JsonProperty(value = "dep_station")
        String depStation,
        @JsonProperty(value = "arr_station")
        String arrStation,
        @JsonProperty(value = "date")
        String date,
        @JsonProperty(value = "dep_time")
        String depTime,
        @JsonProperty(value = "arr_time")
        String arrTime,
        @JsonProperty(value = "price")
        int price,
        @JsonProperty(value = "sold_out")
        boolean soldOut
) {
}