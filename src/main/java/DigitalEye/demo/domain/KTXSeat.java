package DigitalEye.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name = "KTX_seat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KTXSeat {

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

    @Column(name = "car_num6")
    private String carNum6;

    @Column(name = "car_num7")
    private String carNum7;

    @Column(name = "car_num8")
    private String carNum8;

    @Column(name = "car_num9")
    private String carNum9;

    @Column(name = "car_num10")
    private String carNum10;

    @Column(name = "car_num11")
    private String carNum11;

    @Column(name = "car_num12")
    private String carNum12;

    @Column(name = "car_num13")
    private String carNum13;

    @Column(name = "car_num14")
    private String carNum14;

    @Column(name = "car_num15")
    private String carNum15;

    @Builder
    public KTXSeat(final Train train) {
        this.train = train;
        this.carNum1 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum2 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum3 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum4 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum5 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum6 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum7 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum8 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum9 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum10 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum11 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum12 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum13 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum14 = "000000000000000000000000000000000000000000000000000000000000";
        this.carNum15 = "000000000000000000000000000000000000000000000000000000000000";
    }

    //Builder가 오류를 못 잡아주는 것을 잡아주기 위해
    public static KTXSeat from(final Train train) {
        return KTXSeat.builder()
                .train(train)
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

    public void updateCarNum6(final String carNum6) {
        this.carNum1 = carNum6;
    }

    public void updateCarNum7(final String carNum7) {
        this.carNum1 = carNum7;
    }

    public void updateCarNum8(final String carNum8) {
        this.carNum1 = carNum8;
    }

    public void updateCarNum9(final String carNum9) {
        this.carNum1 = carNum9;
    }

    public void updateCarNum10(final String carNum10) {
        this.carNum1 = carNum10;
    }

    public void updateCarNum11(final String carNum11) {
        this.carNum1 = carNum11;
    }

    public void updateCarNum12(final String carNum12) {
        this.carNum1 = carNum12;
    }

    public void updateCarNum13(final String carNum13) {
        this.carNum1 = carNum13;
    }

    public void updateCarNum14(final String carNum14) {
        this.carNum1 = carNum14;
    }

    public void updateCarNum15(final String carNum15) {
        this.carNum1 = carNum15;
    }
}