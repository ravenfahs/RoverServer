package com.rover.katanarover.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Rover")
public class Rover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rover")
    private Long id_rover;
    @Column(name = "cellXRover")
    private int cellXRover;
    @Column(name = "cellYRover")
    private int cellYRover;
    @Column(name = "sentido")
    private String sentido;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private GridElementType tipo;

    @ManyToOne()
    @JoinColumn(name = "id_plateau")
    private Plateau plateau;

    public Rover() {
    }
}
