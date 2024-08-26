package digitaleye.demo;


import java.io.IOException;

import static digitaleye.demo.service.OpenApiService.getTrainJson;
import static digitaleye.demo.service.OpenApiService.getTrainTypeJson;

public class test {
    public static void main(String[] args) {
        String trains;

        {
            try {
                trains = getTrainJson("NAT010000", "NAT011668", "20230403", "00");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("type = " + trains);
    }
}
