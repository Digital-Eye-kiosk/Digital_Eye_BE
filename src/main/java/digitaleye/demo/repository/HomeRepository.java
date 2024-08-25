package digitaleye.demo.repository;

import digitaleye.demo.domain.User;

public class HomeRepository {
    private final UserRepository userRepository;

    public HomeRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User makeUser(int option) {
        User user = User.from(option);
        User savedUser = userRepository.save(user);
        //db 에러처리

        return savedUser;
    }
}
