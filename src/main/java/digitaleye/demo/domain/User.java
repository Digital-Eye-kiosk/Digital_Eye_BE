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
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "op")
    private Integer option;

    @Column(name = "dep_region")
    private Integer depRegion;

    @Column(name = "arr_region")
    private Integer arrRegion;

    @Column(name = "dep_station")
    private String depStation;

    @Column(name = "arr_station")
    private String arrStation;

    @Column(name = "date")
    private String date;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "adult")
    private Integer adult;

    @Column(name = "child")
    private Integer child;

    @Column(name = "senior")
    private Integer senior;

    @Column(name = "disable")
    private Integer disable;

    @Column(name = "adult_price")
    private Integer adultPrice;

    @Column(name = "child_price")
    private Integer childPrice;

    @Column(name = "senior_price")
    private Integer seniorPrice;

    @Column(name = "disable_price")
    private Integer disablePrice;

    @Builder
    private User(final Integer option) {
        this.option = option;
    }

    //Builder가 오류를 못 잡아주는 것을 잡아주기 위해
    public static User from(final Integer option) {
        return User.builder()
                .option(option)
                .build();
    }

    public void updateDepRegion(final Integer depRegion) {
        this.depRegion = depRegion;
    }

    public void updateArrRegion(final Integer arrRegion) {
        this.arrRegion = arrRegion;
    }

    public void updateDepStation(final String depStation) {
        this.depStation = depStation;
    }

    public void updateArrStation(final String arrStation) {
        this.arrStation = arrStation;
    }
}