package DigitalEye.demo.controller.voice;

import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.voice.RegionResponseDto;
import DigitalEye.demo.dto.response.voice.StationResponseDto;
import DigitalEye.demo.service.StationServiceVoice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StationController {
    private StationServiceVoice stationServiceVoice;

    @PatchMapping("/api/audio/departure/regions")
    public ResponseEntity<?> departureRegion(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        RegionResponseDto regionResponseDto = stationServiceVoice.updateDepartureRegion(onlyIdRequestDto);

        return ResponseEntity.ok(regionResponseDto);
    }

    @PatchMapping("/api/audio/arrival/regions")
    public ResponseEntity<?> arrivalRegion (@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        RegionResponseDto regionResponseDto = stationServiceVoice.updateArrivalRegion(onlyIdRequestDto);

        return ResponseEntity.ok(regionResponseDto);
    }

    @PostMapping("/api/audio/departure")
    public ResponseEntity<?> departureStation (@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        StationResponseDto stationResponseDto = stationServiceVoice.updateDepartureStation(onlyIdRequestDto);

        return ResponseEntity.ok(stationResponseDto);
    }

    @PostMapping("/api/audio/arrival")
    public ResponseEntity<?> arrivalStation (@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        StationResponseDto stationResponseDto = stationServiceVoice.updateArrivalStation(onlyIdRequestDto);

        return ResponseEntity.ok(stationResponseDto);
    }
}
