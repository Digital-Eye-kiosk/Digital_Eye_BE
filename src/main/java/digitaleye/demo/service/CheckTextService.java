package digitaleye.demo.service;

import java.util.List;

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

    public static boolean checkTrainTypeAndTime(String text) {
        String[] parts = text.split(" ");
        if((parts[0] == "고속" || parts[0] == "일반") && (parts[2].charAt(1) == '시' || parts[2].charAt(2) == '시')) {
            String time = parts[2];
            time = time.replace("시", "");
            int hour = Integer.valueOf(time);
            if(hour >= 0 && hour <= 23) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public static List<String> getTrainType(String text) {
        String[] parts = text.split(" ");
        if (parts[0] == "고속") {
            List<String> highSpeed = List.of("00", "07", "10", "16", "17", "19");
            return highSpeed;
        } else if (parts[0] == "일반") {
            List<String> nonHighSpeed = List.of("01", "02", "03", "04", "06", "08", "09", "18");
            return nonHighSpeed;
        }
        else {
            return null;
        }
    }

    public static String getTime(String text) {
        String[] parts = text.split(" ");
        String time = parts[2];
        time = time.replace("시", "");
        if(time.length() == 1) {
            time = "0" + time;
        }
        return time;
    }

    public static boolean checkMinute(String text) {
        String min = text.substring(0, text.length()-1);
        int m = Integer.valueOf(min);
        String minute = text.substring(text.length()-1, text.length());

        if(m >= 0 && m <= 59 && minute == "분") {
            return true;
        }
        else {
            return false;
        }
    }

    public static String getMinute(String text) {
        String min = text.substring(0, text.length()-1);

        if(min.length() == 1) {
            return "0" + min;
        }
        else {
            return min;
        }
    }
}
