package digitaleye.demo.service.db;

import digitaleye.demo.domain.User;
import digitaleye.demo.dto.request.normal.ArrivalRegionRequestDto;
import digitaleye.demo.repository.UserRepository;

public class ArrivalRegionDb {
    public static User arrivalRegionDb(UserRepository userRepository, ArrivalRegionRequestDto arrivalRegionRequestDto, int cityCode) {
        User user = userRepository.findById(arrivalRegionRequestDto.id())
                .orElseThrow(() -> new RuntimeException());
        user.updateArrRegion(cityCode);
        //db 에러처리

        return user;
    }
}
