package digitaleye.demo.service.both;

import digitaleye.demo.domain.KTXSeat;
import digitaleye.demo.domain.NonKTXSeat;
import digitaleye.demo.domain.Train;
import digitaleye.demo.dto.request.both.TrainIdRequestDto;
import digitaleye.demo.dto.response.both.SeatDto;
import digitaleye.demo.repository.*;
import digitaleye.demo.service.GetTrainService;

public class SeatService {
    private final SeatInfoRepository seatInfoRepository;

    public SeatService(TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
        this.seatInfoRepository = new SeatInfoRepository(trainRepository, ktxRepository, nonKTXRepository);
    }

    public SeatDto getSeats(TrainIdRequestDto trainIdRequestDto) {
        Train train = seatInfoRepository.findTrain(trainIdRequestDto.id());
        boolean isKTX = seatInfoRepository.isKTX(train);
        if(isKTX) {
            KTXSeat ktxSeat = seatInfoRepository.findKTXSeat(trainIdRequestDto.id());
            return SeatDto.of(
                    ktxSeat.getTrain().getTrainId(),
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
            return SeatDto.of(
                    nonKTXSeat.getTrain().getTrainId(),
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
