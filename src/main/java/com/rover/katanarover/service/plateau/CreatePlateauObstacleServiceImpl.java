package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.GridElement;
import com.rover.katanarover.models.Plateau;
import com.rover.katanarover.repository.GridElementRepository;
import com.rover.katanarover.repository.PlateauRepository;
import com.rover.katanarover.service.CreatePlateauObstacleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatePlateauObstacleServiceImpl implements CreatePlateauObstacleService {

    private final GridElementRepository gridElementRepository;
    private final PlateauRepository plateauRepository;


    public CreatePlateauObstacleServiceImpl(GridElementRepository gridElementRepository, PlateauRepository plateauRepository) {
        this.gridElementRepository = gridElementRepository;
        this.plateauRepository = plateauRepository;
    }

    @Override
    public ResponseEntity<String> createPlateauObstacle(GridElement gridElement) {
        Optional<Plateau> id = plateauRepository.findById(plateauRepository.findLastPlateauId());
        if(id.isEmpty()){
            return new ResponseEntity<>("Opsss...No se puedo crear obstacle...", HttpStatus.NOT_FOUND);
        }else {
            gridElement.setPlateau(id.get());
            gridElementRepository.save(gridElement);
            return new ResponseEntity<>("Obstacle create...", HttpStatus.CREATED);
        }
    }
}
