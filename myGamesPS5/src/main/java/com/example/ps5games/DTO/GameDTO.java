package com.example.ps5games.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GameDTO {
    @NotEmpty
    private Long gameId;
    @NotEmpty
    private String gameTitle;
    @NotEmpty
    private String gameStudio;
    @NotEmpty
    private String description;
    @NotEmpty
    private int year;
    private boolean finished;
}
