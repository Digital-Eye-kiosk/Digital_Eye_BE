package DigitalEye.demo.service;

import DigitalEye.demo.client.TrainInfoClient;

//공공데이터 train 출발역, 도착역 정보 가져오는 api 호출정보 Service
public class TrainInfoService {
    private final TrainInfoClient trainInfoClient;

    public TrainInfoService(TrainInfoClient trainInfoClient) {
        this.trainInfoClient = trainInfoClient;
    }

    public String findTrainInfo(String depPlaceId, String arrPlaceId, String depPlandTime, String trainGradeCode) {
        return trainInfoClient.getTrainInfo(depPlaceId, arrPlaceId, depPlandTime, trainGradeCode);
    }
}
