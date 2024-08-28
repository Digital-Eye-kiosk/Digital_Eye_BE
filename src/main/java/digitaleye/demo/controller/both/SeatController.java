package digitaleye.demo.controller.both;

import digitaleye.demo.dto.request.both.TrainIdRequestDto;
import digitaleye.demo.dto.response.both.SeatDto;
import digitaleye.demo.service.both.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @GetMapping("/api/both/seats")
    public ResponseEntity<?> seat(@RequestBody TrainIdRequestDto trainIdRequestDto) {
        SeatDto seatDto = seatService.getSeats(trainIdRequestDto);

        return ResponseEntity.ok(seatDto);
    }
}