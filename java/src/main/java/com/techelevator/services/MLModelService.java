package com.techelevator.services;

import com.techelevator.model.ModelClasses.Azure.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class MLModelService {

    private String baseApiUrl;
    RestTemplate restTemplate = new RestTemplate();

    public MLModelService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    public Prediction getUserPrediction(UserInfoObject userInformation) {
        String url = baseApiUrl + "/predict";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserInfoObject> requestEntity = new HttpEntity<UserInfoObject>(userInformation, headers);
        ResponseEntity<Prediction> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Prediction.class);
        return responseEntity.getBody();
    }

    public Prediction getUserPredictionAzure(UserInfoObject userInfoObject) {
        String url = "http://b9b9e03c-8cd6-4bd8-b114-80fe8fba5269.eastus2.azurecontainer.io/score";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserInfoObject> requestEntity = new HttpEntity<>(userInfoObject, headers);
        ResponseEntity<Prediction> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Prediction.class);
        return responseEntity.getBody();
    }


}
