package com.techelevator.model.ModelClasses;

import java.sql.Timestamp;
import java.util.Objects;

public class Dose {

    private int inputLevel;
    private String typeOfDose;
    private int doseUnits;
    private int doseId;
    private Timestamp timeOfDose;

    public Dose() {

    };

    public Dose(int inputLevel, String typeOfDose, int doseUnits, int doseId, Timestamp timeOfDose) {
        this.inputLevel = inputLevel;
        this.typeOfDose = typeOfDose;
        this.doseUnits = doseUnits;
        this.doseId = doseId;
        this.timeOfDose = timeOfDose;
    }

    public int getInputLevel() {
        return inputLevel;
    }

    public void setInputLevel(int inputLevel) {
        this.inputLevel = inputLevel;
    }

    public String getTypeOfDose() {
        return typeOfDose;
    }

    public void setTypeOfDose(String typeOfDose) {
        this.typeOfDose = typeOfDose;
    }

    public int getDoseUnits() {
        return doseUnits;
    }

    public void setDoseUnits(int doseUnits) {
        this.doseUnits = doseUnits;
    }

    public int getDoseId() {
        return doseId;
    }

    public void setDoseId(int doseId) {
        this.doseId = doseId;
    }

    public Timestamp getTimeOfDose() {
        return timeOfDose;
    }

    public void setTimeOfDose(Timestamp timeOfDose) {
        this.timeOfDose = timeOfDose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dose dose = (Dose) o;
        return inputLevel == dose.inputLevel && doseUnits == dose.doseUnits && doseId == dose.doseId && Objects.equals(typeOfDose, dose.typeOfDose) && Objects.equals(timeOfDose, dose.timeOfDose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputLevel, typeOfDose, doseUnits, doseId, timeOfDose);
    }

    @Override
    public String toString() {
        return "Dose{" +
                "inputLevel=" + inputLevel +
                ", typeOfDose='" + typeOfDose + '\'' +
                ", doseUnits=" + doseUnits +
                ", doseId=" + doseId +
                ", timeOfDose=" + timeOfDose +
                '}';
    }
}
