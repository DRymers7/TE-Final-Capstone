package com.techelevator.model.ModelClasses;

import java.sql.Timestamp;
import java.util.Objects;

public class History {

    private int bloodSugarId;
    private int targetLow;
    private int targetHigh;
    private int inputLevel;
    private Timestamp lastMeasurement;
    private String typeOfDose;
    private int doseUnits;
    private int doseId;
    private Timestamp timeOfDose;

    public History() {

    };

    public History(int bloodSugarId, int targetLow, int targetHigh, int inputLevel, Timestamp lastMeasurement, String typeOfDose, int doseUnits, int doseId, Timestamp timeOfDose) {
        this.bloodSugarId = bloodSugarId;
        this.targetLow = targetLow;
        this.targetHigh = targetHigh;
        this.inputLevel = inputLevel;
        this.lastMeasurement = lastMeasurement;
        this.typeOfDose = typeOfDose;
        this.doseUnits = doseUnits;
        this.doseId = doseId;
        this.timeOfDose = timeOfDose;
    }

    public int getBloodSugarId() {
        return bloodSugarId;
    }

    public void setBloodSugarId(int bloodSugarId) {
        this.bloodSugarId = bloodSugarId;
    }

    public int getTargetLow() {
        return targetLow;
    }

    public void setTargetLow(int targetLow) {
        this.targetLow = targetLow;
    }

    public int getTargetHigh() {
        return targetHigh;
    }

    public void setTargetHigh(int targetHigh) {
        this.targetHigh = targetHigh;
    }

    public int getInputLevel() {
        return inputLevel;
    }

    public void setInputLevel(int inputLevel) {
        this.inputLevel = inputLevel;
    }

    public Timestamp getLastMeasurement() {
        return lastMeasurement;
    }

    public void setLastMeasurement(Timestamp lastMeasurement) {
        this.lastMeasurement = lastMeasurement;
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
        History history = (History) o;
        return bloodSugarId == history.bloodSugarId && targetLow == history.targetLow && targetHigh == history.targetHigh && inputLevel == history.inputLevel && doseUnits == history.doseUnits && doseId == history.doseId && Objects.equals(lastMeasurement, history.lastMeasurement) && Objects.equals(typeOfDose, history.typeOfDose) && Objects.equals(timeOfDose, history.timeOfDose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bloodSugarId, targetLow, targetHigh, inputLevel, lastMeasurement, typeOfDose, doseUnits, doseId, timeOfDose);
    }

    @Override
    public String toString() {
        return "History{" +
                "bloodSugarId=" + bloodSugarId +
                ", targetLow=" + targetLow +
                ", targetHigh=" + targetHigh +
                ", inputLevel=" + inputLevel +
                ", lastMeasurement=" + lastMeasurement +
                ", typeOfDose='" + typeOfDose + '\'' +
                ", doseUnits=" + doseUnits +
                ", doseId=" + doseId +
                ", timeOfDose=" + timeOfDose +
                '}';
    }
}
