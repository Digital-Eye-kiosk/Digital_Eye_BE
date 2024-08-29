package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.repository.UserRepository;

public class UsertableResetDb {
    public static int usertableResetDb(UserRepository userRepository, OnlyIdRequestDto onlyIdRequestDto){
        try {
            // 사용자 ID로 User 엔티티를 조회합니다.
            User user = userRepository.findById(onlyIdRequestDto.id())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            user.setId(null);
            user.setOption(null);
            user.setDepRegion(null);
            user.setArrRegion(null);
            user.setDepStation(null);
            user.setArrStation(null);
            user.setDate(null);
            user.setSeatNumber(null);
            user.setAdult(null);
            user.setChild(null);
            user.setSenior(null);
            user.setDisable(null);
            user.setAdultPrice(null);
            user.setChildPrice(null);
            user.setSeniorPrice(null);
            user.setDisablePrice(null);

            return 1;
        }catch (Exception e) {
            // 예외가 발생하면 0을 반환합니다.
            return 0;
        }
    }
}
