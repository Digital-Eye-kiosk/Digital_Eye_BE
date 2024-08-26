package digitaleye.demo.repository;

import digitaleye.demo.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findByTrainNumAndDate(int trainNum, String date);
}