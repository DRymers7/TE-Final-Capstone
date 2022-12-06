package com.techelevator.model.ModelClasses;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BaseInsulin {

    private int insulinId;
    private double baseLevel;
    private double averageLevel;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Timestamp timeSinceLastDose;
    private String insulinType;
    private String insulinStrength;
    private double insulinRation;

    public BaseInsulin() {};

    public BaseInsulin(int insulinId, double baseLevel, double averageLevel, Timestamp timeSinceLastDose, String insulinType, String insulinStrength, double insulinRation) {
        this.insulinId = insulinId;
        this.baseLevel = baseLevel;
        this.averageLevel = averageLevel;
        this.timeSinceLastDose = timeSinceLastDose;
        this.insulinType = insulinType;
        this.insulinStrength = insulinStrength;
        this.insulinRation = insulinRation;
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

    public String getInsulinType() {
        return insulinType;
    }

    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType;
    }

    public String getInsulinStrength() {
        return insulinStrength;
    }

    public void setInsulinStrength(String insulinStrength) {
        this.insulinStrength = insulinStrength;
    }

    public double getInsulinRation() {
        return insulinRation;
    }

    public void setInsulinRation(double insulinRation) {
        this.insulinRation = insulinRation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseInsulin that = (BaseInsulin) o;
        return insulinId == that.insulinId && Double.compare(that.baseLevel, baseLevel) == 0 && Double.compare(that.averageLevel, averageLevel) == 0 && Double.compare(that.insulinRation, insulinRation) == 0 && Objects.equals(timeSinceLastDose, that.timeSinceLastDose) && Objects.equals(insulinType, that.insulinType) && Objects.equals(insulinStrength, that.insulinStrength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insulinId, baseLevel, averageLevel, timeSinceLastDose, insulinType, insulinStrength, insulinRation);
    }

    @Override
    public String toString() {
        return "BaseInsulin{" +
                "insulinId=" + insulinId +
                ", baseLevel=" + baseLevel +
                ", averageLevel=" + averageLevel +
                ", timeSinceLastDose=" + timeSinceLastDose +
                ", insulinType='" + insulinType + '\'' +
                ", insulinStrength='" + insulinStrength + '\'' +
                ", insulinRation=" + insulinRation +
                '}';
    }
}
