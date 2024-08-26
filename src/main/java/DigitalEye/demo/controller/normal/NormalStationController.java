package DigitalEye.demo.controller.normal;


import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.*;
import DigitalEye.demo.dto.response.normal.OnlyIdResponseDto;
import DigitalEye.demo.repository.UserRepository;
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


import static DigitalEye.demo.service.CityCode.cityCode;
import static DigitalEye.demo.service.db.ArrivalRegionDb.arrivalRegionDb;
import static DigitalEye.demo.service.db.DepartureRegionDb.departureRegionDb;



@RestController
@RequiredArgsConstructor
public class NormalStationController {

    private final UserRepository userRepository;

    @Transactional //해당 메서드의 작업이 트랜잭션 단위(뭉텅이로) 처리된다는 의미
    @PostMapping("/api/basic/departure/regions") //출발역 도시코드
    public ResponseEntity<?> departureRegion(@RequestBody DepartureRegionRequestDto departureRegionRequestDto) {
        //출발역의 도시 코드를 가져옴(공공 api사용)
        int cityCode = cityCode(departureRegionRequestDto.region());
        //여기서 이상한 값 들어오면 안됨. 그럴 경우에는 예외처리 해주기!
        //도시 코드 db에 저장
        User savedUser = departureRegionDb(userRepository, cityCode);

        //id 값을 보냄
        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }

    @Transactional
    @PatchMapping("/api/basic/arrival/regions") //도착역 도시코드
    public ResponseEntity<?> arrivalRegion(@RequestBody ArrivalRegionRequestDto arrivalRegionRequestDto) {
        //도착역의 도시 코드를 가져옴(공공 api사용)
        int cityCode = cityCode(arrivalRegionRequestDto.region());
        //여기서 이상한 값 들어오면 안됨. 그럴 경우에는 예외처리 해주기!
        //도시 코드 db에 저장
        User savedUser = arrivalRegionDb(userRepository, arrivalRegionRequestDto, cityCode);

        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
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
    @PostMapping("/api/basic/seats")
    public ResponseEntity<?> seatsNormal(@RequestBody SeatsRequestDto seatsRequestDto){

        User savedUser = SeatsDb.seatsNormalDb(userRepository, seatsRequestDto);
        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }
    @Transactional
    @PostMapping("/api/basic/confirm")
    public ResponseEntity<?> confirmNormal(@RequestBody ConfirmRequestDto confirmRequestDto){

        User savedUser = ConfirmDb.confirmNormalDb(userRepository, confirmRequestDto);
        return ResponseEntity.ok(OnlyIdResponseDto.of(savedUser.getId()));
    }


}