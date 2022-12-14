package com.techelevator.model.ModelClasses.Azure;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class data {
    @JsonAlias( {"data"} )

    private int Insulin;
    private double BMI;
    private int Age;
    private int Outcome;

    public data() {}

    @JsonGetter("Insulin")
    public int getInsulin() {
        return Insulin;
    }

    @JsonSetter("Insulin")
    public void setInsulin(int insulin) {
        Insulin = insulin;
    }

    @JsonGetter("BMI")
    public double getBMI() {
        return BMI;
    }

    @JsonSetter("BMI")
    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    @JsonGetter("Age")
    public int getAge() {
        return Age;
    }

    @JsonSetter("Age")
    public void setAge(int age) {
        Age = age;
    }

    @JsonGetter("Outcome")
    public int getOutcome() {
        return Outcome;
    }

    @JsonSetter("Outcome")
    public void setOutcome(int outcome) {
        Outcome = outcome;
    }
}
