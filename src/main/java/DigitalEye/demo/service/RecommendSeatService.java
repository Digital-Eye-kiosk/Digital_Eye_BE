package DigitalEye.demo.service;


import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.both.TrainIdRequestDto;
import DigitalEye.demo.dto.request.voice.RecommendSeatRequestDto;
import DigitalEye.demo.dto.response.both.SeatDto;
import DigitalEye.demo.dto.response.voice.RecommendSeatResponseDto;
import DigitalEye.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static DigitalEye.demo.service.GetRecommendSeatService.getRecommendSeat;
import static DigitalEye.demo.service.GetSeatInfoService.getSeatInfo;

@Service
public class RecommendSeatService {
    private final SeatChoiceRepository seatChoiceRepository;
    private final SeatService seatService;

    public RecommendSeatService(UserRepository userRepository, TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
        this.seatChoiceRepository = new SeatChoiceRepository(userRepository);
        this.seatService = new SeatService(trainRepository, ktxRepository, nonKTXRepository);
    }

    public RecommendSeatResponseDto recommendSeat(RecommendSeatRequestDto recommendSeatRequestDto) {
        SeatDto seatDto = seatService.getSeats(new TrainIdRequestDto(recommendSeatRequestDto.trainId()));
        List<String> seats = getSeatInfo(seatDto);
        User user = seatChoiceRepository.findUser(recommendSeatRequestDto.id());
        int totalHeadCount = user.getAdult() + user.getChild() + user.getSenior() + user.getDisable();
        String recommendSeat = getRecommendSeat(seats, recommendSeatRequestDto.tryNum(), totalHeadCount);

        return RecommendSeatResponseDto.of(recommendSeatRequestDto.id(), recommendSeatRequestDto.trainId(), recommendSeat);
    }
}