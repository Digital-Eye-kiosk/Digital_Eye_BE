package digitaleye.demo.dto.response.both;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record SeatDto(
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "is_KTX")
        boolean isKTX,
        @JsonProperty(value = "car_num1")
        String carNum1,
        @JsonProperty(value = "car_num2")
        String carNum2,
        @JsonProperty(value = "car_num3")
        String carNum3,
        @JsonProperty(value = "car_num4")
        String carNum4,
        @JsonProperty(value = "car_num5")
        String carNum5,
        @JsonProperty(value = "car_num6")
        String carNum6,
        @JsonProperty(value = "car_num7")
        String carNum7,
        @JsonProperty(value = "car_num8")
        String carNum8,
        @JsonProperty(value = "car_num9")
        String carNum9,
        @JsonProperty(value = "car_num10")
        String carNum10,
        @JsonProperty(value = "car_num11")
        String carNum11,
        @JsonProperty(value = "car_num12")
        String carNum12,
        @JsonProperty(value = "car_num13")
        String carNum13,
        @JsonProperty(value = "car_num14")
        String carNum14,
        @JsonProperty(value = "car_num15")
        String carNum15
) implements Serializable {
    public static SeatDto of(
            final Long id,
            final boolean isKTX,
            final String carNum1,
            final String carNum2,
            final String carNum3,
            final String carNum4,
            final String carNum5,
            final String carNum6,
            final String carNum7,
            final String carNum8,
            final String carNum9,
            final String carNum10,
            final String carNum11,
            final String carNum12,
            final String carNum13,
            final String carNum14,
            final String carNum15
    ) {
        return SeatDto.builder()
                .id(id)
                .isKTX(isKTX)
                .carNum1(carNum1)
                .carNum2(carNum2)
                .carNum3(carNum3)
                .carNum4(carNum4)
                .carNum5(carNum5)
                .carNum6(carNum6)
                .carNum7(carNum7)
                .carNum8(carNum8)
                .carNum9(carNum9)
                .carNum10(carNum10)
                .carNum11(carNum11)
                .carNum12(carNum12)
                .carNum13(carNum13)
                .carNum14(carNum14)
                .carNum15(carNum15)
                .build();
    }
}