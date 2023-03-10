package com.techelevator.services;

import com.techelevator.model.ModelClasses.edamam.NutritionInfo;
import com.techelevator.model.ModelClasses.fdaApi.Response;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class FDAService {

    private String baseApiUrl;
     private String appId = "NUTRITION_API_ID";
     private String PUBLIC_KEY = "NUTRITION_API_PUBLICKEY";
     private String nutritionType = "NUTRITION_API_NUTRITIONTYPE";
    // private String PUBLIC_KEY = "bzXTRbJNlmD7MzEdK1XYXgOzVB8SUGq9tlT73Aku";
    RestTemplate restTemplate = new RestTemplate();;

    public FDAService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    public NutritionInfo getListOfQueriedFoods(String searchQuery) {
        String url = baseApiUrl + "?app_id=" + appId + "&app_key=" + PUBLIC_KEY + "&nutrition-type=" + nutritionType + "&ingr=" + searchQuery + "&If-None-Match";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NutritionInfo> requestEntity = new HttpEntity<NutritionInfo>(headers);
        ResponseEntity<NutritionInfo> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, NutritionInfo.class);
        return responseEntity.getBody();
    }

//    public Response getListOfQueriedFoodsFDA(String searchQuery) {
//        String url = baseApiUrl + "?api_key=" + PUBLIC_KEY + "&query=" + searchQuery;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Response> requestEntity = new HttpEntity<>(headers);
//        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Response.class);
//        return responseEntity.getBody();
//    }


}
