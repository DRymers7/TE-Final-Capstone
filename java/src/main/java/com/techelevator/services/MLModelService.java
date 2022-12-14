package com.techelevator.services;

import com.techelevator.model.ModelClasses.Azure.Prediction;
import com.techelevator.model.ModelClasses.Azure.UserInfoPrediction;
import com.techelevator.model.ModelClasses.Azure.data;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

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
        HttpEntity<UserInfoPrediction> requestEntity = new HttpEntity<UserInfoPrediction>(userInformation, headers);
        ResponseEntity<Prediction> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Prediction.class);
        return responseEntity.getBody();
    }

    public Prediction getUserPredictionAzure(data data) {
        String url = "http://b9b9e03c-8cd6-4bd8-b114-80fe8fba5269.eastus2.azurecontainer.io/score";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<data> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<Prediction> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Prediction.class);
        return responseEntity.getBody();
    }

}
