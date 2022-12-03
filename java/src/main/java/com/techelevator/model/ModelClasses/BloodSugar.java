package com.techelevator.model.ModelClasses;

import java.time.LocalDate;
import java.util.Objects;

public class BloodSugar {

    private int userId;
    private int targetLow;
    private int targetHigh;
    private int inputLevel;
    private LocalDate lastMeasurement;

    public BloodSugar() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public LocalDate getLastMeasurement() {
        return lastMeasurement;
    }

    public void setLastMeasurement(LocalDate lastMeasurement) {
        this.lastMeasurement = lastMeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodSugar that = (BloodSugar) o;
        return userId == that.userId && targetLow == that.targetLow && targetHigh == that.targetHigh && inputLevel == that.inputLevel && Objects.equals(lastMeasurement, that.lastMeasurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, targetLow, targetHigh, inputLevel, lastMeasurement);
    }

    @Override
    public String toString() {
        return "BloodSugar{" +
                "userId=" + userId +
                ", targetLow=" + targetLow +
                ", targetHigh=" + targetHigh +
                ", inputLevel=" + inputLevel +
                ", lastMeasurement=" + lastMeasurement +
                '}';
    }
}