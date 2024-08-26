package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.ArrivalRegionRequestDto;
import DigitalEye.demo.repository.UserRepository;

public class ArrivalRegionDb {
    public static User arrivalRegionDb(UserRepository userRepository, ArrivalRegionRequestDto arrivalRegionRequestDto, int cityCode) {
        User user = userRepository.findById(arrivalRegionRequestDto.id())
                .orElseThrow(() -> new RuntimeException());
        user.updateArrRegion(cityCode);
        //db 에러처리

        return user;
    }
}

