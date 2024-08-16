package DigitalEye.demo.controller.basic;

import DigitalEye.demo.dto.request.DestinationRequest;
import DigitalEye.demo.dto.response.DestinationResponse;
import DigitalEye.demo.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basic/destination")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping("/find")
    public ResponseEntity<DestinationResponse> findDestination(@RequestBody DestinationRequest request) {
        try {
            DestinationResponse response = destinationService.findFinalDestination(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}