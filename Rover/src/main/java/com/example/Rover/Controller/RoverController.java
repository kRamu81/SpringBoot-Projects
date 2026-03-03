package com.example.Rover.Controller;

import com.example.Rover.Model.Rover;
import com.example.Rover.Service.RoverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoverController {

    private final RoverService roverService;

    // Constructor Injection
    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    // GET: http://localhost:8080/api/status
    @GetMapping("/status")
    public Rover getStatus() {
        return roverService.getRoverStatus();
    }

    // POST: http://localhost:8080/api/move?commands=FFRFF
    @PostMapping("/move")
    public Rover moveRover(@RequestParam String commands) {
        return roverService.processCommands(commands);
    }

    // POST: http://localhost:8080/api/reset
    @PostMapping("/reset")
    public Rover resetRover() {
        return roverService.resetRover();
    }
}