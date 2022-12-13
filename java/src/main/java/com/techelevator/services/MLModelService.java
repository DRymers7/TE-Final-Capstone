package com.techelevator.services;

import com.techelevator.model.ModelClasses.Prediction;
import com.techelevator.model.ModelClasses.UserInfoPrediction;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class MLModelService {

    private String baseApiUrl;
    RestTemplate restTemplate = new RestTemplate();

    public MLModelService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    public Prediction getUserPrediction(UserInfoPrediction userInformation) {
        String url = baseApiUrl + "/predict";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Prediction> requestEntity = new HttpEntity<Prediction>(headers);
        ResponseEntity<Prediction> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Prediction.class);
        return responseEntity.getBody();
    }
}
