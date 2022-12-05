package com.techelevator.model.ModelClasses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class BloodSugar {

    private int bloodSugarId;
    private int targetLow;
    private int targetHigh;
    private int inputLevel;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
    private LocalDateTime lastMeasurement;

    public BloodSugar() {
    }

    public BloodSugar(int bloodSugarId, int targetLow, int targetHigh, int inputLevel, LocalDateTime lastMeasurement) {
        this.bloodSugarId = bloodSugarId;
        this.targetLow = targetLow;
        this.targetHigh = targetHigh;
        this.inputLevel = inputLevel;
        this.lastMeasurement = lastMeasurement;
    }

    public int getBloodSugarId() {
        return bloodSugarId;
    }

    public void setBloodSugarId(Integer bloodSugarId) {
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

    public LocalDateTime getLastMeasurement() {
        return lastMeasurement;
    }

    public void setLastMeasurement(LocalDateTime lastMeasurement) {
        this.lastMeasurement = lastMeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodSugar that = (BloodSugar) o;
        return bloodSugarId == that.bloodSugarId && targetLow == that.targetLow && targetHigh == that.targetHigh && inputLevel == that.inputLevel && Objects.equals(lastMeasurement, that.lastMeasurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bloodSugarId, targetLow, targetHigh, inputLevel, lastMeasurement);
    }

    @Override
    public String toString() {
        return "BloodSugar{" +
                "bloodSugarId=" + bloodSugarId +
                ", targetLow=" + targetLow +
                ", targetHigh=" + targetHigh +
                ", inputLevel=" + inputLevel +
                ", lastMeasurement=" + lastMeasurement +
                '}';
    }
}