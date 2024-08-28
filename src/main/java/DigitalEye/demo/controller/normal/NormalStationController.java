package DigitalEye.demo.controller.normal;


import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.*;
import DigitalEye.demo.dto.response.normal.OnlyIdResponseDto;
import DigitalEye.demo.repository.UserRepository;
import DigitalEye.demo.service.StationService;
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
public class NormalStationController {

    private final UserRepository userRepository;
    private final StationService stationService;

    @Transactional
    @PatchMapping("/api/basic/departure/regions")
    public ResponseEntity<?> departureRegion(@RequestBody RegionRequestDto RegionRequestDto) {
        User user = stationService.updateDepartureRegion(RegionRequestDto);
        //id 값을 보냄
        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }

    @Transactional
    @PatchMapping("/api/basic/arrival/regions")
    public ResponseEntity<?> arrivalRegion(@RequestBody RegionRequestDto RegionRequestDto) {
        User user = stationService.updateArrivalRegion(RegionRequestDto);

        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }
    @Transactional
    @PatchMapping("/api/basic/departure")//도착역 선택
    public ResponseEntity<?> departureStation(@RequestBody StationRequestDto StationRequestDto) {
        User user = stationService.updateDepartureStation(StationRequestDto);

        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }
    @Transactional
    @PatchMapping("/api/basic/arrival")//출발역 선택
    public ResponseEntity<?> arrivalStation(@RequestBody StationRequestDto StationRequestDto) {
        User user = stationService.updateArrivalStation(StationRequestDto);

        return ResponseEntity.ok(OnlyIdResponseDto.of(user.getId()));
    }

    @Transactional
    @PatchMapping("/api/basic/date") //출발일 선택
    public ResponseEntity<?> dateSelectNormal(@RequestBody DateSelectionRequestDto dateSelectionRequestDto) {

        User savedUser = DateSelectionDb.dateSelectionNormalDb(userRepository, dateSelectionRequestDto);

        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }

    @Transactional
    @PatchMapping("/api/basic/headcount") //탑승인원 선택
    public ResponseEntity<?> headcountNormal(@RequestBody HeadcountRequestDto headcountRequestDto) {

        User savedUser = HeadcountDb.headcountNormalDb(userRepository, headcountRequestDto, headcountRequestDto.adult(), headcountRequestDto.child()
        , headcountRequestDto.senior(), headcountRequestDto.disable());

        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }
    @Transactional
    @PatchMapping("/api/basic/seats") //좌석정보 선택
    public ResponseEntity<?> seatsNormal(@RequestBody SeatsRequestDto seatsRequestDto){

        User savedUser = SeatsDb.seatsNormalDb(userRepository, seatsRequestDto);
        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }
    @Transactional
    @PatchMapping("/api/basic/confirm") //최종확인 api
    public ResponseEntity<?> confirmNormal(@RequestBody ConfirmRequestDto confirmRequestDto){

        User savedUser = ConfirmDb.confirmNormalDb(userRepository, confirmRequestDto);
        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }

}