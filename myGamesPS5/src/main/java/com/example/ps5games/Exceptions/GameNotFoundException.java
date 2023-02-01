package com.example.ps5games.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Game not found")
public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(Long gameId) {
        super("Game with id " + gameId + " not found");
    }
}


