package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inputs {

    @JsonProperty("data")
    private data[] data;

    public Inputs() {}

    public com.techelevator.model.ModelClasses.Azure.data[] getData() {
        return data;
    }

    public void setData(com.techelevator.model.ModelClasses.Azure.data[] data) {
        this.data = data;
    }
}
