package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

public class MLModelService {

    private String baseApiUrl;
    RestTemplate restTemplate = new RestTemplate();

    public MLModelService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }


}
