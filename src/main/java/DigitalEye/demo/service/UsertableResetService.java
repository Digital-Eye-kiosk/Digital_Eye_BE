package DigitalEye.demo.service;

import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.dto.response.both.UsertableResetResponseDto;
import DigitalEye.demo.repository.UserRepository;
import DigitalEye.demo.service.db.UsertableResetDb;
import org.springframework.stereotype.Service;

import static DigitalEye.demo.service.db.UsertableResetDb.usertableResetDb;

@Service
public class UsertableResetService {
    private static UserRepository userRepository;
    private static UsertableResetDb usertableResetDb;

    public UsertableResetService(UserRepository userRepository, UsertableResetDb usertableResetDb) {
        this.userRepository = userRepository;
        this.usertableResetDb = usertableResetDb;
    }

    public static UsertableResetResponseDto usertableResetService(OnlyIdRequestDto onlyIdRequestDto)
    {
        int complete = usertableResetDb(userRepository,onlyIdRequestDto);
        return UsertableResetResponseDto.of(complete);
    }
}
