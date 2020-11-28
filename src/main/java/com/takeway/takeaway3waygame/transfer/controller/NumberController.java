package com.takeway.takeaway3waygame.transfer.controller;

import com.takeway.takeaway3waygame.transfer.NumberInitializer;
import com.takeway.takeaway3waygame.transfer.clients.NumbersClient;
import com.takeway.takeaway3waygame.transfer.model.NumberPOJO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class NumberController {
    Logger logger = LoggerFactory.getLogger(NumberController.class);
    NumbersClient client = new NumbersClient();

    @PostMapping(path = "/getNumber", consumes = "application/json", produces = "application/json")
    public NumberPOJO getNumber(@RequestBody NumberPOJO numberPOJO) {
        int number = numberPOJO.getNumber();
        logger.info("Number received " + number);
        if( number == 1) {
            logger.info("Player " + numberPOJO.getPlayerName() + " won the game");
            return null;
        }
        number = normalize(number);
        number = number / 3;
        boolean isWinner = (number == 1) ? true : false;
        NumberPOJO response = populateResponse(number, isWinner);
        if(!isWinner) {
            client.numberCaller(response);
            response.setPlayerName(NumberInitializer.playerName);
        } else {
            response.setPlayerName(NumberInitializer.playerName);
            client.numberCaller(response);
            logger.info("Player " + NumberInitializer.playerName + "wins the game");
        }
        return response;
    }

    private NumberPOJO populateResponse(int number, boolean isWinner) {
        NumberPOJO numberPOJO = new NumberPOJO();
        numberPOJO.setNumber(number);
        numberPOJO.setWinner(isWinner);
        return numberPOJO;
    }

    private int normalize(int number) {
        int rem = number % 3;
        if (rem > 1) {
            number = number + (3 - rem);
        } else {
            number = number - rem;
        }
        return number;
    }

}
