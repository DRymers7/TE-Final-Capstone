package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Inputs {
    @JsonAlias({ "Inputs" })

    private data[] data;

    public Inputs() {}

    @JsonGetter("data")
    public com.techelevator.model.ModelClasses.Azure.data[] getData() {
        return data;
    }
    @JsonSetter("data")
    public void setData(com.techelevator.model.ModelClasses.Azure.data[] data) {
        this.data = data;
    }
}
