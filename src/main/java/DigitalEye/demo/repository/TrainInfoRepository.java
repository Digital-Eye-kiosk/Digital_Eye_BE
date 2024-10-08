package DigitalEye.demo.repository;

import DigitalEye.demo.domain.Train;
import DigitalEye.demo.domain.User;

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

    public void updateSoldOut() {

    }


}
