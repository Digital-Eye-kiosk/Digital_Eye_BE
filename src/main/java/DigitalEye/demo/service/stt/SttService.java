package DigitalEye.demo.service.stt;

public class SttService {
    public String recognizeSpeechFor5Seconds() {
        String transcript = "";
        try {
            // 5초 동안 STT 실행
            transcript = StreamingSpeechRecognizer.streamingMicRecognize(5);
        } catch (Exception e) {
            e.printStackTrace(); // 오류 발생 시 처리
        }
        return transcript;
    }
}
