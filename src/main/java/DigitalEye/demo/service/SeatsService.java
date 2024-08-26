package DigitalEye.demo.service;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.SeatsRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.voice.SeatsResponseDto;
import DigitalEye.demo.repository.UserRepository;
import DigitalEye.demo.service.db.SeatsDb;
import DigitalEye.demo.service.stt.SttService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class SeatsService {
    private final SttService sttService;
    private final SeatsDb seatsDb;
    private final UserRepository userRepository;

    @Transactional
    public SeatsResponseDto seatsService(OnlyIdRequestDto onlyIdRequestDto){
        // STT 실행하여 음성 인식을 통해 문자열 결과를 얻음
        String result = sttService.recognizeSpeechFor5Seconds();
        // 문자열 결과에서 좌석번호 추출
        List<SeatsRequestDto.Sit> sitList = extractSitNumbers(result);

        // 데이터베이스에 저장
        User updatedUser = seatsDb.seatsVoiceDb(userRepository, onlyIdRequestDto, sitList);

        // DTO로 변환하여 반환
        return SeatsResponseDto.of(updatedUser.getId(), sitList);
    }
    // 문자열에서 좌석번호 추출
    private List<SeatsRequestDto.Sit> extractSitNumbers(String input) {
        List<SeatsRequestDto.Sit> sitList = new ArrayList<>();
        Pattern pattern = Pattern.compile("([A-F][0-10]+)"); // A-F로 시작하는 숫자 조합 패턴
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String sitNum = matcher.group(1);
            sitList.add(new SeatsRequestDto.Sit(sitNum));
        }

        return sitList;
    }
}
