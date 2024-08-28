package digitaleye.demo.repository;

import digitaleye.demo.domain.NonKTXSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonKTXRepository extends JpaRepository<NonKTXSeat, Long> {
    NonKTXSeat findByTrainId(long id);
}