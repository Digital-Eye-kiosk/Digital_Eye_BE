package DigitalEye.demo.service;


import DigitalEye.demo.dto.request.AudioDestinationRequest;
import DigitalEye.demo.dto.response.AudioDestinationResponse;
import org.springframework.stereotype.Service;

@Service
public class AudioDestinationService {


    public AudioDestinationResponse findStation(AudioDestinationRequest request) {
        String stationName = request.getStationName();
        boolean isStationValid = publicDataApiClient.checkStationExists(stationName);

        if (isStationValid) {
            return new AudioDestinationResponse(stationName, 1);
        } else {
            return new AudioDestinationResponse("", 0);
        }
    }
}