//package digitaleye.demo.service.voice;
//
//import digitaleye.demo.domain.User;
//import digitaleye.demo.dto.request.voice.IdRequestDto;
//import digitaleye.demo.dto.response.voice.RegionResponseDto;
//import digitaleye.demo.dto.response.voice.StationResponseDto;
//import digitaleye.demo.repository.UserRepository;
//import digitaleye.demo.repository.StationRepository;
//import digitaleye.demo.service.SpeechToTextService;
//import org.springframework.stereotype.Service;
//
//import static digitaleye.demo.service.CheckTextService.checkRegion;
//import static digitaleye.demo.service.CheckTextService.checkStation;
//import static digitaleye.demo.service.GetCodeService.getCityCode;
//import static digitaleye.demo.service.GetCodeService.getStationCode;
//
//@Service
//public class StationService {
//    private final StationRepository stationRepository;
//
//    public StationService(UserRepository userRepository) {
//        this.stationRepository = new StationRepository(userRepository);
//    }
//
//    public RegionResponseDto updateDepartureRegion(IdRequestDto idRequestDto) {
//        //stt 함수로 사용자 응답을 받아냄
//        String text = getText();
//
//        //출발역의 도시 코드 조회
//        int cityCode = getCityCode(text);
//
//        //사용자 응답이 올바른지 확인
//        boolean check = checkRegion(cityCode);
//        if(check) {
//            //도시 코드 db에 저장
//            User user = stationRepository.findUser(idRequestDto.id());
//            User updatedUser = stationRepository.updateDepRegion(user, cityCode);
//            return RegionResponseDto.of(check, updatedUser.getId(), text);
//        }
//        else {
//            return RegionResponseDto.of(check, 0L,null);
//        }
//    }
//
//    public RegionResponseDto updateArrivalRegion(IdRequestDto idRequestDto) {
//        //stt 함수로 사용자 응답을 받아냄
//        String text = getText();
//
//        //도착역의 도시 코드 조회
//        int cityCode = getCityCode(text);
//
//        //사용자 응답이 올바른지 확인
//        boolean check = checkRegion(cityCode);
//        if(check) {
//            //도시 코드 db에 저장
//            User user = stationRepository.findUser(idRequestDto.id());
//            User updatedUser = stationRepository.updateArrRegion(user, cityCode);
//            return RegionResponseDto.of(check, updatedUser.getId(), text);
//        }
//        else {
//            return RegionResponseDto.of(check, 0L,null);
//        }
//    }
//
//    public StationResponseDto updateDepartureStation(IdRequestDto idRequestDto) {
//        //stt 함수로 사용자 응답을 받아냄
//        String text = getText();
//
//        //출발역의 도시 코드 db에서 조회
//        User user = stationRepository.findUser(idRequestDto.id());
//        int regionId = stationRepository.getDepRegion(user);
//
//        //출발역 코드 조회
//        String regionid = Integer.toString(regionId);
//        String stationCode = getStationCode(regionid, text);
//
//        //사용자 응답이 올바른지 확인
//        boolean check = checkStation(stationCode);
//        if(check) {
//            //출발역 코드 db에 저장
//            User updatedUser = stationRepository.updateDepStation(user, stationCode);
//            return StationResponseDto.of(check, updatedUser.getId(), text);
//        }
//        else {
//            return StationResponseDto.of(check, 0L,null);
//        }
//    }
//
//    public StationResponseDto updateArrivalStation(IdRequestDto idRequestDto) {
//        //stt 함수로 사용자 응답을 받아냄
//        String text = getText();
//
//        //도착역의 도시 코드 db에서 조회
//        User user = stationRepository.findUser(idRequestDto.id());
//        int regionId = stationRepository.getArrRegion(user);
//
//        //도착역 코드 조회
//        String regionid = Integer.toString(regionId);
//        String stationCode = getStationCode(regionid, text);
//
//        //사용자 응답이 올바른지 확인
//        boolean check = checkStation(stationCode);
//        if(check) {
//            //도착역 코드 db에 저장
//            User updatedUser = stationRepository.updateArrStation(user, stationCode);
//            return StationResponseDto.of(check, updatedUser.getId(), text);
//        }
//        else {
//            return StationResponseDto.of(check, 0L,null);
//        }
//    }
//}
