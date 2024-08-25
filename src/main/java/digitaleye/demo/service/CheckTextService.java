package digitaleye.demo.service;

public class CheckTextService {
    public static boolean checkOption(int option) {
        if(option == 0 || option == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean checkRegion(int cityCode) {
        if(cityCode != -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean checkStation(String stationCode) {
        if(stationCode != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
