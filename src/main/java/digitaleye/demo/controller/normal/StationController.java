package digitaleye.demo.controller.normal;

import digitaleye.demo.domain.User;
import digitaleye.demo.dto.request.normal.station.RegionRequestDto;
import digitaleye.demo.dto.request.normal.station.StationRequestDto;
import digitaleye.demo.dto.response.normal.UserIdResponseDto;
import digitaleye.demo.service.normal.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @PatchMapping("/api/basic/departure/regions")
    public ResponseEntity<?> departureRegion(@RequestBody RegionRequestDto RegionRequestDto) {
        User user = stationService.updateDepartureRegion(RegionRequestDto);

        return ResponseEntity.ok(UserIdResponseDto.of(user.getId()));
    }

    @PatchMapping("/api/basic/arrival/regions")
    public ResponseEntity<?> arrivalRegion(@RequestBody RegionRequestDto RegionRequestDto) {
        User user = stationService.updateArrivalRegion(RegionRequestDto);

        return ResponseEntity.ok(UserIdResponseDto.of(user.getId()));
    }

    @PatchMapping("/api/basic/departure")
    public ResponseEntity<?> departureStation(@RequestBody StationRequestDto StationRequestDto) {
        User user = stationService.updateDepartureStation(StationRequestDto);

        return ResponseEntity.ok(UserIdResponseDto.of(user.getId()));
    }

    @PatchMapping("/api/basic/arrival")
    public ResponseEntity<?> arrivalStation(@RequestBody StationRequestDto StationRequestDto) {
        User user = stationService.updateArrivalStation(StationRequestDto);

        return ResponseEntity.ok(UserIdResponseDto.of(user.getId()));
    }
}
