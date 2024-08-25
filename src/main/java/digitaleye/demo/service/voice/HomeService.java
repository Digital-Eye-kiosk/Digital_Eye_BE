//package digitaleye.demo.service.voice;
//
//import digitaleye.demo.domain.User;
//import digitaleye.demo.dto.response.OptionGetResponseDto;
//import digitaleye.demo.repository.HomeRepository;
//import digitaleye.demo.repository.UserRepository;
//
//import static digitaleye.demo.service.CheckTextService.checkOption;
//import static digitaleye.demo.service.stt.GetText.getText;
//
//public class HomeService {
//    private final HomeRepository homeRepository;
//
//    public HomeService(UserRepository userRepository) {
//        this.homeRepository = new HomeRepository(userRepository);
//    }
//
//    public User saveOption() {
//        //stt 함수로 사용자 응답을 받아냄
//        String text = getText();
//        int option = Integer.valueOf(text);
//        //사용자 응답이 올바른지 확인
//        boolean check = checkOption(option);
//
//        User savedUser = null;
//        //옵션 db에 저장
//        if(check) {
//            savedUser = homeRepository.makeUser(option);
//        }
//
//        return savedUser;
//    }
//}
