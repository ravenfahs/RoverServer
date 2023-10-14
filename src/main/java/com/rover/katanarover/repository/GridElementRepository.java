package com.rover.katanarover.repository;

import com.rover.katanarover.models.GridElement;
import com.rover.katanarover.models.GridElementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GridElementRepository extends JpaRepository<GridElement, Long> {

    @Query("SELECT p FROM GridElement p where p.tipo = 'OBSTACLE'")
    List<GridElement> findByObstacles();

    @Query("SELECT p FROM GridElement p where p.tipo = 'ROVER'")
    List<GridElement> findByRover();
}
