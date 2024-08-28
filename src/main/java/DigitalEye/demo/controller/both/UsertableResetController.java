package DigitalEye.demo.controller.both;

import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.UsertableResetResponseDto;
import DigitalEye.demo.service.UsertableResetService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsertableResetController {
    @Transactional
    @DeleteMapping("/api/audio/headcount")
    public ResponseEntity<?> usertableDelete(@RequestBody OnlyIdRequestDto onlyIdRequestDto) {
        //서비스 호출 - 서비스에서 stt실행,db저장, Dto로 반환
        UsertableResetResponseDto usertableResetResponseDto = UsertableResetService.usertableResetService(onlyIdRequestDto);

        //ResponseEntity 반환 - HTTP형태
        return ResponseEntity.ok(usertableResetResponseDto);
    }
}
