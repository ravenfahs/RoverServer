package com.rover.katanarover.service;

import com.rover.katanarover.models.GridElement;
import org.springframework.http.ResponseEntity;

public interface CreatePlateauObstacleService {

    ResponseEntity<String> createPlateauObstacle(GridElement gridElement);

}
