package digitaleye.demo.service.voice;

import digitaleye.demo.domain.User;
import digitaleye.demo.dto.request.both.TrainIdRequestDto;
import digitaleye.demo.dto.request.voice.RecommendSeatRequestDto;
import digitaleye.demo.dto.response.both.SeatDto;
import digitaleye.demo.dto.response.voice.RecommendSeatResponseDto;
import digitaleye.demo.repository.*;
import digitaleye.demo.service.both.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

import static digitaleye.demo.service.GetRecommendSeatService.getRecommendSeat;
import static digitaleye.demo.service.GetSeatInfoService.getSeatInfo;

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