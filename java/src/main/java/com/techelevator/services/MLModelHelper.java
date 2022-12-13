package com.techelevator.services;

import com.techelevator.model.ModelClasses.Prediction;
import com.techelevator.model.ModelClasses.UserInfoPrediction;

import java.util.List;
import java.util.Map;

public class MLModelHelper {

    private MLModelService mlModelService = new MLModelService("http://127.0.0.1:5000/");

    public MLModelHelper() {}

    public double returnUserDataPrediction(UserInfoPrediction userInformation) {
        Prediction userPrediction = mlModelService.getUserPrediction(userInformation);
        System.out.println("CHECK");
        return extractUserPrediction(userPrediction);


    }

    private double extractUserPrediction(Prediction prediction) {
        List<Double> pred = prediction.getPrediction();
        return pred.get(0);
    }

    private int scaleUserPrediction(int userPrediction) {
        return 0;
    }
}
