package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

public class Prediction {
    @JsonAlias("Results")

    private ArrayList<Double> Results;

    public Prediction() {}

    @JsonGetter("Results")
    public ArrayList<Double> getResults() {
        return Results;
    }

    @JsonSetter("Results")
    public void setResults(ArrayList<Double> results) {
        Results = results;
    }


}
