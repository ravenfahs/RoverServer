package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.Commands;
import com.rover.katanarover.models.Plateau;
import com.rover.katanarover.models.Rover;
import com.rover.katanarover.repository.CommandRepository;
import com.rover.katanarover.repository.RoverRepository;
import com.rover.katanarover.service.CreateCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCommandServiceImpl implements CreateCommandService {

    private final CommandRepository commandRepository;
    private final RoverRepository roverRepository;

    public CreateCommandServiceImpl(CommandRepository commandRepository, RoverRepository roverRepository) {
        this.commandRepository = commandRepository;
        this.roverRepository = roverRepository;

    }

    @Override
    public ResponseEntity<String> createCommands(Commands commands) {
        Optional<Rover> id = roverRepository.findById(roverRepository.findLastRoverId());
        if(id.isEmpty()){
            return new ResponseEntity<>("Opsss...No se puedo crear commmands...", HttpStatus.NOT_FOUND);
        }else {
            commands.setRover(id.get());
            commandRepository.save(commands);
            return new ResponseEntity<>("Command create...", HttpStatus.CREATED);
        }
    }

}
