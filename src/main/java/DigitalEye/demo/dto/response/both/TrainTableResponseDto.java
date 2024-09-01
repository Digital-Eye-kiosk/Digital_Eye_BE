package DigitalEye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record TrainTableResponseDto (
        @JsonProperty(value = "train_id") Long trainId,
        @JsonProperty(value = "train_type") String trainType,
        @JsonProperty(value = "train_num") Integer trainNum,
        @JsonProperty(value = "dep_station") String depStation,
        @JsonProperty(value = "arr_station") String arrStation,
        @JsonProperty(value = "date") String date,
        @JsonProperty(value = "dep_time") String depTime,
        @JsonProperty(value = "arr_time") String arrTime,
        @JsonProperty(value = "price") int price,
        @JsonProperty(value = "sold_out") boolean soldOut
)implements Serializable {
    public static  TrainTableResponseDto of(final Long trainId, final String trainType,
                                            final Integer trainNum, final String depStation,
                                            final String arrStation, final String date,
                                            final String depTime, final String arrTime,
                                            final int price, final boolean soldOut)
    {
        return TrainTableResponseDto.builder()
                .trainId(trainId)
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
