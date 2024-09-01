package DigitalEye.demo.service;


import DigitalEye.demo.dto.request.normal.TrainChoiceRequestDto;
import DigitalEye.demo.dto.response.both.TrainResponseDto;
import DigitalEye.demo.dto.response.voice.TrainChoiceResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class FilteredTrainService {
    public static List<TrainChoiceResponseDto> filtering1(List<TrainResponseDto> trains, List<String> trainTypes, String time, String date) {
        List<TrainChoiceResponseDto> filteredTrains = trains.stream()
                .filter(train -> trainTypes.contains(train.trainType()) && train.depTime().substring(7, 9) == time && train.soldOut() == false)
                .map(train -> TrainChoiceResponseDto.of(
                        train.trainType(),
                        train.trainNum(),
                        train.depStation(),
                        train.arrStation(),
                        date,
                        train.depTime(),
                        train.arrTime(),
                        train.adult(),
                        train.soldOut()))
                .collect(Collectors.toList());

        return filteredTrains;
    }

    public static List<TrainChoiceRequestDto> filtering2(List<TrainChoiceRequestDto> trains, String min) {
        List<TrainChoiceRequestDto> filteredTrains = trains.stream()
                .filter(train -> train.depTime().substring(9, 11) == min)
                .collect(Collectors.toList());

        return filteredTrains;
    }
}