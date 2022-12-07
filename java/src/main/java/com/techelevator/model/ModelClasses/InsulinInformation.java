package com.techelevator.model.ModelClasses;

import java.sql.Timestamp;
import java.util.Objects;

public class InsulinInformation extends BaseInsulin {

    private String insulinBrandName;
    private String insulinType;
    private int halfLife;
    private int onsetLow;
    private int onsetHigh;
    private int peak;
    private int duration;
    public InsulinInformation(){}

    public InsulinInformation(int insulinId, double baseLevel, double averageLevel, Timestamp timeSinceLastDose,
                              String insulinBrandName, String insulinType, String insulinStrength, double insulinRatio,
                              int halfLife, int onsetLow, int onsetHigh, int peak, int duration) {
        super(insulinId, baseLevel, averageLevel, timeSinceLastDose, insulinBrandName, insulinStrength, insulinRatio);
        this.insulinType = insulinType;
        this.halfLife = halfLife;
        this.onsetLow = onsetLow;
        this.onsetHigh = onsetHigh;
        this.peak = peak;
        this.duration = duration;
    }

    @Override
    public String getInsulinBrandName() {
        return insulinBrandName;
    }

    @Override
    public void setInsulinBrandName(String insulinBrandName) {
        this.insulinBrandName = insulinBrandName;
    }

    public String getInsulinType() {
        return insulinType;
    }

    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType;
    }

    public int getHalfLife() {
        return halfLife;
    }

    public void setHalfLife(int halfLife) {
        this.halfLife = halfLife;
    }

    public int getOnsetLow() {
        return onsetLow;
    }

    public void setOnsetLow(int onsetLow) {
        this.onsetLow = onsetLow;
    }

    public int getOnsetHigh() {
        return onsetHigh;
    }

    public void setOnsetHigh(int onsetHigh) {
        this.onsetHigh = onsetHigh;
    }

    public int getPeak() {
        return peak;
    }

    public void setPeak(int peak) {
        this.peak = peak;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InsulinInformation that = (InsulinInformation) o;
        return halfLife == that.halfLife && onsetLow == that.onsetLow && onsetHigh == that.onsetHigh && peak == that.peak && duration == that.duration && Objects.equals(insulinBrandName, that.insulinBrandName) && Objects.equals(insulinType, that.insulinType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), insulinBrandName, insulinType, halfLife, onsetLow, onsetHigh, peak, duration);
    }

    @Override
    public String toString() {
        return "InsulinInformation{" +
                "insulinBrandName='" + insulinBrandName + '\'' +
                ", insulinType='" + insulinType + '\'' +
                ", halfLife=" + halfLife +
                ", onsetLow=" + onsetLow +
                ", onsetHigh=" + onsetHigh +
                ", peak=" + peak +
                ", duration=" + duration +
                '}';
    }
}
