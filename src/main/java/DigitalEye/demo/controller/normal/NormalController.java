package DigitalEye.demo.controller.normal;


import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.*;
import DigitalEye.demo.dto.response.normal.OnlyIdResponseDto;
import DigitalEye.demo.dto.response.normal.SeatsResponseNormalDto;
import DigitalEye.demo.dto.response.normal.TrainIdResponseDto;
import DigitalEye.demo.repository.TrainRepository;
import DigitalEye.demo.repository.UserRepository;
import DigitalEye.demo.service.*;
import DigitalEye.demo.service.db.ConfirmDb;
import DigitalEye.demo.service.db.DateSelectionDb;
import DigitalEye.demo.service.db.HeadcountDb;
import DigitalEye.demo.service.db.SeatsDb;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class NormalController {

    private final UserRepository userRepository;
    private final TrainRepository trainRepository;
    private final StationService stationService;
    private final HomeService homeService;
    private final TrainChoiceServiceNormal trainChoiceService;


    @PostMapping("/api/basic/home")
    public ResponseEntity<?> homeNormal() {
        int option = 0;
        User user = homeService.saveOptionNormal(option);
        //id 값을 보냄
        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }


    @PatchMapping("/api/basic/departure/regions")
    public ResponseEntity<?> departureRegion(@RequestBody RegionRequestDto RegionRequestDto) {
        User user = stationService.updateDepartureRegion(RegionRequestDto);
        //id 값을 보냄
        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }


    @PatchMapping("/api/basic/arrival/regions")
    public ResponseEntity<?> arrivalRegion(@RequestBody RegionRequestDto RegionRequestDto) {
        User user = stationService.updateArrivalRegion(RegionRequestDto);

        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }

    @PatchMapping("/api/basic/departure")//도착역 선택
    public ResponseEntity<?> departureStation(@RequestBody StationRequestDto StationRequestDto) {
        User user = stationService.updateDepartureStation(StationRequestDto);

        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }

    @PatchMapping("/api/basic/arrival")//출발역 선택
    public ResponseEntity<?> arrivalStation(@RequestBody StationRequestDto StationRequestDto) {
        User user = stationService.updateArrivalStation(StationRequestDto);

        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }


    @PatchMapping("/api/basic/date") //출발일 선택
    public ResponseEntity<?> dateSelectNormal(@RequestBody DateSelectionRequestDto dateSelectionRequestDto) {
        //출발일 정보 Db에 저장
        User savedUser = DateSelectionDb.dateSelectionNormalDb(userRepository, dateSelectionRequestDto);
        //id정보 반환
        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }


    @PatchMapping("/api/basic/headcount") //탑승인원 선택
    public ResponseEntity<?> headcountNormal(@RequestBody HeadcountRequestDto headcountRequestDto) {

        User savedUser = HeadcountDb.headcountNormalDb(userRepository, headcountRequestDto, headcountRequestDto.adult(), headcountRequestDto.child()
        , headcountRequestDto.senior(), headcountRequestDto.disable());

        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }

    @PatchMapping("/api/basic/seats") //좌석정보 선택
    public ResponseEntity<?> seatsNormal(@RequestBody SeatsRequestDto seatsRequestDto){

        SeatsResponseNormalDto seatsResponseNormalDto = SeatsService.seatsNormalService(seatsRequestDto);
        return ResponseEntity.ok(seatsResponseNormalDto);
    }

    @PatchMapping("/api/basic/confirm") //최종 정보 저장 api
    public void confirmNormal(@RequestBody ConfirmRequestDto confirmRequestDto){

        ConfirmDb.confirmNormalDb(userRepository,trainRepository ,confirmRequestDto);
        return;
    }
    @PostMapping("/api/basic/trains")
    public ResponseEntity<?> trainChoice(@RequestBody TrainChoiceRequestDto trainChoiceRequestDto) {
        Long id = trainChoiceService.trainChoice(trainChoiceRequestDto);

        return ResponseEntity.ok(TrainIdResponseDto.of(id));
    }

}