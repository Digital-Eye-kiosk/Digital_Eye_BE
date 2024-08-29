package DigitalEye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record FinalChoiceResponseDto(
        @JsonProperty("dep_station") String dep_station,
        @JsonProperty("arr_station") String arr_station,
        @JsonProperty("date") String date,
        @JsonProperty("adult") String adult,
        @JsonProperty("child") String child,
        @JsonProperty("senior") String senior,
        @JsonProperty("disable") String disable,
        @JsonProperty("train_type") String train_type,
        @JsonProperty("dep_time") String dep_time,
        @JsonProperty("arr_time") String arr_time,
        @JsonProperty("seat") String seat,
        @JsonProperty("price") String price
) implements Serializable {
    public static FinalChoiceResponseDto of(final String dep_station,
                                            final String arr_station,
                                            final String date,
                                            final String adult,
                                            final String child,
                                            final String senior,
                                            final String disable,
                                            final String train_type,
                                            final String dep_time,
                                            final String arr_time,
                                            final String seat,
                                            final String price)
    {
        return FinalChoiceResponseDto.builder()
                .dep_station(dep_station)
                .arr_station(arr_station)
                .date(date)
                .adult(adult)
                .child(child)
                .senior(senior)
                .disable(disable)
                .train_type(train_type)
                .dep_time(dep_time)
                .arr_time(arr_time)
                .seat(seat)
                .price(price)
                .build();
    }

}
