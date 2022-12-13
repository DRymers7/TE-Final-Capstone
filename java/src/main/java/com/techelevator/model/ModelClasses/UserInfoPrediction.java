package com.techelevator.model.ModelClasses;

public class UserInfoPrediction {

    private int Glucose;
    private int Insulin;
    private int BMI;
    private int Age;
    private int Diabetes;

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
