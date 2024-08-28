package DigitalEye.demo.service;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.voice.ConfirmResponseDto;
import DigitalEye.demo.repository.UserRepository;
import DigitalEye.demo.service.db.ConfirmDb;
import DigitalEye.demo.service.stt.SttService;

public class ConfirmService {
    private static SttService sttService;
    private static ConfirmDb confirmDb;
    private static UserRepository userRepository;

    public ConfirmService(SttService sttService, ConfirmDb confirmDb, UserRepository userRepository) {
        this.sttService = sttService;
        this.confirmDb = confirmDb;
        this.userRepository = userRepository;
    }

    public ConfirmResponseDto confirmService(OnlyIdRequestDto onlyIdRequestDto){
        // STT 실행하여 음성 인식을 통해 문자열 결과를 얻음
        String result = sttService.recognizeSpeechFor5Seconds();
        //check변수 설정
        int check = 0;

        if (result.contains("네") || result.contains("예")) {
            check = 1;
            //check가 1인 경우에만 Db update
            User updatedUser = confirmDb.confirmVoiceDb(userRepository, onlyIdRequestDto, check);
        } else if (result.contains("아니요") || result.contains("아니오")) {
            check = 2;
        }

        // DTO로 변환하여 반환
        return ConfirmResponseDto.of(onlyIdRequestDto.id(), check);
    }
}
