package DigitalEye.demo.service;

import DigitalEye.demo.domain.Train;
import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.response.both.FinalChoiceResponseDto;
import DigitalEye.demo.repository.TrainRepository;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalChoiceService {
    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    public FinalChoiceResponseDto getFinalChoiceResponse(Long trainId, Long userId) {
        // 열차 정보 조회
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train not found with id: " + trainId));

        // 사용자 정보 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // FinalChoiceResponseDto 생성 및 반환
        return FinalChoiceResponseDto.of(
                train.getDepStation(),
                train.getArrStation(),
                train.getDate(),
                String.valueOf(user.getAdult()),
                String.valueOf(user.getChild()),
                String.valueOf(user.getSenior()),
                String.valueOf(user.getDisable()),
                train.getTrainType(),
                train.getDepTime(),
                train.getArrTime(),
                user.getSeatNumber(),  // 사용자가 선택한 좌석 정보
                String.valueOf(train.getPrice())
        );
    }
}
