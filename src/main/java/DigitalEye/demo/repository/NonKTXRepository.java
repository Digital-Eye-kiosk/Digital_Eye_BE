package DigitalEye.demo.repository;

import DigitalEye.demo.domain.KTXSeat;
import DigitalEye.demo.domain.NonKTXSeat;
import DigitalEye.demo.domain.Train;
import org.checkerframework.checker.units.qual.K;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NonKTXRepository extends JpaRepository<NonKTXSeat, Long> {
    NonKTXSeat findByTrain_Id(long id);
}
