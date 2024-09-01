package DigitalEye.demo.repository;

import DigitalEye.demo.domain.KTXSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KTXRepository extends JpaRepository<KTXSeat, Long> {
    KTXSeat findByTrain_Id(long trainId);
}
