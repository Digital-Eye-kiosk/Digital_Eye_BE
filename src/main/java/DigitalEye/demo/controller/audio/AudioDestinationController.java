package DigitalEye.demo.controller.audio;

import DigitalEye.demo.dto.request.AudioDestinationRequest;
import DigitalEye.demo.dto.response.AudioDestinationResponse;
import DigitalEye.demo.service.AudioDestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class AudioDestinationController {
    @RestController
    @RequestMapping("/api/audio")
    public class AudioDestinationController {

        private final AudioDestinationService audioDestinationService;

        public AudioDestinationController(AudioDestinationService audioDestinationService) {
            this.audioDestinationService = audioDestinationService;
        }

        @PostMapping("/destination")
        public ResponseEntity<AudioDestinationResponse> findAudioDestination(@RequestBody AudioDestinationRequest request) {
            try {
                AudioDestinationResponse response = audioDestinationService.findStation(request);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
