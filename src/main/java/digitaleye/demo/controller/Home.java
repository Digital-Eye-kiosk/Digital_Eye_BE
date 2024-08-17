package digitaleye.demo.controller;

import digitaleye.demo.dto.request.OptionRequest;
import digitaleye.demo.dto.response.OptionResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @PostMapping("/api/home")
    public OptionResponse home(@RequestParam(name = "option", required = false) OptionRequest option) {

    }


}
