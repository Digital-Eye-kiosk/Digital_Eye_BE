package digitaleye.demo;

import digitaleye.demo.service.api.City;
import digitaleye.demo.service.api.TrainStation;

import java.io.IOException;

public class test {
    public static void main(String[] args) {
        TrainStation trainStation = new TrainStation();
        String code;

        {
            try {
                code = trainStation.getStationCodeJson("11");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("code = " + code);
    }
}
