//package digitaleye.demo.controller.voice;
//
//import digitaleye.demo.dto.request.voice.RecommendSeatRequestDto;
//import digitaleye.demo.dto.response.voice.RecommendSeatResponseDto;
//import digitaleye.demo.service.voice.RecommendSeatService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class SeatController {
//    private final RecommendSeatService recommendSeatService;
//
//    @GetMapping("/api/audio/recommend")
//    public ResponseEntity<?> seat(@RequestBody RecommendSeatRequestDto recommendSeatRequestDto) {
//        RecommendSeatResponseDto recommendSeatResponseDto = recommendSeatService.recommendSeat(recommendSeatRequestDto);
//
//        return ResponseEntity.ok(recommendSeatResponseDto);
//    }
//}