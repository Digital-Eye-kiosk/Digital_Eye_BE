//package digitaleye.demo.controller;
//
//import digitaleye.demo.domain.User;
//import digitaleye.demo.dto.response.OptionResponseDto;
//import digitaleye.demo.repository.UserRepository;
//import digitaleye.demo.service.stt.SpeechToTextService;
//import digitaleye.demo.service.voice.HomeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import static jdk.net.Sockets.setOption;
//
//@RestController
//@RequiredArgsConstructor
//public class HomeController {
//
//    private final UserRepository userRepository;
//    private final HomeService homeService;
//
//    @PostMapping("/api/home")
//    public ResponseEntity<?> home() {
//        User user = homeService.saveOption();
//
//        if(user == null) {
//            return ResponseEntity.ok(OptionResponseDto.of(false, 0L, -1));
//        }
//        else {
//            return ResponseEntity.ok(OptionResponseDto.of(true, user.getId(), user.getOption()));
//        }
//    }
//}
