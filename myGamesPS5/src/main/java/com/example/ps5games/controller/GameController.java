package com.example.ps5games.controller;

import com.example.ps5games.DTO.GameDTO;
import com.example.ps5games.entity.Game;
import com.example.ps5games.facade.GameFacade;
import com.example.ps5games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private GameFacade gameFacade;

    @GetMapping("/game")
    public String getAllGames(Model model) {
        try {
            List<GameDTO> games = gameService.showAllGames()
                    .stream()
                    .map(gameFacade::gameToGameDTO)
                    .collect(Collectors.toList());
            model.addAttribute("game", games);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "game";
    }

    @GetMapping("/game/new")
    public String createGame(Model model) {
        model.addAttribute("game", new Game());
        return "add";
    }

    @PostMapping("/game/new")
    public String createGame(@ModelAttribute Game game) {
        gameService.createGame(game);
        return "redirect:/game";
    }

    @GetMapping("/game/edit/{id}")
    public String editGame(@PathVariable Long id, Model model) {
        try {
            Game game = gameService.getGameById(id);
            model.addAttribute("game", game);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "edit";
    }


    @PostMapping("/game/edit/{id}")
    public String editGame(@PathVariable Long id, @ModelAttribute GameDTO gameDTO, Model model) {
        try {
            Game existingGame = gameService.editGame(id, gameDTO);
            gameFacade.gameToGameDTO(existingGame);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "redirect:/game";
    }

    @GetMapping("/game/delete/{id}")
    public String deleteGame(@PathVariable Long id, Model model) {
        try {
            gameService.deleteGameById(id);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "redirect:/game";
    }
}
