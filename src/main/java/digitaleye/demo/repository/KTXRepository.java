package digitaleye.demo.repository;

import digitaleye.demo.domain.KTXSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KTXRepository extends JpaRepository<KTXSeat, Long> {
    KTXSeat findByTrainId(long id);
}