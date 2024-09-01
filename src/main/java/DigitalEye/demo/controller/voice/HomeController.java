package DigitalEye.demo.controller.voice;


import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.response.OptionResponseDto;
import DigitalEye.demo.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @PostMapping("/api/home")
    public ResponseEntity<?> home() {
        User user = homeService.saveOption();

        if(user == null) {
            return ResponseEntity.ok(OptionResponseDto.of(false, 0L, -1));
        }
        else {
            return ResponseEntity.ok(OptionResponseDto.of(true, user.getId(), user.getOption()));
        }
    }
}
