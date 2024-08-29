package digitaleye.demo.repository;

import digitaleye.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class StationRepository {
    private final UserRepository userRepository;

    public StationRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        return user;
    }

    public int getDepRegion(User user) {
        return user.getDepRegion();
    }

    public int getArrRegion(User user) {
        return user.getArrRegion();
    }

    public User updateDepRegion(User user, int cityCode) {
        user.updateDepRegion(cityCode);
        User savedUser = userRepository.save(user);
        //db 에러처리

        return savedUser;
    }
    public User updateArrRegion(User user, int cityCode) {
        user.updateArrRegion(cityCode);
        User savedUser = userRepository.save(user);
        //db 에러처리

        return savedUser;
    }

    public User updateDepStation(User user, String stationCode) {
        user.updateDepStation(stationCode);;
        User savedUser = userRepository.save(user);
        //db 에러처리

        return savedUser;
    }

    public User updateArrStation(User user, String stationCode) {
        user.updateArrStation(stationCode);;
        User savedUser = userRepository.save(user);
        //db 에러처리

        return savedUser;
    }
}