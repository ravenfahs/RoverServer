package com.rover.katanarover.service.plateau;


import com.rover.katanarover.models.GridElement;
import com.rover.katanarover.repository.GridElementRepository;
import com.rover.katanarover.service.GetAllObstaclesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllObstaclesServiceImpl implements GetAllObstaclesService {

    private final GridElementRepository gridElementRepository;

    public GetAllObstaclesServiceImpl(GridElementRepository gridElementRepository) {
        this.gridElementRepository = gridElementRepository;
    }

    @Override
    public List<GridElement> getAllObstacles() {
        return gridElementRepository.findByObstacles();
    }
}
