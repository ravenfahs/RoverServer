package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.Plateau;
import com.rover.katanarover.repository.PlateauRepository;
import com.rover.katanarover.service.GetLastPlateauIdService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetLastPlateauIdServiceImpl implements GetLastPlateauIdService {

    private final PlateauRepository plateauRepository;

    public GetLastPlateauIdServiceImpl(PlateauRepository plateauRepository) {
        this.plateauRepository = plateauRepository;
    }

    @Override
    public Long findLastPlateauId() {
        return plateauRepository.findLastPlateauId();
    }

}
