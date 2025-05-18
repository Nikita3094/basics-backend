package org.example.basics.guessingGame.services;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;


@Slf4j
@Getter
@Setter
@Service
public class GameService {

    private int numberToGuess;
    private int attempts;
    private boolean gameOver;


    public void startNewGame() {
        numberToGuess = new Random().nextInt(100) + 1; // 1 to 100
        attempts = 0;
        gameOver = false;
    }

    public String guess(int guess) {
        if (gameOver) {
            return ("Game Over, Start a new Game");
        }
        attempts++;
        if (guess < numberToGuess) {
            return "Too low!";
        } else if (guess > numberToGuess) {
            return "Too high!";
        } else {
            return "You guessed " + guess + " out of " + numberToGuess;
        }


    }
}
