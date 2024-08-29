//package digitaleye.demo.service.voice;
//
//import digitaleye.demo.dto.request.both.TrainIdRequestDto;
//import digitaleye.demo.dto.request.voice.RecommendSeatRequestDto;
//import digitaleye.demo.dto.response.both.SeatDto;
//import digitaleye.demo.dto.response.voice.RecommendSeatResponseDto;
//import digitaleye.demo.repository.KTXRepository;
//import digitaleye.demo.repository.NonKTXRepository;
//import digitaleye.demo.repository.TrainRepository;
//import digitaleye.demo.service.both.SeatService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import static digitaleye.demo.service.GetSeatInfoService.getSeatInfo;
//
//@Service
//public class RecommendSeatService {
//    private final SeatService seatService;
//
//    public RecommendSeatService(TrainRepository trainRepository, KTXRepository ktxRepository, NonKTXRepository nonKTXRepository) {
//        this.seatService = new SeatService(trainRepository, ktxRepository, nonKTXRepository);
//    }
//
//    public RecommendSeatResponseDto recommendSeat(RecommendSeatRequestDto recommendSeatRequestDto) {
//        SeatDto seatDto = seatService.getSeats(new TrainIdRequestDto(recommendSeatRequestDto.id()));
//        List<String> seats = getSeatInfo(seatDto);
//    }
//}