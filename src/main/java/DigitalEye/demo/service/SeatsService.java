package DigitalEye.demo.service;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.SeatsRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.request.voice.SeatsRequestVoiceDto;
import DigitalEye.demo.dto.response.normal.SeatsResponseNormalDto;
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
    private static final SeatsDb seatsDb = null;
    private static final UserRepository userRepository = null;

    @Transactional
    public static SeatsResponseNormalDto seatsNormalService(SeatsRequestDto seatsRequestDto){

        // 데이터베이스에 저장
        User updatedUser = seatsDb.seatsNormalDb(userRepository, seatsRequestDto);

        // DTO로 변환하여 반환
        return SeatsResponseNormalDto.of(seatsRequestDto.train_table_id());
    }
    @Transactional
    public SeatsResponseDto seatsVoiceService(SeatsRequestVoiceDto seatsRequestVoiceDto){
        // STT 실행하여 음성 인식을 통해 문자열 결과를 얻음
        String result = sttService.recognizeSpeechFor5Seconds();

        int choice;
        switch(result.trim()) {  // 문자열의 앞뒤 공백 제거 후 비교
            case "예":
            case "네":
                choice = 1;
                //DB에 정보 저장
                User user = seatsDb.seatsVoiceDb(userRepository,seatsRequestVoiceDto);
                break;
            case "아니요":
            case "아니오":
                choice = 2;
                break;
            default:
                choice = 0;
                break;
        }

        // DTO로 변환하여 반환
        return SeatsResponseDto.of(seatsRequestVoiceDto.train_table_id(), choice, seatsRequestVoiceDto.recommandSeat());
    }

}
