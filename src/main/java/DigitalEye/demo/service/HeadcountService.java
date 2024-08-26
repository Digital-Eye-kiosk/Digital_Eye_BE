package DigitalEye.demo.service;

import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.voice.HeadcountResponseDto;
import DigitalEye.demo.repository.UserRepository;
import DigitalEye.demo.domain.User;
import DigitalEye.demo.service.db.HeadcountDb;
import DigitalEye.demo.service.stt.SttService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class HeadcountService {

    private final SttService sttService;
    private final HeadcountDb headcountDb;
    private final UserRepository userRepository;

    @Transactional
    public HeadcountResponseDto headcountVoiceService(OnlyIdRequestDto onlyIdRequestDto) {
        // STT 실행하여 음성 인식을 통해 문자열 결과를 얻음
        String result = sttService.recognizeSpeechFor5Seconds();

        // 문자열 결과에서 성인, 어린이, 노인, 장애인 인원수를 추출
        int[] counts = extractCounts(result);
        if (counts == null || counts.length != 4) {
            throw new IllegalArgumentException("Invalid voice input");
        }

        // 데이터베이스에 업데이트
        User updatedUser = headcountDb.headcountVoiceDb(userRepository,onlyIdRequestDto, counts[0], counts[1], counts[2], counts[3]);

        // DTO로 변환하여 반환
        return HeadcountResponseDto.of(
                updatedUser.getId(), updatedUser.getAdult(), updatedUser.getChild(),
                updatedUser.getSenior(), updatedUser.getDisable());
    }

    // 음성 인식 결과 문자열에서 숫자를 추출하여 인원수로 변환
    private int[] extractCounts(String input) {
        Pattern pattern = Pattern.compile("(\\d+)명");
        Matcher matcher = pattern.matcher(input);

        int[] counts = new int[4];
        int index = 0;

        while (matcher.find()) {
            if (index < 4) {
                counts[index] = Integer.parseInt(matcher.group(1));
                index++;
            }
        }

        return index == 4 ? counts : null;
    }
}
