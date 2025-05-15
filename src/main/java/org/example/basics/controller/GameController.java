package org.example.basics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.basics.services.GameService;

@RestController
public class GameController {


    private final GameService gameService;


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public String startGame() {
        gameService.startNewGame();
        return "New game started! Guess a number between 1 and 100.";
    }

    @GetMapping("/guess")
    public String makeGuess(@RequestParam int number) {
        return gameService.guess(number);
    }
}
