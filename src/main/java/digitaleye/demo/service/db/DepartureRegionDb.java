package digitaleye.demo.service.db;

import digitaleye.demo.domain.User;
import digitaleye.demo.repository.UserRepository;

public class DepartureRegionDb {
    public static User departureRegionDb(UserRepository userRepository, int cityCode) {
        User user = User.from(cityCode);
        User savedUser = userRepository.save(user);
        //db 에러처리

        return savedUser;
    }
}
