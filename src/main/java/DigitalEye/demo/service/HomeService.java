
package DigitalEye.demo.service;


import DigitalEye.demo.domain.User;
import DigitalEye.demo.repository.HomeRepository;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import static DigitalEye.demo.service.CheckTextService.checkOption;
import static org.aspectj.bridge.Version.getText;

@Service
public class HomeService {
    private final HomeRepository homeRepository;

    public HomeService(UserRepository userRepository) {
        this.homeRepository = new HomeRepository(userRepository);
    }

    public User saveOption() {
        //stt 함수로 사용자 응답을 받아냄
        String text = getText();
        int option = Integer.valueOf(text);
        //사용자 응답이 올바른지 확인
        boolean check = checkOption(option);

        User savedUser = null;
        //옵션 db에 저장
        if(check) {
            savedUser = homeRepository.makeUser(option);
        }

        return savedUser;
    }
    public User saveOptionNormal(int option) {

        User savedUser = homeRepository.makeUser(option);


        return savedUser;
    }
}
