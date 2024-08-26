package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.SeatsRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SeatsDb {
    public static User seatsNormalDb(UserRepository userRepository, SeatsRequestDto seatsRequestDto) {
        // 사용자 ID로 User 엔티티를 조회합니다.
        User user = userRepository.findById(seatsRequestDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 선택된 좌석 리스트를 가져옵니다.
        List<String> seatNumbers = seatsRequestDto.selectSit().stream()
                .map(SeatsRequestDto.Sit::sitNum)
                .collect(Collectors.toList());

        // seat_number 필드를 업데이트합니다. (좌석 번호를 콤마로 구분된 문자열로 저장)
        String seatNumberString = String.join(",", seatNumbers);
        user.setSeatNumber(seatNumberString);

        // 변경 사항을 저장하고 업데이트된 User 객체를 반환합니다.
        return userRepository.save(user);
    }
    public static User seatsVoiceDb(UserRepository userRepository, OnlyIdRequestDto onlyIdRequestDto,List<SeatsRequestDto.Sit> sitList){
        // 사용자 ID로 User 엔티티를 조회합니다.
        User user = userRepository.findById(onlyIdRequestDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // 좌석 번호 리스트를 문자열로 변환하여 저장
        String seatNumberString = sitList.stream()
                .map(SeatsRequestDto.Sit::sitNum)
                .collect(Collectors.joining(", "));

        // User 엔티티에 좌석 번호 업데이트
        user.setSeatNumber(seatNumberString);

        // 변경 사항을 저장하고 업데이트된 User 객체를 반환합니다.
        return userRepository.save(user);
    }
}
