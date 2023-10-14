package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.Plateau;
import com.rover.katanarover.repository.PlateauRepository;
import com.rover.katanarover.service.GetAllPlateauService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPlateauServiceImpl implements GetAllPlateauService {

    private final PlateauRepository plateauRepository;

    public GetAllPlateauServiceImpl(PlateauRepository plateauRepository) {
        this.plateauRepository = plateauRepository;
    }

    @Override
    public List<Plateau> getAllPlateaus() {
        return plateauRepository.findAll();
    }
}
