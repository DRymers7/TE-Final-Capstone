package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class data {

    @JsonProperty("Insulin")
    private int Insulin;
    @JsonProperty("BMI")
    private double BMI;
    @JsonProperty("Age")
    private int Age;
    @JsonProperty("Outcome")
    private int Outcome;

    public data() {}

    public int getInsulin() {
        return Insulin;
    }

    public void setInsulin(int insulin) {
        Insulin = insulin;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getOutcome() {
        return Outcome;
    }

    public void setOutcome(int outcome) {
        Outcome = outcome;
    }
}
