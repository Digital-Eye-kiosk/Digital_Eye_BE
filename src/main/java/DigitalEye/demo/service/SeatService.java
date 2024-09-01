package DigitalEye.demo.service;


import DigitalEye.demo.domain.KTXSeat;
import DigitalEye.demo.domain.NonKTXSeat;
import DigitalEye.demo.domain.Train;
import DigitalEye.demo.dto.request.both.TrainIdRequestDto;
import DigitalEye.demo.dto.response.both.SeatDto;
import DigitalEye.demo.repository.KTXRepository;
import DigitalEye.demo.repository.NonKTXRepository;
import DigitalEye.demo.repository.SeatInfoRepository;
import DigitalEye.demo.repository.TrainRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    private final SeatInfoRepository seatInfoRepository;

    public SeatService(TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
        this.seatInfoRepository = new SeatInfoRepository(trainRepository, ktxRepository, nonKTXRepository);
    }

    public SeatDto getSeats(TrainIdRequestDto trainIdRequestDto) {
        Train train = seatInfoRepository.findTrain(trainIdRequestDto.id());
        boolean isKTX = seatInfoRepository.isKTX(train);
        System.out.println("isKTX: " + isKTX);
        if(isKTX) {
            KTXSeat ktxSeat = seatInfoRepository.findKTXSeat(trainIdRequestDto.id());
            System.out.println("trainId : " + trainIdRequestDto.id());
            System.out.println("carNum1 : " + ktxSeat.getCarNum1());
            return SeatDto.of(
                    ktxSeat.getTrain().getId(),
                    isKTX,
                    ktxSeat.getCarNum1(),
                    ktxSeat.getCarNum2(),
                    ktxSeat.getCarNum3(),
                    ktxSeat.getCarNum4(),
                    ktxSeat.getCarNum5(),
                    ktxSeat.getCarNum6(),
                    ktxSeat.getCarNum7(),
                    ktxSeat.getCarNum8(),
                    ktxSeat.getCarNum9(),
                    ktxSeat.getCarNum10(),
                    ktxSeat.getCarNum11(),
                    ktxSeat.getCarNum12(),
                    ktxSeat.getCarNum13(),
                    ktxSeat.getCarNum14(),
                    ktxSeat.getCarNum15());
        }
        else {
            NonKTXSeat nonKTXSeat = seatInfoRepository.findNonKTXSeat(trainIdRequestDto.id());
            System.out.println("carNum1 : " + nonKTXSeat.getCarNum1());
            return SeatDto.of(
                    nonKTXSeat.getTrain().getId(),
                    isKTX,
                    nonKTXSeat.getCarNum1(),
                    nonKTXSeat.getCarNum2(),
                    nonKTXSeat.getCarNum3(),
                    nonKTXSeat.getCarNum4(),
                    nonKTXSeat.getCarNum5(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
        }
    }
}
