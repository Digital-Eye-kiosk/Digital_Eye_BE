package DigitalEye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record UserTableResponseDto (
        @JsonProperty(value = "op") int option,
        @JsonProperty(value = "dep_region") int depRegion,
        @JsonProperty(value = "arr_region") int arrRegion,
        @JsonProperty(value = "dep_station") String depStation,
        @JsonProperty(value = "arr_station") String arrStation,
        @JsonProperty(value = "date") String date,
        @JsonProperty(value = "adult") Integer adult,
        @JsonProperty(value = "child") Integer child,
        @JsonProperty(value = "senior") Integer senior,
        @JsonProperty(value = "disable") Integer disable,
        @JsonProperty(value = "adult_price") Integer adultPrice,
        @JsonProperty(value = "child_price") Integer childPrice,
        @JsonProperty(value = "senior_price") Integer seniorPrice,
        @JsonProperty(value = "disable_price") Integer disablePrice,
        @JsonProperty(value = "seat_number") String seatNumber
)implements Serializable {
    public static UserTableResponseDto of (final int option,
                                           final int depRegion, final int arrRegion, final String depStation, final String arrStation,
                                           final String date, final Integer adult, final Integer child, final Integer senior,
                                           final Integer disable, final Integer adultPrice, final Integer childPrice, final Integer seniorPrice,
                                           final Integer disablePrice, final String seatNumber){
        return UserTableResponseDto.builder()
                .option(option)
                .depRegion(depRegion)
                .arrRegion(arrRegion)
                .depStation(depStation)
                .arrStation(arrStation)
                .date(date)
                .adult(adult)
                .child(child)
                .senior(senior)
                .disable(disable)
                .adultPrice(adultPrice)
                .childPrice(childPrice)
                .seniorPrice(seniorPrice)
                .disablePrice(disablePrice)
                .seatNumber(seatNumber)
        .build();
    }
}
