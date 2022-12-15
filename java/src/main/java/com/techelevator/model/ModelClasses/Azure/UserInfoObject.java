package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserInfoObject {

    private Inputs Inputs;
    private double GlobalParameters;

    public UserInfoObject() {}

    @JsonGetter("Inputs")
    public com.techelevator.model.ModelClasses.Azure.Inputs getInputs() {
        return Inputs;
    }

    @JsonSetter("Inputs")
    public void setInputs(com.techelevator.model.ModelClasses.Azure.Inputs inputs) {
        Inputs = inputs;
    }

    @JsonGetter("GlobalParameters")
    public double getGlobalParameters() {
        return GlobalParameters;
    }

    @JsonSetter("GlobalParameters")
    public void setGlobalParameters(double globalParameters) {
        GlobalParameters = globalParameters;
    }
}
