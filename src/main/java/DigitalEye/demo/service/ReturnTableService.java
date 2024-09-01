package DigitalEye.demo.service;

import DigitalEye.demo.domain.Train;
import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.both.TrainIdRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.TrainTableResponseDto;
import DigitalEye.demo.dto.response.both.UserTableResponseDto;
import DigitalEye.demo.repository.TrainRepository;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ReturnTableService {
    private final UserRepository userRepository;
    private final TrainRepository trainRepository;

    public ReturnTableService(UserRepository userRepository, TrainRepository trainRepository) {
        this.userRepository = userRepository;
        this.trainRepository = trainRepository;
    }


    public UserTableResponseDto returnUserTableService(OnlyIdRequestDto onlyIdRequestDto){
        User user = userRepository.findById(onlyIdRequestDto.id())
                .orElseThrow(() -> new RuntimeException());
        return UserTableResponseDto.of(user.getOption(),user.getDepRegion(),user.getArrRegion()
                ,user.getDepStation(),user.getArrStation(),user.getDate()
                ,user.getAdult(),user.getChild(),user.getSenior(),user.getDisable()
                ,user.getAdultPrice(),user.getChildPrice(),user.getSeniorPrice(),user.getDisablePrice()
                ,user.getSeatNumber());
    }

    public TrainTableResponseDto returnTrainTableService(TrainIdRequestDto trainIdRequestDto){
        Train train = trainRepository.findById(trainIdRequestDto.id())
                .orElseThrow(() -> new RuntimeException());

        return TrainTableResponseDto.of(train.getId(),train.getTrainType(),
                train.getTrainNum(), train.getDepStation(),train.getArrStation(),
                train.getDate(),train.getDepTime(),train.getArrTime(),train.getPrice(),train.isSoldOut());
    }
}
