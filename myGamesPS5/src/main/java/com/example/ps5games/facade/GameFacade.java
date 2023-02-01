package com.example.ps5games.facade;

import com.example.ps5games.DTO.GameDTO;
import com.example.ps5games.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameFacade {

    public GameDTO gameToGameDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setGameId(game.getGameId());
        gameDTO.setGameTitle(game.getGameTitle());
        gameDTO.setGameStudio(game.getGameStudio());
        gameDTO.setDescription(game.getDescription());
        gameDTO.setYear(game.getYear());
        gameDTO.setFinished(game.isFinished());
        return gameDTO;
    }
}
