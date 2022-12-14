package com.techelevator.model.ModelClasses.Azure;

public class UserInfoPrediction {

    private Inputs inputs;
    private double GlobalParameters;


    public UserInfoPrediction() {};

    public Inputs getInputs() {
        return inputs;
    }

    public void setInputs(Inputs inputs) {
        this.inputs = inputs;
    }

    public double getGlobalParameters() {
        return GlobalParameters;
    }

    public void setGlobalParameters(double globalParameters) {
        GlobalParameters = globalParameters;
    }
}
