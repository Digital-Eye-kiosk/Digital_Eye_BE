package DigitalEye.demo.controller.both;

import DigitalEye.demo.dto.request.both.FinalChoiceRequestDto;
import DigitalEye.demo.dto.request.both.StationGetRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.FinalChoiceResponseDto;
import DigitalEye.demo.dto.response.both.StationGetResponseDto;
import DigitalEye.demo.dto.response.both.TrainResponseDto;
import DigitalEye.demo.dto.response.both.UsertableResetResponseDto;
import DigitalEye.demo.service.FinalChoiceService;
import DigitalEye.demo.service.StationGetService;
import DigitalEye.demo.service.TrainService;
import DigitalEye.demo.service.UsertableResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BothController {
    private final TrainService trainService;
    private final StationGetService stationGetService;
    private final FinalChoiceService finalChoiceService;

    @Transactional
    @GetMapping("/api/both/trains")
    public ResponseEntity<?> train(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        List<TrainResponseDto> trains = trainService.getTrains(onlyIdRequestDto);

        return ResponseEntity.ok(trains);
    }
    @Transactional
    @GetMapping("/api/both/station")
    public ResponseEntity<List<StationGetResponseDto>> train(@RequestBody StationGetRequestDto stationGetRequestDto) {
        try {
            List<StationGetResponseDto> stations = stationGetService.stationService(stationGetRequestDto);
            return ResponseEntity.ok(stations);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Transactional
    @GetMapping("/api/both/choice")
    public FinalChoiceResponseDto train(@RequestBody FinalChoiceRequestDto finalChoiceRequestDto) {

       FinalChoiceResponseDto finalChoiceResponseDto = finalChoiceService.getFinalChoiceResponse(finalChoiceRequestDto.train_table_id(), finalChoiceRequestDto.id());
       return ResponseEntity.ok(finalChoiceResponseDto).getBody();

    }

    @Transactional
    @DeleteMapping("/api/reset")
    public ResponseEntity<?> usertableDelete(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        //서비스 호출 - 서비스에서 stt실행,db저장, Dto로 반환
        UsertableResetResponseDto usertableResetResponseDto = UsertableResetService.usertableResetService(onlyIdRequestDto);

        //ResponseEntity 반환 - HTTP형태
        return ResponseEntity.ok(usertableResetResponseDto);
    }

}