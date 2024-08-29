package DigitalEye.demo.repository;

import DigitalEye.demo.domain.KTXSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KTXRepository extends JpaRepository<KTXSeat, Long> {
}
