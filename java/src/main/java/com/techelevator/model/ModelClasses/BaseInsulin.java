package com.techelevator.model.ModelClasses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Objects;

public class BaseInsulin {

    private int insulinId;
    private double baseLevel;
    private double averageLevel;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Timestamp timeSinceLastDose;
    private String insulinBrandName;
    private String insulinStrength;
    private double insulinRatio;

    public BaseInsulin() {};

    public BaseInsulin(int insulinId, double baseLevel, double averageLevel, Timestamp timeSinceLastDose, String insulinBrandName, String insulinStrength, double insulinRatio) {
        this.insulinId = insulinId;
        this.baseLevel = baseLevel;
        this.averageLevel = averageLevel;
        this.timeSinceLastDose = timeSinceLastDose;
        this.insulinBrandName = insulinBrandName;
        this.insulinStrength = insulinStrength;
        this.insulinRatio = insulinRatio;
    }

    public int getInsulinId() {
        return insulinId;
    }

    public void setInsulinId(int insulinId) {
        this.insulinId = insulinId;
    }

    public double getBaseLevel() {
        return baseLevel;
    }

    public void setBaseLevel(double baseLevel) {
        this.baseLevel = baseLevel;
    }

    public double getAverageLevel() {
        return averageLevel;
    }

    public void setAverageLevel(double averageLevel) {
        this.averageLevel = averageLevel;
    }

    public Timestamp getTimeSinceLastDose() {
        return timeSinceLastDose;
    }

    public void setTimeSinceLastDose(Timestamp timeSinceLastDose) {
        this.timeSinceLastDose = timeSinceLastDose;
    }

    public String getInsulinBrandName() {
        return insulinBrandName;
    }

    public void setInsulinBrandName(String insulinBrandName) {
        this.insulinBrandName = insulinBrandName;
    }

    public String getInsulinStrength() {
        return insulinStrength;
    }

    public void setInsulinStrength(String insulinStrength) {
        this.insulinStrength = insulinStrength;
    }

    public double getInsulinRatio() {
        return insulinRatio;
    }

    public void setInsulinRatio(double insulinRatio) {
        this.insulinRatio = insulinRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseInsulin that = (BaseInsulin) o;
        return insulinId == that.insulinId && Double.compare(that.baseLevel, baseLevel) == 0 && Double.compare(that.averageLevel, averageLevel) == 0 && Double.compare(that.insulinRatio, insulinRatio) == 0 && Objects.equals(timeSinceLastDose, that.timeSinceLastDose) && Objects.equals(insulinBrandName, that.insulinBrandName) && Objects.equals(insulinStrength, that.insulinStrength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insulinId, baseLevel, averageLevel, timeSinceLastDose, insulinBrandName, insulinStrength, insulinRatio);
    }

    @Override
    public String toString() {
        return "BaseInsulin{" +
                "insulinId=" + insulinId +
                ", baseLevel=" + baseLevel +
                ", averageLevel=" + averageLevel +
                ", timeSinceLastDose=" + timeSinceLastDose +
                ", insulinBrandName='" + insulinBrandName + '\'' +
                ", insulinStrength='" + insulinStrength + '\'' +
                ", insulinRation=" + insulinRatio +
                '}';
    }
}
