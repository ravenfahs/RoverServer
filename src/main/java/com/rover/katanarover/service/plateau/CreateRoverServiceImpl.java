package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.Plateau;
import com.rover.katanarover.models.Rover;
import com.rover.katanarover.repository.PlateauRepository;
import com.rover.katanarover.repository.RoverRepository;
import com.rover.katanarover.service.CreateRoverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateRoverServiceImpl implements CreateRoverService {

    private final RoverRepository roverRepository;
    private final PlateauRepository plateauRepository;

    public CreateRoverServiceImpl(RoverRepository roverRepository, PlateauRepository plateauRepository) {
        this.roverRepository = roverRepository;
        this.plateauRepository = plateauRepository;
    }

    @Override
    public ResponseEntity<String> createRover(Rover rover) {
        Optional<Plateau> id = plateauRepository.findById(plateauRepository.findLastPlateauId());
        if(id.isEmpty()){
            return new ResponseEntity<>("Opsss...No se puedo crear el Rover...", HttpStatus.NOT_FOUND);
        }else {
            rover.setPlateau(id.get());

            roverRepository.save(rover);
            return new ResponseEntity<>("Rover create...", HttpStatus.CREATED);
        }
    }
}
