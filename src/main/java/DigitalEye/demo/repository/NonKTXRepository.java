package DigitalEye.demo.repository;

import DigitalEye.demo.domain.NonKTXSeat;
import DigitalEye.demo.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonKTXRepository extends JpaRepository<NonKTXSeat, Long> {
}
