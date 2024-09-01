package DigitalEye.demo.service;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.RegionRequestDto;
import DigitalEye.demo.dto.request.normal.StationRequestDto;
import DigitalEye.demo.repository.StationRepository;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import static DigitalEye.demo.service.GetCodeService.getCityCode;
import static DigitalEye.demo.service.GetCodeService.getStationCode;

@Service
public class StationService {
    private final StationRepository stationRepository;

    public StationService(UserRepository userRepository) {
        this.stationRepository = new StationRepository(userRepository);
    }

    public User updateDepartureRegion(RegionRequestDto RegionRequestDto) {
        //출발역의 도시 코드 조회
        int cityCode = getCityCode(RegionRequestDto.region());
        //여기서 이상한 값 들어오면 안됨. 그럴 경우에는 예외처리 해주기!
        //도시 코드 db에 저장
        User user = stationRepository.findUser(RegionRequestDto.id());
        User updatedUser = stationRepository.updateDepRegion(user, cityCode);

        //id 값을 보냄
        return updatedUser;
    }

    public User updateArrivalRegion(RegionRequestDto RegionRequestDto) {
        //도착역의 도시 코드 조회
        int cityCode = getCityCode(RegionRequestDto.region());
        //여기서 이상한 값 들어오면 안됨. 그럴 경우에는 예외처리 해주기!
        //도시 코드 db에 저장
        User user = stationRepository.findUser(RegionRequestDto.id());
        User updatedUser = stationRepository.updateArrRegion(user, cityCode);

        return updatedUser;
    }

    public User updateDepartureStation(StationRequestDto StationRequestDto) {
        //출발역의 도시 코드 db에서 조회
        User user = stationRepository.findUser(StationRequestDto.id());
        int regionId = stationRepository.getDepRegion(user);

        //출발역 코드 조회
        String regionid = Integer.toString(regionId);
        String stationCode = getStationCode(regionid, StationRequestDto.station());

        //출발역 코드 db에 저장
        User updatedUser = stationRepository.updateDepStation(user, stationCode);

        return updatedUser;
    }

    public User updateArrivalStation(StationRequestDto StationRequestDto) {
        //도착역의 도시 코드 db에서 조회
        User user = stationRepository.findUser(StationRequestDto.id());
        int regionId = stationRepository.getArrRegion(user);

        //도착역 코드 조회
        String regionid = Integer.toString(regionId);
        String stationCode = getStationCode(regionid, StationRequestDto.station());

        //도착역 코드 db에 저장
        User updatedUser = stationRepository.updateArrStation(user, stationCode);

        return updatedUser;
    }
}
