//package digitaleye.demo.controller.voice;
//
//import digitaleye.demo.dto.request.voice.IdRequestDto;
//import digitaleye.demo.dto.response.voice.RegionResponseDto;
//import digitaleye.demo.dto.response.voice.StationResponseDto;
//import digitaleye.demo.repository.UserRepository;
//import digitaleye.demo.service.voice.StationService;
//import digitaleye.demo.service.stt.SpeechToTextService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class StationController {
//    private UserRepository userRepository;
//    private StationService stationService;
//
//    @Transactional
//    @PatchMapping("/api/audio/departure/regions")
//    public ResponseEntity<?> departureRegion(@RequestBody IdRequestDto idRequestDto) {
//        RegionResponseDto regionResponseDto = stationService.updateDepartureRegion(idRequestDto);
//
//        return ResponseEntity.ok(regionResponseDto);
//    }
//
//    @Transactional
//    @PatchMapping("/api/audio/arrival/regions")
//    public ResponseEntity<?> arrivalRegion (@RequestBody IdRequestDto idRequestDto) {
//        RegionResponseDto regionResponseDto = stationService.updateArrivalRegion(idRequestDto);
//
//        return ResponseEntity.ok(regionResponseDto);
//    }
//
//    @Transactional
//    @PostMapping("/api/audio/departure")
//    public ResponseEntity<?> departureStation (@RequestBody IdRequestDto idRequestDto) {
//        StationResponseDto stationResponseDto = stationService.updateDepartureStation(idRequestDto);
//
//        return ResponseEntity.ok(stationResponseDto);
//    }
//
//    @PostMapping("/api/audio/arrival")
//    public ResponseEntity<?> arrivalStation (@RequestBody IdRequestDto idRequestDto) {
//        StationResponseDto stationResponseDto = stationService.updateArrivalStation(idRequestDto);
//
//        return ResponseEntity.ok(stationResponseDto);
//    }
//}
