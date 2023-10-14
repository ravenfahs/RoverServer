package com.rover.katanarover.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "gridElement")
public class GridElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_elemento")
    private Long id_elemento;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private GridElementType tipo;

    @Column(name = "orientacion")
    private String orientacion; //tipo de obstáculo o rover

    @ManyToOne()
    @JoinColumn(name = "id_plateau")
    private Plateau plateau;

}

