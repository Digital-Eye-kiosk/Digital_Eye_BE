package DigitalEye.demo.repository;

import DigitalEye.demo.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findByTrainNumAndDate(int trainNum, String date);
}