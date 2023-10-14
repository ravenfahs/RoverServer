package com.rover.katanarover.service;

import com.rover.katanarover.models.Rover;
import org.springframework.http.ResponseEntity;

public interface CreateRoverService {
    ResponseEntity<String> createRover(Rover rover);
}
