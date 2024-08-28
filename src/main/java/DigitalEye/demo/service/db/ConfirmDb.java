package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.ConfirmRequestDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.repository.UserRepository;

public class ConfirmDb {
    public static User confirmNormalDb(UserRepository userRepository, ConfirmRequestDto confirmRequestDto){
        // 사용자 ID로 User 엔티티를 조회합니다.
        User user = userRepository.findById(confirmRequestDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // check 값이 2이면, id를 제외한 모든 변수를 초기화합니다.
        if (confirmRequestDto.check() == 2) {
            user.setOption(null);
            user.setDepRegion(null);
            user.setArrRegion(null);
            user.setDepStation(null);
            user.setArrStation(null);
            user.setDate(null);
            user.setSeatNumber(null);
            user.setAdult(null);
            user.setChild(null);
            user.setSenior(null);
            user.setDisable(null);
            user.setAdultPrice(null);
            user.setChildPrice(null);
            user.setSeniorPrice(null);
            user.setDisablePrice(null);

            // 변경된 사항을 저장합니다.
            userRepository.save(user);
        }//check값이 1이면 User테이블의 내용을 nonKTXseat또는 KTXseat테이블에 반영한다.
        else if(confirmRequestDto.check() == 1){

        }
        // 업데이트된 사용자 객체를 반환합니다.
        return user;
    }
    public static User confirmVoiceDb(UserRepository userRepository, OnlyIdRequestDto onlyIdRequestDto, int check){
        // 사용자 ID로 User 엔티티를 조회합니다.
        User user = userRepository.findById(onlyIdRequestDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // check 값이 2이면, id를 제외한 모든 변수를 초기화합니다.
        if (check == 2) {
            user.setOption(null);
            user.setDepRegion(null);
            user.setArrRegion(null);
            user.setDepStation(null);
            user.setArrStation(null);
            user.setDate(null);
            user.setSeatNumber(null);
            user.setAdult(null);
            user.setChild(null);
            user.setSenior(null);
            user.setDisable(null);
            user.setAdultPrice(null);
            user.setChildPrice(null);
            user.setSeniorPrice(null);
            user.setDisablePrice(null);

            // 변경된 사항을 저장합니다.
            userRepository.save(user);
        }

        // 업데이트된 사용자 객체를 반환합니다.
        return user;
    }
}
