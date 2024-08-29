package digitaleye.demo.repository;

import digitaleye.demo.domain.Train;
import digitaleye.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class TrainInfoRepository {
    private final UserRepository userRepository;
    private final TrainRepository trainRepository;

    public TrainInfoRepository(UserRepository userRepository, TrainRepository trainRepository) {
        this.userRepository = userRepository;
        this.trainRepository = trainRepository;
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

    public boolean getSoldOut(int trainNum, String date) {
        Train train = findTrain(trainNum, date);
        if(train == null) {
            return false;
        }
        else {
            return train.isSoldOut();
        }
    }
}