package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.HeadcountRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.repository.UserRepository;

public class HeadcountDb {
    public static User headcountNormalDb(UserRepository userRepository, HeadcountRequestDto headcountRequestDto,
                                         int adult, int child, int senior, int disable           ) {
        User user = userRepository.findById(headcountRequestDto.id())
                .orElseThrow(() -> new RuntimeException());

        user.setAdult(adult);
        user.setChild(child);
        user.setSenior(senior);
        user.setDisable(disable);
        //업데이트된 객체 savedUser로 반환해주기 위해
        User savedUser = userRepository.save(user);
        // db 에러 처리 (필요한 경우)

        return savedUser;
    }
    public User headcountVoiceDb(UserRepository userRepository, OnlyIdRequestDto onlyIdRequestDto
            , int adult, int child, int senior, int disable) {
        User user = userRepository.findById(onlyIdRequestDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // User 엔티티의 필드 업데이트
        user.setAdult(adult);
        user.setChild(child);
        user.setSenior(senior);
        user.setDisable(disable);

        // 업데이트된 User 엔티티를 저장
        return userRepository.save(user);
    }
}
