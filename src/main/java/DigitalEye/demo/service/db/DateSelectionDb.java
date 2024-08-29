package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.DateSelectionRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.repository.UserRepository;

public class DateSelectionDb {
    public static User dateSelectionNormalDb(UserRepository userRepository, DateSelectionRequestDto dateSelectionRequestDto) {
        User user = userRepository.findById(dateSelectionRequestDto.id())
                .orElseThrow(() -> new RuntimeException());

        // depDate를 month와 day를 조합하여 생성
        String depDate = dateSelectionRequestDto.month() + "-" + dateSelectionRequestDto.day();

        user.updateDate(depDate);
        // db 에러처리

        return user;
    }
    public static User dateSelectionVoiceDb(UserRepository userRepository, OnlyIdRequestDto onlyIdRequestDto, int month, int day) {
        User user = userRepository.findById(onlyIdRequestDto.id())
                .orElseThrow(() -> new RuntimeException());

        // depDate를 month와 day를 조합하여 생성
        String depDate = month + "-" + day;

        user.updateDate(depDate);
        // db 에러처리

        return user;
    }
}
