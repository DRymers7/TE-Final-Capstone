package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoObject {

    private Inputs Inputs;
    private double GlobalParameters;

    public UserInfoObject() {}

    public com.techelevator.model.ModelClasses.Azure.Inputs getInputs() {
        return Inputs;
    }

    public void setInputs(com.techelevator.model.ModelClasses.Azure.Inputs inputs) {
        Inputs = inputs;
    }

    public double getGlobalParameters() {
        return GlobalParameters;
    }

    public void setGlobalParameters(double globalParameters) {
        GlobalParameters = globalParameters;
    }
}
