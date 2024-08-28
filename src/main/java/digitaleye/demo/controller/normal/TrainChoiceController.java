package digitaleye.demo.controller.normal;

import digitaleye.demo.dto.request.normal.TrainChoiceRequestDto;
import digitaleye.demo.dto.response.normal.TrainIdResponseDto;
import digitaleye.demo.service.normal.TrainChoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrainChoiceController {
    private final TrainChoiceService trainChoiceService;

    @PostMapping("/api/basic/trains")
    public ResponseEntity<?> trainChoice(@RequestBody TrainChoiceRequestDto trainChoiceRequestDto) {
        Long id = trainChoiceService.trainChoice(trainChoiceRequestDto);

        return ResponseEntity.ok(TrainIdResponseDto.of(id));
    }
}
