package com.takeway.takeaway3waygame.transfer;

import com.takeway.takeaway3waygame.transfer.clients.NumbersClient;
import com.takeway.takeaway3waygame.transfer.model.NumberPOJO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberInitializer implements CommandLineRunner {
    static int randomNumberBound = 1000;
    public static String playerName = "Player2";//this would have to be changed for each player
    Logger logger = LoggerFactory.getLogger(NumberInitializer.class);

    @Autowired
    NumbersClient numbersClient;

    public void initiate() throws Exception {
        NumberPOJO numberPOJO = new NumberPOJO();
        Random random = new Random();
        int number = random.nextInt(randomNumberBound);
        numberPOJO.setNumber(number);
        logger.info("Player " + playerName + " is started.");
        numbersClient.numberCaller(numberPOJO);//this would be started for player who is starting the game.
    }

    @Override
    public void run(String... args) throws Exception {
        initiate();
    }
}
