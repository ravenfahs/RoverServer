package com.rover.katanarover.repository;

import com.rover.katanarover.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoverRepository extends JpaRepository <Rover, Long> {
    @Query("SELECT MAX(p.id_rover) FROM Rover p")
    Long findLastRoverId();
}
