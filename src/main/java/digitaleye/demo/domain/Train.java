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
@Table(name = "train")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private Long trainId;

    @Column(name = "train_type")
    private String trainType;

    @Column(name = "train_num")
    private Integer trainNum;

    @Column(name = "dep_station")
    private String depStation;

    @Column(name = "arr_station")
    private String arrStation;

    @Column(name = "date")
    private String date;

    @Column(name = "dep_time")
    private String depTime;

    @Column(name = "arr_time")
    private String arrTime;

    @Column(name = "price")
    private int price;

    @Column(name = "sold_out")
    private boolean soldOut;

    @Builder
    public Train(final String trainType,
                 final Integer trainNum,
                 final String depStation,
                 final String arrStation,
                 final String date,
                 final String depTime,
                 final String arrTime,
                 final int price,
                 final boolean soldOut
    ) {
        this.trainType = trainType;
        this.trainNum = trainNum;
        this.depStation = depStation;
        this.arrStation = arrStation;
        this.date = date;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.price = price;
        this.soldOut = soldOut;
    }

    //Builder가 오류를 못 잡아주는 것을 잡아주기 위해
    public static Train from(final String trainType,
                             final Integer trainNum,
                             final String depStation,
                             final String arrStation,
                             final String date,
                             final String depTime,
                             final String arrTime,
                             final int price,
                             final boolean soldOut
    ) {
        return Train.builder()
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

    public void updateSoldOut(final boolean soldOut) {
        this.soldOut = soldOut;
    }
}
