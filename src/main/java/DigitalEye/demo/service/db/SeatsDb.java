package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.SeatsRequestDto;
import DigitalEye.demo.dto.request.voice.SeatsRequestVoiceDto;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SeatsDb {
    public static User seatsNormalDb(UserRepository userRepository, SeatsRequestDto seatsRequestDto) {
        // 사용자 ID로 User 엔티티를 조회합니다.
        User user = userRepository.findById(seatsRequestDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        //DB업데이트
        user.setSeatNumber(seatsRequestDto.seat());

        // 변경 사항을 저장하고 업데이트된 User 객체를 반환합니다.
        return userRepository.save(user);
    }
    public static User seatsVoiceDb(UserRepository userRepository, SeatsRequestVoiceDto seatsRequestVoiceDto){
        // 사용자 ID로 User 엔티티를 조회합니다.
        User user = userRepository.findById(seatsRequestVoiceDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        //DB업데이트
        user.setSeatNumber(seatsRequestVoiceDto.recommandSeat());

        return userRepository.save(user);
    }
}
