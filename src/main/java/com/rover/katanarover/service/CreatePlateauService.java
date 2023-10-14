package com.rover.katanarover.service;

import com.rover.katanarover.models.Plateau;
import org.springframework.http.ResponseEntity;

public interface CreatePlateauService {
    ResponseEntity<String> createPlateau(Plateau plateau);

}
