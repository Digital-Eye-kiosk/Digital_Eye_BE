package DigitalEye.demo.service;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.TrainResponseDto;
import DigitalEye.demo.repository.TrainInfoRepository;
import DigitalEye.demo.repository.TrainRepository;
import DigitalEye.demo.repository.UserRepository;

import java.util.List;

import static DigitalEye.demo.service.GetCodeService.getTrainTypesCode;

public class TrainService {
    private final TrainInfoRepository trainInfoRepository;
    private final GetTrainService getTrainService;

    public TrainService(UserRepository userRepository, TrainRepository trainRepository) {
        this.trainInfoRepository = new TrainInfoRepository(userRepository, trainRepository);
        this.getTrainService = new GetTrainService(userRepository, trainRepository);
    }
    public List<TrainResponseDto> getTrains(OnlyIdRequestDto onlyIdRequestDto) {
        User user = trainInfoRepository.findUser(onlyIdRequestDto.id());
        String depStation = user.getDepStation();
        String arrStation = user.getArrStation();
        String date = user.getDate();

        List<String> trainTypeCodes = getTrainTypesCode();
        List<TrainResponseDto> trains= getTrainService.getTrains(depStation, arrStation, date, trainTypeCodes);

        return trains;
    }
}
