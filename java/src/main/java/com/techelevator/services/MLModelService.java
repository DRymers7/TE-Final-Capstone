package com.techelevator.services;

import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.Azure.*;
import com.techelevator.model.ModelClasses.fdaApi.Response;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class MLModelService {

    private String baseApiUrl;
    RestTemplate restTemplate = new RestTemplate();

    public MLModelService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    public Prediction getUserPrediction(UserInfoObject userInformation) throws ServersideOpException {
        try {
            String url = baseApiUrl + "/predict";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<UserInfoObject> requestEntity = new HttpEntity<UserInfoObject>(userInformation, headers);
            ResponseEntity<Prediction> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Prediction.class);
            return responseEntity.getBody();
        } catch (ResponseStatusException e) {
            throw new ServersideOpException("Smart services temporarily unavailable. Please try again later.");
        }

    }

    public Prediction getUserPredictionAzure(UserInfoObject userInfoObject) throws ServersideOpException {
        try {
            String url = "http://b9b9e03c-8cd6-4bd8-b114-80fe8fba5269.eastus2.azurecontainer.io/score";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<UserInfoObject> requestEntity = new HttpEntity<>(userInfoObject, headers);
            ResponseEntity<Prediction> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Prediction.class);
            return responseEntity.getBody();
        } catch (ResponseStatusException e) {
            return getUserPrediction(userInfoObject);
        }

    }


}
