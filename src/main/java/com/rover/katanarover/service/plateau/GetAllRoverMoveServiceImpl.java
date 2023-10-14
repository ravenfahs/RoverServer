package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.GridElement;
import com.rover.katanarover.repository.GridElementRepository;
import com.rover.katanarover.service.GetAllRoverMoveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllRoverMoveServiceImpl implements GetAllRoverMoveService {

    private final GridElementRepository gridElementRepository;

    public GetAllRoverMoveServiceImpl(GridElementRepository gridElementRepository) {
        this.gridElementRepository = gridElementRepository;
    }

    @Override
    public List<GridElement> getAllRoverMove() {
        return gridElementRepository.findByRover();
    }
}
