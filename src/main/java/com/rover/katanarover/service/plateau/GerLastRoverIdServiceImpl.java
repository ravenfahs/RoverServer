package com.rover.katanarover.service.plateau;

import com.rover.katanarover.repository.RoverRepository;
import com.rover.katanarover.service.GetLastRoverIdService;
import org.springframework.stereotype.Service;

@Service
public class GerLastRoverIdServiceImpl implements GetLastRoverIdService {

    private final RoverRepository roverRepository;

    public GerLastRoverIdServiceImpl(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    @Override
    public Long findLastRoverId() {
        return roverRepository.findLastRoverId();
    }
}
