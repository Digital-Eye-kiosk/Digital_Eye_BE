package digitaleye.demo.controller;

import digitaleye.demo.service.stt.SpeechToText;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static jdk.net.Sockets.setOption;

@RestController
@ResponseBody
public class Home {

    private final JdbcTemplate jdbcTemplate;

    public Home(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostMapping("/api/home")
    public int home() {
        String text = "1";
        //stt 함수로 사용자 응답을 받아냄
        try {
            text = SpeechToText.streamingMicRecognize(5);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }
        int option = Integer.valueOf(text);

        if(option != 0 && option != 1) {
            //에러 처리
        }

        //옵션 db에 저장
        String sql = "INSERT INTO user (option) VALUES (?)";
        jdbcTemplate.update(sql, option);
        //db 에러 처리

        return option;
    }
}
