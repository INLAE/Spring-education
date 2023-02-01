package com.example.ps5games.service;

import com.example.ps5games.DTO.GameDTO;
import com.example.ps5games.Exceptions.GameNotFoundException;
import com.example.ps5games.entity.Game;
import com.example.ps5games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> showAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long gameId) {
        return gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException(gameId));
    }

    public Game editGame(Long id, GameDTO gameDTO) {
        Game game = getGameById(id);
        game.setGameTitle(gameDTO.getGameTitle());
        game.setGameStudio(gameDTO.getGameStudio());
        game.setDescription(gameDTO.getDescription());
        game.setYear(gameDTO.getYear());
        return gameRepository.save(game);
    }

    public void deleteGameById(Long postId) {
        gameRepository.deleteById(postId);
    }
}

