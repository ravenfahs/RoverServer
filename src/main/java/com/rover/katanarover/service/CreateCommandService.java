package com.rover.katanarover.service;

import com.rover.katanarover.models.Commands;
import org.springframework.http.ResponseEntity;

public interface CreateCommandService {
    ResponseEntity<String> createCommands(Commands commands);

}
