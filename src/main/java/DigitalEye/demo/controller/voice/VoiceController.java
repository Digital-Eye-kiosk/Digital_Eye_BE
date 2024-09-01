package DigitalEye.demo.controller.voice;


import DigitalEye.demo.dto.request.normal.TrainChoiceRequestDto;
import DigitalEye.demo.dto.request.voice.ConfirmRequestVoiceDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.request.voice.RecommendSeatRequestDto;
import DigitalEye.demo.dto.request.voice.SeatsRequestVoiceDto;
import DigitalEye.demo.dto.response.voice.*;
import DigitalEye.demo.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VoiceController {

    private final HeadcountService headcountService;
    private final DateSelectionService dateSelectionService;
    private final SeatsService seatsService;
    private final ConfirmService confirmService;
    private final RecommendSeatService recommendSeatService;

    private final TrainChoiceService trainChoiceService;

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
    @GetMapping("/api/audio/recommend")
    public ResponseEntity<?> seat(@RequestBody RecommendSeatRequestDto recommendSeatRequestDto) {
        RecommendSeatResponseDto recommendSeatResponseDto = recommendSeatService.recommendSeat(recommendSeatRequestDto);

        return ResponseEntity.ok(recommendSeatResponseDto);
    }
    @GetMapping("/api/audio/trains")
    public ResponseEntity<?> trainTypeAndTimeChoice(@RequestBody OnlyIdRequestDto idRequestDto) {
        List<TrainChoiceResponseDto> filteredTrains = trainChoiceService.trainChoice1(idRequestDto);

        return ResponseEntity.ok(filteredTrains);
    }

    @PostMapping("/api/audio/trains/time")
    public ResponseEntity<?> trainChoice(@RequestBody List<TrainChoiceRequestDto> trainChoiceRequestDtos) {
        TrainFinalChoiceResponseDto filteredTrain = trainChoiceService.trainChoice2(trainChoiceRequestDtos);

        return ResponseEntity.ok(filteredTrain);
    }

}
