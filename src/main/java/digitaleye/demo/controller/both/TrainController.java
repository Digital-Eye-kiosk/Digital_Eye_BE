package digitaleye.demo.controller.both;

import digitaleye.demo.dto.request.normal.station.RegionRequestDto;
import digitaleye.demo.dto.request.voice.IdRequestDto;
import digitaleye.demo.dto.response.both.TrainResponseDto;
import digitaleye.demo.dto.response.normal.UserIdResponseDto;
import digitaleye.demo.repository.TrainInfoRepository;
import digitaleye.demo.repository.TrainRepository;
import digitaleye.demo.service.both.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @Transactional
    @GetMapping("/api/both/trains")
    public ResponseEntity<?> train(@RequestBody IdRequestDto idRequestDto) {
        List<TrainResponseDto> trains = trainService.getTrains(idRequestDto);

        return ResponseEntity.ok(trains);
    }
}