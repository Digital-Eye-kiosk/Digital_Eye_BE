package DigitalEye.demo.service;

import DigitalEye.demo.dto.request.voice.ConfirmRequestVoiceDto;
import DigitalEye.demo.dto.response.voice.ConfirmResponseDto;
import DigitalEye.demo.repository.TrainRepository;
import DigitalEye.demo.service.db.ConfirmDb;
import DigitalEye.demo.service.stt.SttService;
import org.springframework.stereotype.Service;

@Service
public class ConfirmService {
    private static SttService sttService;
    private static ConfirmDb confirmDb;
    private static  TrainRepository trainRepository;

    public ConfirmService(SttService sttService, ConfirmDb confirmDb,TrainRepository trainRepository) {
        this.sttService = sttService;
        this.confirmDb = confirmDb;
        this.trainRepository = trainRepository;
    }

    public ConfirmResponseDto confirmVoiceService(ConfirmRequestVoiceDto confirmRequestVoiceDto){
        // STT 실행하여 음성 인식을 통해 문자열 결과를 얻음
        String result = sttService.recognizeSpeechFor5Seconds();
        //check변수 설정
        int check = 0;

        if (result.contains("네") || result.contains("예")) {
            check = 1;
            //check가 1인 경우에만 Db update
            confirmDb.confirmVoiceDb(trainRepository, confirmRequestVoiceDto);
        } else if (result.contains("아니요") || result.contains("아니오")) {
            check = 2;
        }

        // DTO로 변환하여 반환
        return ConfirmResponseDto.of(check);
    }
}
