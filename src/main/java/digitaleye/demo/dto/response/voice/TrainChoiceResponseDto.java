package digitaleye.demo.dto.response.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record TrainChoiceResponseDto(
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
) implements Serializable {
    public static TrainChoiceResponseDto of(
            final String trainType,
            final int trainNum,
            final String depStation,
            final String arrStation,
            final String date,
            final String depTime,
            final String arrTime,
            final int price,
            final boolean soldOut
    ) {
        return TrainChoiceResponseDto.builder()
                .trainType(trainType)
                .trainNum(trainNum)
                .depStation(depStation)
                .arrStation(arrStation)
                .date(date)
                .depTime(depTime)
                .arrTime(arrTime)
                .price(price)
                .soldOut(soldOut)
                .build();
    }
}