package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

public class FDAService {

    private String baseApiUrl;
    RestTemplate restTemplate = new RestTemplate();

    public FDAService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }


}
