package digitaleye.demo.service;

import java.util.ArrayList;
import java.util.List;

public class GetRecommendSeatService {
    public static String getRecommendSeat(List<String> seats, int tryNum, int headCount) {
        List<Integer> seatNumPriority = priority(seats);
        int carNum = seatNumPriority.indexOf(tryNum);
        String carSeats = seats.get(carNum);
        String pattern = makePattern(headCount);
        int seatIndex = closeToDoorSeats(carSeats, pattern);
        String recommendSeat = String.valueOf(carNum) + "-";
        for(int i = 0; i < headCount-1; i++) {
            recommendSeat = recommendSeat + String.valueOf(seatIndex+i) + ",";
        }
        recommendSeat = recommendSeat + String.valueOf(seatIndex+headCount-1);

        return recommendSeat;
    }

    public static String makePattern(int headCount) {
        String pattern = "";
        for(int i = 0; i < headCount; i++) {
            pattern = pattern + "0";
        }

        return pattern;
    }

    public static List<Integer> priority(List<String> seats) {
        List<Integer> num = new ArrayList<>();
        List<Integer> pri = new ArrayList<>();
        for(int i = 0; i < seats.size(); i++) {
            int n = seatNum(seats.get(i));
            num.add(n);
            pri.add(0);
        }

        for(int i = 0; i <seats.size(); i++) {
            int index = findMaxIndex(num);
            pri.set(index, i+1);
        }

        return pri;
    }

    public static int seatNum(String seats) {
        return (int) seats.chars()
                .filter(c -> c == '0')
                .count();
    }

    public static int findMaxIndex(List<Integer> list) {
        int maxIndex = 0;
        int maxValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxValue = list.get(i);
                maxIndex = i;
            }
        }
        list.set(maxIndex, -1);

        return maxIndex;
    }

    public static int closeToDoorSeats(String seats, String pattern) {
        int leftIndex = seats.indexOf(pattern);
        int rightIndex = seats.lastIndexOf(pattern);

        // 오른쪽 인덱스를 음수로 설정하여 오른쪽에서의 인덱스 계산
        rightIndex = seats.length() - rightIndex - pattern.length();

        if (rightIndex == -1) {
            return leftIndex;
        }
        if (leftIndex == -1) {
            return rightIndex;
        }

        return Math.min(leftIndex, rightIndex);
    }
}
