package com.rover.katanarover.repository;

import com.rover.katanarover.models.Plateau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateauRepository extends JpaRepository<Plateau, Long> {

    @Query("SELECT MAX(p.id_plateau) FROM Plateau p")
    Long findLastPlateauId();
}
