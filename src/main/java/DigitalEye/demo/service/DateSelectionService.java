package DigitalEye.demo.service;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.voice.DateSelectionResponseDto;
import DigitalEye.demo.repository.UserRepository;
import DigitalEye.demo.service.db.DateSelectionDb;
import DigitalEye.demo.service.stt.SttService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class DateSelectionService {
    private final SttService sttService;
    private final UserRepository userRepository;

    public DateSelectionResponseDto DateSelectionVoiceService(OnlyIdRequestDto onlyIdRequestDto) {
        //stt실행
        String result = sttService.recognizeSpeechFor5Seconds();
        //문자열에서 데이터 추출
        int[] dateInfo = extractMonthAndDay(result);

        //db에 업데이트
        User updatedUser = DateSelectionDb.dateSelectionVoiceDb(userRepository, onlyIdRequestDto, dateInfo[0],dateInfo[1]);
        //DTO로 변환하여 반환
        return DateSelectionResponseDto.of(updatedUser.getId(), dateInfo[0],dateInfo[1]);
    }
    //데이터 추출용 함수
    private int[] extractMonthAndDay(String input) {
        Pattern pattern = Pattern.compile("(\\d{1,2})월\\s*(\\d{1,2})일");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            int month = Integer.parseInt(matcher.group(1));
            int day = Integer.parseInt(matcher.group(2));
            return new int[]{month, day};
        }
        // 패턴이 맞지 않으면 음수 값을 반환
        return new int[]{-1, -1};
    }
}
