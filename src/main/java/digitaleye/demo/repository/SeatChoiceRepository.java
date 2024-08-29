package digitaleye.demo.repository;

import digitaleye.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class SeatChoiceRepository {
    private final UserRepository userRepository;

    public SeatChoiceRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        return user;
    }
}
