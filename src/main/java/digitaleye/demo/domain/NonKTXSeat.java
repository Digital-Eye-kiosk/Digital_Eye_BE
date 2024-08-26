package digitaleye.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicUpdate
@Table(name = "non_KTX_seat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NonKTXSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @OneToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "car_num1")
    private String carNum1;

    @Column(name = "car_num2")
    private String carNum2;

    @Column(name = "car_num3")
    private String carNum3;

    @Column(name = "car_num4")
    private String carNum4;

    @Column(name = "car_num5")
    private String carNum5;

    @Builder
    public NonKTXSeat(final Train train,
                   final String carNum1,
                   final String carNum2,
                   final String carNum3,
                   final String carNum4,
                   final String carNum5
    ) {
        this.train = train;
        this.carNum1 = carNum1;
        this.carNum2 = carNum2;
        this.carNum3 = carNum3;
        this.carNum4 = carNum4;
        this.carNum5 = carNum5;
    }

    //Builder가 오류를 못 잡아주는 것을 잡아주기 위해
    public static NonKTXSeat from(final Train train,
                               final String carNum1,
                               final String carNum2,
                               final String carNum3,
                               final String carNum4,
                               final String carNum5
    ) {
        return NonKTXSeat.builder()
                .train(train)
                .carNum1(carNum1)
                .carNum2(carNum2)
                .carNum3(carNum3)
                .carNum4(carNum4)
                .carNum5(carNum5)
                .build();
    }

    public void updateCarNum1(final String carNum1) {
        this.carNum1 = carNum1;
    }

    public void updateCarNum2(final String carNum2) {
        this.carNum1 = carNum2;
    }

    public void updateCarNum3(final String carNum3) {
        this.carNum1 = carNum3;
    }

    public void updateCarNum4(final String carNum4) {
        this.carNum1 = carNum4;
    }

    public void updateCarNum5(final String carNum5) {
        this.carNum1 = carNum5;
    }
}