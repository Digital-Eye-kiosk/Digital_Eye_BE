package DigitalEye.demo.service;


import DigitalEye.demo.dto.response.both.SeatDto;

import java.util.ArrayList;
import java.util.List;

public class GetSeatInfoService {
    public static List<String> getSeatInfo(SeatDto seatDto) {
        List<String> list = new ArrayList<>();
        if(seatDto.isKTX()) {
            list.add(seatDto.carNum1());
            list.add(seatDto.carNum2());
            list.add(seatDto.carNum3());
            list.add(seatDto.carNum4());
            list.add(seatDto.carNum5());
            list.add(seatDto.carNum6());
            list.add(seatDto.carNum7());
            list.add(seatDto.carNum8());
            list.add(seatDto.carNum9());
            list.add(seatDto.carNum10());
            list.add(seatDto.carNum11());
            list.add(seatDto.carNum12());
            list.add(seatDto.carNum13());
        }
        else {
            list.add(seatDto.carNum1());
            list.add(seatDto.carNum2());
            list.add(seatDto.carNum3());
            list.add(seatDto.carNum4());
            list.add(seatDto.carNum5());
        }
        return list;
    }
}