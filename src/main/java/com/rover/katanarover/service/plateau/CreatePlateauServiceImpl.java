package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.Plateau;
import com.rover.katanarover.repository.PlateauRepository;
import com.rover.katanarover.service.CreatePlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreatePlateauServiceImpl implements CreatePlateauService {

    private final PlateauRepository plateauRepository;

    @Autowired
    public CreatePlateauServiceImpl(PlateauRepository plateauRepository) {
        this.plateauRepository = plateauRepository;

    }

    @Override
    public ResponseEntity<String> createPlateau(Plateau plateau) {

        plateauRepository.save(plateau);

        return new ResponseEntity<>("Plateau create...", HttpStatus.CREATED);
    }
}
