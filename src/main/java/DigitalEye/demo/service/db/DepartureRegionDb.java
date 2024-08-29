package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.repository.UserRepository;

import static DigitalEye.demo.domain.User.from;

public class DepartureRegionDb {
    public static User departureRegionDb(UserRepository userRepository, int cityCode) {
        User user = from(cityCode);
        User savedUser = userRepository.save(user);
        //db 에러처리

        return savedUser;
    }
}