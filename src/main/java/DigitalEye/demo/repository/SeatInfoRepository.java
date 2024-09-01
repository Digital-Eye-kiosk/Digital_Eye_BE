package DigitalEye.demo.repository;


import DigitalEye.demo.domain.KTXSeat;
import DigitalEye.demo.domain.NonKTXSeat;
import DigitalEye.demo.domain.Train;
import jakarta.persistence.EntityNotFoundException;
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
        System.out.println("trainType : " + trainType);

        if(trainType != null && trainType.contains("KTX")) {
            return true;
        } else {
            return false;
        }
    }


    public KTXSeat findKTXSeat(long id) {
        KTXSeat ktxSeat = ktxRepository.findByTrain_Id(id);
        return ktxSeat;
    }

    public NonKTXSeat findNonKTXSeat(long id) {
        NonKTXSeat nonKTXSeat = nonKTXRepository.findByTrain_Id(id);
        return nonKTXSeat;
    }
}
