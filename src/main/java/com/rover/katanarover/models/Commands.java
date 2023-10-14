package com.rover.katanarover.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "comandos")
public class Commands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comando")
    private Long id_comando;

    @Enumerated(EnumType.STRING)
    private CommandElements commandElements;

    @ManyToOne()
    @JoinColumn(name = "id_rover")
    private Rover rover;

}