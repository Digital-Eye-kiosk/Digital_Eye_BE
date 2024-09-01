package DigitalEye.demo.service;


import DigitalEye.demo.domain.KTXSeat;
import DigitalEye.demo.domain.NonKTXSeat;
import DigitalEye.demo.domain.Train;
import DigitalEye.demo.dto.request.normal.TrainChoiceRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.TrainResponseDto;
import DigitalEye.demo.dto.response.voice.TrainChoiceResponseDto;
import DigitalEye.demo.dto.response.voice.TrainFinalChoiceResponseDto;
import DigitalEye.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static DigitalEye.demo.service.CheckTextService.*;
import static DigitalEye.demo.service.FilteredTrainService.filtering1;
import static DigitalEye.demo.service.FilteredTrainService.filtering2;
import static org.aspectj.bridge.Version.getText;

@Service
public class TrainChoiceService {
    private final TrainChoiceRepository trainChoiceRepository;
    private final TrainService trainService;

    public TrainChoiceService(UserRepository userRepository, TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
        this.trainChoiceRepository = new TrainChoiceRepository(userRepository, trainRepository, ktxRepository, nonKTXRepository);
        this.trainService = new TrainService(userRepository,trainRepository);
    }

    public List<TrainChoiceResponseDto> trainChoice1(OnlyIdRequestDto idRequestDto) {
        //stt 함수로 사용자 응답을 받아냄
        String text = getText();
        boolean check = checkTrainTypeAndTime(text);
        if(check) {
            //열차 조회
            List<TrainResponseDto> trains = trainService.getTrains(idRequestDto);
            List<String> trainTypes = getTrainType(text);
            String time = getTime(text);
            //선택한 정보에 맞는 열차 필터링
            List<TrainChoiceResponseDto> filteredTrains = filtering1(trains, trainTypes, time, trainChoiceRepository.findUser(idRequestDto.id()).getDate());

            return filteredTrains;
        }
        else {
            return null;
        }
    }

    public TrainFinalChoiceResponseDto trainChoice2(List<TrainChoiceRequestDto> trainChoiceRequestDtos) {
        //stt 함수로 사용자 응답을 받아냄
        String text = getText();
        boolean check = checkMinute(text);
        if(check) {
            //선택한 정보에 맞는 열차 필터링
            String min = getMinute(text);
            List<TrainChoiceRequestDto> filteredTrains = filtering2(trainChoiceRequestDtos, min);
            if (filteredTrains.isEmpty()) {
                return null;
            }
            Train train = trainChoiceRepository.findTrain(filteredTrains.get(0).trainNum(), filteredTrains.get(0).date());
            if(train == null) {
                Train makeTrain = trainChoiceRepository.makeTrain(
                        filteredTrains.get(0).trainType(),
                        filteredTrains.get(0).trainNum(),
                        filteredTrains.get(0).depStation(),
                        filteredTrains.get(0).arrStation(),
                        filteredTrains.get(0).date(),
                        filteredTrains.get(0).depTime(),
                        filteredTrains.get(0).arrTime(),
                        filteredTrains.get(0).price(),
                        filteredTrains.get(0).soldOut());
                if(makeTrain.getTrainType() == "KTX") {
                    KTXSeat ktxSeat = trainChoiceRepository.makeKTXSeat(makeTrain);
                    ktxSeat.updateCarNum1("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum2("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum3("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum4("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum5("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum6("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum7("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum8("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum9("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum10("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum11("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum12("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum13("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum14("000000000000000000000000000000000000000000000000000000000000");
                    ktxSeat.updateCarNum15("000000000000000000000000000000000000000000000000000000000000");
                }
                else {
                    NonKTXSeat nonKTXSeat = trainChoiceRepository.makeNonKTXSeat(makeTrain);
                    nonKTXSeat.updateCarNum1("00000000000000000000000000000000000000000000000000");
                    nonKTXSeat.updateCarNum2("00000000000000000000000000000000000000000000000000");
                    nonKTXSeat.updateCarNum3("00000000000000000000000000000000000000000000000000");
                    nonKTXSeat.updateCarNum4("00000000000000000000000000000000000000000000000000");
                    nonKTXSeat.updateCarNum5("00000000000000000000000000000000000000000000000000");
                }
                return TrainFinalChoiceResponseDto.of(
                        makeTrain.getId(),
                        makeTrain.getTrainType(),
                        makeTrain.getTrainNum(),
                        makeTrain.getDepStation(),
                        makeTrain.getArrStation(),
                        makeTrain.getDate(),
                        makeTrain.getDepTime(),
                        makeTrain.getArrTime(),
                        makeTrain.getPrice(),
                        makeTrain.isSoldOut());
            }
            else {
                return TrainFinalChoiceResponseDto.of(
                        train.getId(),
                        train.getTrainType(),
                        train.getTrainNum(),
                        train.getDepStation(),
                        train.getArrStation(),
                        train.getDate(),
                        train.getDepTime(),
                        train.getArrTime(),
                        train.getPrice(),
                        train.isSoldOut());
            }
        }
        else {
            return null;
        }
    }
}
