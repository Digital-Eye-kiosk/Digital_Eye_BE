package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.RegionRequestDto;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ArrivalRegionDb {
    public static User arrivalRegionDb(UserRepository userRepository, RegionRequestDto regionRequestDto, int cityCode) {
        User user = userRepository.findById(regionRequestDto.id())
                .orElseThrow(() -> new RuntimeException());
        user.updateArrRegion(cityCode);
        //db 에러처리

        return user;
    }
}

