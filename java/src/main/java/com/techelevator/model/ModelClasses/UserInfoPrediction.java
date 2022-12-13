package com.techelevator.model.ModelClasses;

public class UserInfoPrediction {

    private Integer Glucose;
    private Integer Insulin;
    private Integer BMI;
    private Integer Age;
    private Integer Diabetes;

    public UserInfoPrediction() {};

    public int getGlucose() {
        return Glucose;
    }

    public void setGlucose(int glucose) {
        Glucose = glucose;
    }

    public int getInsulin() {
        return Insulin;
    }

    public void setInsulin(int insulin) {
        Insulin = insulin;
    }

    public int getBMI() {
        return BMI;
    }

    public void setBMI(int BMI) {
        this.BMI = BMI;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(int diabetes) {
        Diabetes = diabetes;
    }
}
