package com.techelevator.services;

import com.techelevator.model.ModelClasses.Azure.*;

public class MLModelHelper {

    private MLModelService mlModelService = new MLModelService("http://127.0.0.1:5000/");

    public MLModelHelper() {}

    public double returnUserBloodSugarPredictionFromAzure(BLOB blob) {
        UserInfoObject userInfoObject = buildUserInfoObject(blob);
        Prediction prediction = mlModelService.getUserPredictionAzure(userInfoObject);
        return prediction.getResults().get(0);
    }

    private UserInfoObject buildUserInfoObject(BLOB blob) {
        UserInfoObject userInfoObject = new UserInfoObject();
        userInfoObject.setInputs(buildInputs(blob));
        userInfoObject.setGlobalParameters(0);
        return userInfoObject;
    }

    private Inputs buildInputs(BLOB blob) {
        Inputs inputs = new Inputs();
        data data = buildData(blob);
        data[] dataArr = new data[]{data};
        inputs.setData(dataArr);
        return inputs;
    }

    private data buildData(BLOB blob) {
        data data = new data();
        data.setInsulin(blob.getDoseUnits());
        data.setBMI(blob.getBmi());
        data.setAge(blob.getUserAge());
        data.setOutcome(blob.getDiabetesType());
        return data;
    }

}
