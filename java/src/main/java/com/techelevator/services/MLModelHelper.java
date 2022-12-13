package com.techelevator.services;

import com.techelevator.model.ModelClasses.Prediction;
import com.techelevator.model.ModelClasses.UserInfoPrediction;

import java.util.Map;

public class MLModelHelper {

    private MLModelService mlModelService = new MLModelService("http://127.0.0.1:5000/");

    public MLModelHelper() {}

    public int returnUserDataPrediction(UserInfoPrediction userInformation) {
        Prediction userPrediction = mlModelService.getUserPrediction(userInformation);
        System.out.println("CHECK");
        extractUserPrediction(userPrediction);
        return -1;


    }

    private int extractUserPrediction(Prediction prediction) {
        int[] pred = prediction.getPrediction();
        return pred[0];
    }

    private int scaleUserPrediction(int userPrediction) {
        return 0;
    }
}
