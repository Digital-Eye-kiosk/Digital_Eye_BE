package DigitalEye.demo.service;

public class GetPriceService {
    public static int getChildPrice(int adult) {
        return (int) Math.round(adult * 0.5);
    }

    public static int getSeniorPrice(int adult) {
        return (int) Math.round(adult * 0.7);
    }

    public static int getDisablePrice(int adult) {
        return (int) Math.round(adult * 0.5);
    }
}
