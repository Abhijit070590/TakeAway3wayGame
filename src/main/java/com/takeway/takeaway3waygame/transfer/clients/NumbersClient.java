package com.takeway.takeaway3waygame.transfer.clients;

import com.takeway.takeaway3waygame.transfer.controller.NumberController;
import com.takeway.takeaway3waygame.transfer.model.NumberPOJO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NumbersClient {

    String numberUri = "http://localhost:8083/getNumber";//this is set to the uri for player 2
    Logger logger = LoggerFactory.getLogger(NumbersClient.class);

    public NumberPOJO numberCaller(NumberPOJO numberPOJO) {
        RestTemplate restTemplate = new RestTemplate();
        NumberPOJO resultNumberPOJO = restTemplate.postForObject(numberUri, numberPOJO, NumberPOJO.class);
        return resultNumberPOJO;
    }
}
