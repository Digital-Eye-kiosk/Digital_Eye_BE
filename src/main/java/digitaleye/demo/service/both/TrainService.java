package digitaleye.demo.service.both;

import digitaleye.demo.domain.User;
import digitaleye.demo.dto.request.voice.IdRequestDto;
import digitaleye.demo.dto.response.both.TrainResponseDto;
import digitaleye.demo.repository.TrainInfoRepository;
import digitaleye.demo.repository.TrainRepository;
import digitaleye.demo.repository.UserRepository;
import digitaleye.demo.service.GetTrainService;
import org.springframework.stereotype.Service;

import java.util.List;

import static digitaleye.demo.service.GetCodeService.getTrainTypesCode;

@Service
public class TrainService {
    private final TrainInfoRepository trainInfoRepository;
    private final GetTrainService getTrainService;

    public TrainService(UserRepository userRepository, TrainRepository trainRepository) {
        this.trainInfoRepository = new TrainInfoRepository(userRepository, trainRepository);
        this.getTrainService = new GetTrainService(userRepository, trainRepository);
    }
    public List<TrainResponseDto> getTrains(IdRequestDto idRequestDto) {
        User user = trainInfoRepository.findUser(idRequestDto.id());
        String depStation = user.getDepStation();
        String arrStation = user.getArrStation();
        String date = user.getDate();

        List<String> trainTypeCodes = getTrainTypesCode();
        List<TrainResponseDto> trains= getTrainService.getTrains(depStation, arrStation, date, trainTypeCodes);

        return trains;
    }
}
