package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.DateSelectionRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DateSelectionDb {
    public static User dateSelectionNormalDb(UserRepository userRepository, DateSelectionRequestDto dateSelectionRequestDto) {
        User user = userRepository.findById(dateSelectionRequestDto.id())
                .orElseThrow(() -> new RuntimeException());

        // date를 year, month, day를 조합하여 생성
        String date = String.valueOf(dateSelectionRequestDto.year())  + String.valueOf(dateSelectionRequestDto.month()) + String.valueOf(dateSelectionRequestDto.day());

        user.updateDate(date);
        // db 에러처리

        return user;
    }
    public static User dateSelectionVoiceDb(UserRepository userRepository, OnlyIdRequestDto onlyIdRequestDto,int year ,int month, int day) {
        User user = userRepository.findById(onlyIdRequestDto.id())
                .orElseThrow(() -> new RuntimeException());

        // depDate를 month와 day를 조합하여 생성
        String date = String.valueOf(year)  + String.valueOf(month) + String.valueOf(day);

        user.updateDate(date);
        // db 에러처리

        return user;
    }
}
