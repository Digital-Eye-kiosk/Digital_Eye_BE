package DigitalEye.demo.controller.both;

import DigitalEye.demo.dto.request.both.FinalChoiceRequestDto;
import DigitalEye.demo.dto.request.both.StationGetRequestDto;
import DigitalEye.demo.dto.request.both.TrainIdRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.*;
import DigitalEye.demo.service.*;
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
    private final ReturnTableService returnTableService;
    private final SeatService seatService;



    @GetMapping("/api/both/users") //user_table확인용 api
    public ResponseEntity<?> user(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        UserTableResponseDto userTableResponseDto = returnTableService.returnUserTableService(onlyIdRequestDto);
        return ResponseEntity.ok(userTableResponseDto);
    }


    @GetMapping("/api/both/trainTable") //train_table확인용 api
    public ResponseEntity<?> train_table(@RequestBody TrainIdRequestDto trainIdRequestDto) {
        TrainTableResponseDto trainTableResponseDto = returnTableService.returnTrainTableService(trainIdRequestDto);
        return ResponseEntity.ok(trainTableResponseDto);
    }


    @GetMapping("/api/both/trains")
    public ResponseEntity<?> train(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        List<TrainResponseDto> trains = trainService.getTrains(onlyIdRequestDto);

        return ResponseEntity.ok(trains);
    }

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

    @GetMapping("/api/both/choice")
    public FinalChoiceResponseDto train(@RequestBody FinalChoiceRequestDto finalChoiceRequestDto) {

       FinalChoiceResponseDto finalChoiceResponseDto = finalChoiceService.getFinalChoiceResponse(finalChoiceRequestDto.train_table_id(), finalChoiceRequestDto.id());
       return ResponseEntity.ok(finalChoiceResponseDto).getBody();

    }


    @DeleteMapping("/api/reset")
    public ResponseEntity<?> usertableDelete(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        //서비스 호출 - 서비스에서 stt실행,db저장, Dto로 반환
        UsertableResetResponseDto usertableResetResponseDto = UsertableResetService.usertableResetService(onlyIdRequestDto);

        //ResponseEntity 반환 - HTTP형태
        return ResponseEntity.ok(usertableResetResponseDto);
    }
    @GetMapping("/api/both/seats")
    public ResponseEntity<?> seat(@RequestBody TrainIdRequestDto trainIdRequestDto) {
        SeatDto seatDto = seatService.getSeats(trainIdRequestDto);

        return ResponseEntity.ok(seatDto);
    }

}