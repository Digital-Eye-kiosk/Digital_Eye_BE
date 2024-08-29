//package digitaleye.demo.controller.voice;
//
//import digitaleye.demo.dto.request.normal.TrainChoiceRequestDto;
//import digitaleye.demo.dto.request.voice.IdRequestDto;
//import digitaleye.demo.dto.response.voice.TrainChoiceResponseDto;
//import digitaleye.demo.dto.response.voice.TrainFinalChoiceResponseDto;
//import digitaleye.demo.service.voice.TrainChoiceService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class TrainChoiceController {
//    private final TrainChoiceService trainChoiceService;
//
//    @GetMapping("/api/audio/trains")
//    public ResponseEntity<?> trainTypeAndTimeChoice(@RequestBody IdRequestDto idRequestDto) {
//        List<TrainChoiceResponseDto> filteredTrains = trainChoiceService.trainChoice1(idRequestDto);
//
//        return ResponseEntity.ok(filteredTrains);
//    }
//
//    @PostMapping("/api/audio/trains/time")
//    public ResponseEntity<?> trainChoice(@RequestBody List<TrainChoiceRequestDto> trainChoiceRequestDtos) {
//        TrainFinalChoiceResponseDto filteredTrain = trainChoiceService.trainChoice2(trainChoiceRequestDtos);
//
//        return ResponseEntity.ok(filteredTrain);
//    }
//}