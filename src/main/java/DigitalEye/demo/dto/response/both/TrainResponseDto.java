package DigitalEye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

//열차조회를 위한 Response
@Builder
public record TrainResponseDto(
        @JsonProperty(value = "train_type")
        String trainType,
        @JsonProperty(value = "train_num")
        int trainNum,
        @JsonProperty(value = "dep_station")
        String depStation,
        @JsonProperty(value = "arr_station")
        String arrStation,
        @JsonProperty(value = "dep_time")
        String depTime,
        @JsonProperty(value = "arr_time")
        String arrTime,
        @JsonProperty(value = "sold_out")
        boolean soldOut,
        @JsonProperty(value = "adult")
        int adult,
        @JsonProperty(value = "child")
        int child,
        @JsonProperty(value = "senior")
        int senior,
        @JsonProperty(value = "disable")
        int disable
) implements Serializable {
    public static TrainResponseDto of(final String trainType,
                                      final int trainNum,
                                      final String depStation,
                                      final String arrStation,
                                      final String depTime,
                                      final String arrTime,
                                      final boolean soldOut,
                                      final int adult,
                                      final int child,
                                      final int senior,
                                      final int disable
    ) {
        return TrainResponseDto.builder()
                .trainType(trainType)
                .trainNum(trainNum)
                .depStation(depStation)
                .arrStation(arrStation)
                .depTime(depTime)
                .arrTime(arrTime)
                .soldOut(soldOut)
                .adult(adult)
                .child(child)
                .senior(senior)
                .disable(disable)
                .build();
    }
}
