package digitaleye.demo.repository;

import digitaleye.demo.domain.KTXSeat;
import digitaleye.demo.domain.NonKTXSeat;
import digitaleye.demo.domain.Train;
import digitaleye.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class TrainChoiceRepository {
    private final UserRepository userRepository;
    public final TrainRepository trainRepository;
    public final KTXRepository ktxRepository;
    public final NonKTXRepository nonKTXRepository;


    public TrainChoiceRepository(UserRepository userRepository, TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
        this.userRepository = userRepository;
        this.trainRepository = trainRepository;
        this.ktxRepository = ktxRepository;
        this.nonKTXRepository = nonKTXRepository;
    }

    public User findUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        return user;
    }

    public Train findTrain(int trainNum, String date) {
        Train train = trainRepository.findByTrainNumAndDate(trainNum, date);

        return train;
    }

    public Train makeTrain(String trainType,
                           int trainNum,
                           String depStation,
                           String arrStation,
                           String date,
                           String depTime,
                           String arrTime,
                           int price,
                           boolean soldOut) {
        Train train = Train.from(trainType,trainNum, depStation, arrStation, date, depTime, arrTime, price, soldOut);
        Train savedTrain = trainRepository.save(train);
        //db 에러처리

        return savedTrain;
    }

    public KTXSeat makeKTXSeat(Train train) {
        KTXSeat ktxSeat = KTXSeat.from(train);
        KTXSeat savedKTXSeat = ktxRepository.save(ktxSeat);
        //db 에러처리

        return savedKTXSeat;
    }

    public NonKTXSeat makeNonKTXSeat(Train train) {
        NonKTXSeat nonKTXSeat = NonKTXSeat.from(train);
        NonKTXSeat savedNonKTXSeat = nonKTXRepository.save(nonKTXSeat);
        //db 에러처리

        return savedNonKTXSeat;
    }
}
