package DigitalEye.demo.openapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainInfo {
    private String trainName;
    private String depTime;
    private String arrTime;
    private String depPlaceName;
    private String arrPlaceName;
}
