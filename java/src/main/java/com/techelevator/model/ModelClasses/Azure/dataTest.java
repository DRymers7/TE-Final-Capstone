package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class dataTest {
    @JsonAlias("Inputs")

    @JsonProperty("data")
    private valuesTest[] valuesTest;

    public dataTest() {}

    @JsonGetter("data")
    public com.techelevator.model.ModelClasses.Azure.valuesTest[] getValuesTest() {
        return valuesTest;
    }
    @JsonSetter("data")
    public void setValuesTest(com.techelevator.model.ModelClasses.Azure.valuesTest[] valuesTest) {
        this.valuesTest = valuesTest;
    }
}
