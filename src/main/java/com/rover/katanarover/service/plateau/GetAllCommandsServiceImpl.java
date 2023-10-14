package com.rover.katanarover.service.plateau;

import com.rover.katanarover.models.Commands;
import com.rover.katanarover.repository.CommandRepository;
import com.rover.katanarover.service.GetAllCommandsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCommandsServiceImpl implements GetAllCommandsService {

    public final CommandRepository commandRepository;

    public GetAllCommandsServiceImpl(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public List<Commands> getAllCommands() {
        return commandRepository.findAll();
    }
}
