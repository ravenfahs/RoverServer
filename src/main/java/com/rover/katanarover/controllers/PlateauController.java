package com.rover.katanarover.controllers;

import com.rover.katanarover.models.*;
import com.rover.katanarover.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlateauController {

    private final CreatePlateauService createPlateauService;
    private final GetAllPlateauService getAllPlateau;
    private final CreatePlateauObstacleService createPlateauObstacleService;
    private final GetLastPlateauIdService getLastPlateauIdService;
    private final CreateRoverService createRoverService;
    private final CreateCommandService createCommandService;
    private final GetLastRoverIdService getLastRoverIdService;
    private final GetAllObstaclesService getAllObstaclesService;
    private final GetAllRoverMoveService getAllRoverMoveService;
    private final GetAllCommandsService getAllCommandsService;

    @Autowired
    public PlateauController(CreatePlateauService createPlateauService, GetAllPlateauService getAllPlateau,
                             CreatePlateauObstacleService createPlateauObstacleService, GetLastPlateauIdService getLastPlateauIdService,
                             CreateRoverService createRoverService, CreateCommandService createCommandService, GetLastRoverIdService getLastRoverIdService,
                             GetAllObstaclesService getAllObstaclesService, GetAllRoverMoveService getAllRoverMoveService, GetAllCommandsService getAllCommandsService) {
        this.createPlateauService = createPlateauService;
        this.getAllPlateau = getAllPlateau;
        this.createPlateauObstacleService = createPlateauObstacleService;
        this.getLastPlateauIdService = getLastPlateauIdService;
        this.createRoverService = createRoverService;
        this.createCommandService = createCommandService;
        this.getLastRoverIdService = getLastRoverIdService;
        this.getAllObstaclesService = getAllObstaclesService;
        this.getAllRoverMoveService = getAllRoverMoveService;
        this.getAllCommandsService = getAllCommandsService;
    }

    @GetMapping("/api/rover/up")
    public ResponseEntity<String> serverOn(){
        return new ResponseEntity<>("Sever on", HttpStatus.OK);
    }

    //Plateau
    @PostMapping("/api/rover")
    public ResponseEntity<String> crearPlateau(@RequestBody Plateau plateau){
        return createPlateauService.createPlateau(plateau);
    }

    @GetMapping("/api/rover")
    public List<Plateau> plateauList(){
        return getAllPlateau.getAllPlateaus();
    }


    //Obstacles
    @PostMapping("/api/rover/obstacle")
    public ResponseEntity<String> addOstacles(@RequestBody GridElement gridElement){
       return createPlateauObstacleService.createPlateauObstacle(gridElement);
    }

    @GetMapping("/api/rover/obstacleAll")
    public List<GridElement> obstacles(){
        return getAllObstaclesService.getAllObstacles();
    }

    //Posiciones del todos los rover
    @GetMapping("/api/rover/roverMoveAll")
    public List<GridElement> roverMove(){
        return getAllRoverMoveService.getAllRoverMove();
    }

    //Rover
    @GetMapping("/api/rover/id")
    public Long findLastPlateauId(){
        return getLastPlateauIdService.findLastPlateauId();
    }

    @PostMapping("/api/rover/rover")
    public ResponseEntity<String> rover(@RequestBody Rover rover ){
        return createRoverService.createRover(rover);
    }

    @GetMapping("/api/rover/roverId")
    public Long commandoRoverId(){
        return getLastRoverIdService.findLastRoverId();
    }

    //Commands
    @PostMapping("/api/rover/command")
    public ResponseEntity<String> command(@RequestBody Commands commands ){
        return createCommandService.createCommands(commands);
    }

    @GetMapping("/api/rover/commandAll")
    public List<Commands> getCommandsRoverAll(){
        return getAllCommandsService.getAllCommands();
    }
}
