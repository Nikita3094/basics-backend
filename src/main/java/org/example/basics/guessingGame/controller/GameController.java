package org.example.basics.guessingGame.controller;

import org.example.basics.guessingGame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;


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
