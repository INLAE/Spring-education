package com.example.ps5games.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "game_id", nullable = false)
    private Long gameId;
    @Column(name = "game_title", length = 128, nullable = false)
    private String gameTitle;
    @Column(name = "game_studio", length = 128, nullable = false)
    private String gameStudio;
    @Column(name = "description", length = 1024, nullable = false)
    @Size(max = 1024, message = "Too much text. Cut the crap.")
    private String description;
    @Column(name = "year", nullable = false)
    @Range(min = 1996, max = 2024)
    private int year;
    @Column(name = "finished")
    private boolean finished;
    public Game() {}
}
