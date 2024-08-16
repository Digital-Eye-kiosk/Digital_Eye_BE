package DigitalEye.demo.controller;

import DigitalEye.demo.service.TrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//공공데이터 train 출발역, 도착역 정보기반으로 열차정보 가져오는 api 사용을 위한 controller
@RestController
public class TrainInfoController {

    private final TrainInfoService trainInfoService;

    @Autowired
    public TrainInfoController(TrainInfoService trainInfoService) {
        this.trainInfoService = trainInfoService;
    }

    @GetMapping("/api/train-Info")
    public String getTrainInfo(
            @RequestParam String depPlaceId,
            @RequestParam String arrPlaceId,
            @RequestParam String depPlandTime,
            @RequestParam String trainGradeCode) {

        return trainInfoService.findTrainDeparDest(depPlaceId, arrPlaceId, depPlandTime, trainGradeCode);
    }
}