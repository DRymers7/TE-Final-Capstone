package com.techelevator.services;

import com.techelevator.model.ModelClasses.Azure.Prediction;
import com.techelevator.model.ModelClasses.Azure.UserInfoPrediction;
import com.techelevator.model.ModelClasses.Azure.data;

import java.util.List;

public class MLModelHelper {

    private MLModelService mlModelService = new MLModelService("http://127.0.0.1:5000/");

    public MLModelHelper() {}

    public double returnUserDataPrediction(UserInfoPrediction userInformation) {
//        Prediction userPrediction = mlModelService.getUserPrediction(userInformation);
//        System.out.println("CHECK");
//        return extractUserPrediction(userPrediction);
            return 0.0;
    }

    public double returnUserBloodSugarPredictionFromAzure(data data) {
        Prediction prediction = mlModelService.getUserPredictionAzure(data);
        System.out.println("CHECK");
        System.out.println("WHAT IS IN THE VAR");
        return prediction.getPrediction().get(0);
    }



    private int scaleUserPrediction(int userPrediction) {
        return 0;
    }
}
