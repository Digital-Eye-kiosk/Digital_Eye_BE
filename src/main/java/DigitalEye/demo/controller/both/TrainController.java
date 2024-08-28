package DigitalEye.demo.controller.both;

import DigitalEye.demo.dto.request.both.StationGetRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.StationGetResponseDto;
import DigitalEye.demo.dto.response.both.TrainResponseDto;
import DigitalEye.demo.service.StationGetService;
import DigitalEye.demo.service.StationService;
import DigitalEye.demo.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;
    private final StationGetService stationGetService;

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

}