package com.rover.katanarover.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "plateau")
public class Plateau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plateau")
    private Long id_plateau;

    @Column(name= "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "numeroDeObstaculos")
    private int numeroDeObstaculos;

    @Column(name = "tamañoGrid")
    private int tamañoGrid;

    @Column(name = "gridSize")
    private int gridSize;

    public Plateau() {
    }
}
