package com.techelevator.model.ModelClasses.Azure;

public class BLOB {

    private int doseUnits;
    private int userAge;
    private double bmi;
    private int diabetesType;

    public BLOB() {}

    public int getDoseUnits() {
        return doseUnits;
    }

    public void setDoseUnits(int doseUnits) {
        this.doseUnits = doseUnits;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getDiabetesType() {
        return diabetesType;
    }

    public void setDiabetesType(int diabetesType) {
        this.diabetesType = diabetesType;
    }
}
