package DigitalEye.demo.service;


import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.voice.RegionResponseDto;
import DigitalEye.demo.dto.response.voice.StationResponseDto;
import DigitalEye.demo.repository.StationRepository;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import static DigitalEye.demo.service.CheckTextService.checkRegion;
import static DigitalEye.demo.service.CheckTextService.checkStation;
import static DigitalEye.demo.service.GetCodeService.getCityCode;
import static DigitalEye.demo.service.GetCodeService.getStationCode;
import static org.aspectj.bridge.Version.getText;

@Service
public class StationServiceVoice {
    private final StationRepository stationRepository;

    public StationServiceVoice(UserRepository userRepository) {
        this.stationRepository = new StationRepository(userRepository);
    }

    public RegionResponseDto updateDepartureRegion(OnlyIdRequestDto onlyIdRequestDto) {
        //stt 함수로 사용자 응답을 받아냄
        String text = getText();

        //출발역의 도시 코드 조회
        int cityCode = getCityCode(text);

        //사용자 응답이 올바른지 확인
        boolean check = checkRegion(cityCode);
        if(check) {
            //도시 코드 db에 저장
            User user = stationRepository.findUser(onlyIdRequestDto.id());
            User updatedUser = stationRepository.updateDepRegion(user, cityCode);
            return RegionResponseDto.of(check, updatedUser.getId(), text);
        }
        else {
            return RegionResponseDto.of(check, 0L,null);
        }
    }

    public RegionResponseDto updateArrivalRegion(OnlyIdRequestDto onlyIdRequestDto) {
        //stt 함수로 사용자 응답을 받아냄
        String text = getText();

        //도착역의 도시 코드 조회
        int cityCode = getCityCode(text);

        //사용자 응답이 올바른지 확인
        boolean check = checkRegion(cityCode);
        if(check) {
            //도시 코드 db에 저장
            User user = stationRepository.findUser(onlyIdRequestDto.id());
            User updatedUser = stationRepository.updateArrRegion(user, cityCode);
            return RegionResponseDto.of(check, updatedUser.getId(), text);
        }
        else {
            return RegionResponseDto.of(check, 0L,null);
        }
    }

    public StationResponseDto updateDepartureStation(OnlyIdRequestDto onlyIdRequestDto) {
        //stt 함수로 사용자 응답을 받아냄
        String text = getText();

        //출발역의 도시 코드 db에서 조회
        User user = stationRepository.findUser(onlyIdRequestDto.id());
        int regionId = stationRepository.getDepRegion(user);

        //출발역 코드 조회
        String regionid = Integer.toString(regionId);
        String stationCode = getStationCode(regionid, text);

        //사용자 응답이 올바른지 확인
        boolean check = checkStation(stationCode);
        if(check) {
            //출발역 코드 db에 저장
            User updatedUser = stationRepository.updateDepStation(user, stationCode);
            return StationResponseDto.of(check, updatedUser.getId(), text);
        }
        else {
            return StationResponseDto.of(check, 0L,null);
        }
    }

    public StationResponseDto updateArrivalStation(OnlyIdRequestDto idRequestDto) {
        //stt 함수로 사용자 응답을 받아냄
        String text = getText();

        //도착역의 도시 코드 db에서 조회
        User user = stationRepository.findUser(idRequestDto.id());
        int regionId = stationRepository.getArrRegion(user);

        //도착역 코드 조회
        String regionid = Integer.toString(regionId);
        String stationCode = getStationCode(regionid, text);

        //사용자 응답이 올바른지 확인
        boolean check = checkStation(stationCode);
        if(check) {
            //도착역 코드 db에 저장
            User updatedUser = stationRepository.updateArrStation(user, stationCode);
            return StationResponseDto.of(check, updatedUser.getId(), text);
        }
        else {
            return StationResponseDto.of(check, 0L,null);
        }
    }
}
