package DigitalEye.demo.service;

import DigitalEye.demo.domain.KTXSeat;
import DigitalEye.demo.domain.NonKTXSeat;
import DigitalEye.demo.domain.Train;
import DigitalEye.demo.dto.request.normal.TrainChoiceRequestDto;
import DigitalEye.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class TrainChoiceServiceNormal {
    private final TrainChoiceRepository trainChoiceRepository;

    public TrainChoiceServiceNormal(UserRepository userRepository, TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
        this.trainChoiceRepository = new TrainChoiceRepository(userRepository, trainRepository, ktxRepository, nonKTXRepository);
    }

    public long trainChoice(TrainChoiceRequestDto trainChoiceRequestDto) {
        Train train = trainChoiceRepository.findTrain(trainChoiceRequestDto.trainNum(), trainChoiceRequestDto.date());
        if(train == null) {
            Train makeTrain = trainChoiceRepository.makeTrain(
                    trainChoiceRequestDto.trainType(),
                    trainChoiceRequestDto.trainNum(),
                    trainChoiceRequestDto.depStation(),
                    trainChoiceRequestDto.arrStation(),
                    trainChoiceRequestDto.date(),
                    trainChoiceRequestDto.depTime(),
                    trainChoiceRequestDto.arrTime(),
                    trainChoiceRequestDto.price(),
                    trainChoiceRequestDto.soldOut());
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
            return makeTrain.getId();
        }
        else {
            return train.getId();
        }
    }
}