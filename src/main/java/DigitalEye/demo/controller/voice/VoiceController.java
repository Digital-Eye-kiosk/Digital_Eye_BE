package DigitalEye.demo.controller.voice;


import DigitalEye.demo.dto.request.voice.ConfirmRequestVoiceDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.request.voice.SeatsRequestVoiceDto;
import DigitalEye.demo.dto.response.voice.ConfirmResponseDto;
import DigitalEye.demo.dto.response.voice.DateSelectionResponseDto;
import DigitalEye.demo.dto.response.voice.HeadcountResponseDto;
import DigitalEye.demo.dto.response.voice.SeatsResponseDto;
import DigitalEye.demo.service.ConfirmService;
import DigitalEye.demo.service.DateSelectionService;
import DigitalEye.demo.service.HeadcountService;
import DigitalEye.demo.service.SeatsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VoiceController {

    private final HeadcountService headcountService;
    private final DateSelectionService dateSelectionService;
    private final SeatsService seatsService;
    private final ConfirmService confirmService;

    @Transactional
    @PatchMapping("/api/audio/headcount")
    public ResponseEntity<?> headcountVoice(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        //서비스 호출 - 서비스에서 stt실행,db저장, Dto로 반환
        HeadcountResponseDto headcountResponseDto = headcountService.headcountVoiceService(onlyIdRequestDto);
        //ResponseEntity 반환 - HTTP형태
        return ResponseEntity.ok(headcountResponseDto);
    }

    @Transactional
    @PatchMapping("/api/audio/date")
    public ResponseEntity<?> dateSelectionVoice(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        DateSelectionResponseDto dateSelectionResponseDto = dateSelectionService.DateSelectionVoiceService(onlyIdRequestDto);
        return ResponseEntity.ok(dateSelectionResponseDto);
    }
    @Transactional
    @PatchMapping("/api/audio/seats")
    public ResponseEntity<?> seatsVoice(@RequestBody SeatsRequestVoiceDto seatsRequestVoiceDto) {
        SeatsResponseDto seatsResponseDto = seatsService.seatsVoiceService(seatsRequestVoiceDto);
        return ResponseEntity.ok(seatsResponseDto);
    }
    @Transactional
    @PatchMapping("/api/audio/confirm")
    public ResponseEntity<?> confirmVoice(@RequestBody ConfirmRequestVoiceDto confirmRequestVoiceDto) {
        ConfirmResponseDto confirmResponseDto = confirmService.confirmVoiceService(confirmRequestVoiceDto);
        return ResponseEntity.ok(confirmResponseDto);
    }

}
