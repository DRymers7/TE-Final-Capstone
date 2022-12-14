package com.techelevator.model.ModelClasses.Azure;

import java.util.List;

public class Prediction {

    private List<Double> Results;

    public Prediction() {}

    public List<Double> getPrediction() {
        return Results;
    }

    public void setPrediction(List<Double> Results) {
        this.Results = Results;
    }


}
