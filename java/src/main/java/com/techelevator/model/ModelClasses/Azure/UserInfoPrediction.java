package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



public class UserInfoPrediction {

    @JsonProperty("Inputs")
    private Inputs inputs;
    @JsonProperty("GlobalParameters")
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
