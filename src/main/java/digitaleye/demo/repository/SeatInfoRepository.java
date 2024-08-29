package digitaleye.demo.repository;

import digitaleye.demo.domain.KTXSeat;
import digitaleye.demo.domain.NonKTXSeat;
import digitaleye.demo.domain.Train;
import org.springframework.stereotype.Repository;

@Repository
public class SeatInfoRepository {
    public final TrainRepository trainRepository;
    public final KTXRepository ktxRepository;
    public final NonKTXRepository nonKTXRepository;


    public SeatInfoRepository(TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
        this.trainRepository = trainRepository;
        this.ktxRepository = ktxRepository;
        this.nonKTXRepository = nonKTXRepository;
    }

    public Train findTrain(long id) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        return train;
    }

    public boolean isKTX(Train train) {
        String trainType = train.getTrainType();

        if(trainType == "KTX") {
            return true;
        }
        else {
            return false;
        }
    }

    public KTXSeat findKTXSeat(long id) {
        KTXSeat ktxSeat = ktxRepository.findByTrainId(id);

        return ktxSeat;
    }

    public NonKTXSeat findNonKTXSeat(long id) {
        NonKTXSeat nonKTXSeat = nonKTXRepository.findByTrainId(id);

        return nonKTXSeat;
    }
}
