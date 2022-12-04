package com.techelevator.model.ModelClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Insulin extends BaseInsulin {

    private int insulinId;
    private double baseLevel;
    private double averageLevel;
    private LocalDateTime timeSinceLastDose;
    private String insulinType;
    private String insulinStrength;
    private int halfLife;
    private int onset;
    private int peak;
    private double insulinRation;
    private int duration;

    public Insulin(){}

    public Insulin(int insulinId, double baseLevel, double averageLevel, LocalDateTime timeSinceLastDose, String insulinType, String insulinStrength, int halfLife, int onset, int peak, double insulinRation, int duration) {
        super(baseLevel, averageLevel, timeSinceLastDose, insulinType, insulinStrength, insulinRation);
        this.insulinId = insulinId;
        this.halfLife = halfLife;
        this.onset = onset;
        this.peak = peak;
        this.duration = duration;
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

    public LocalDateTime getTimeSinceLastDose() {
        return timeSinceLastDose;
    }

    public void setTimeSinceLastDose(LocalDateTime timeSinceLastDose) {
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

    public int getHalfLife() {
        return halfLife;
    }

    public void setHalfLife(int halfLife) {
        this.halfLife = halfLife;
    }

    public int getOnset() {
        return onset;
    }

    public void setOnset(int onset) {
        this.onset = onset;
    }

    public int getPeak() {
        return peak;
    }

    public void setPeak(int peak) {
        this.peak = peak;
    }

    public double getInsulinRation() {
        return insulinRation;
    }

    public void setInsulinRation(double insulinRation) {
        this.insulinRation = insulinRation;
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
        Insulin insulin = (Insulin) o;
        return insulinId == insulin.insulinId && Double.compare(insulin.baseLevel, baseLevel) == 0 && Double.compare(insulin.averageLevel, averageLevel) == 0 && halfLife == insulin.halfLife && onset == insulin.onset && peak == insulin.peak && Double.compare(insulin.insulinRation, insulinRation) == 0 && duration == insulin.duration && Objects.equals(timeSinceLastDose, insulin.timeSinceLastDose) && Objects.equals(insulinType, insulin.insulinType) && Objects.equals(insulinStrength, insulin.insulinStrength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insulinId, baseLevel, averageLevel, timeSinceLastDose, insulinType, insulinStrength, halfLife, onset, peak, insulinRation, duration);
    }

    @Override
    public String toString() {
        return "Insulin{" +
                "insulinId=" + insulinId +
                ", baseLevel=" + baseLevel +
                ", averageLevel=" + averageLevel +
                ", timeSinceLastDose=" + timeSinceLastDose +
                ", insulinType='" + insulinType + '\'' +
                ", insulinStrength='" + insulinStrength + '\'' +
                ", halfLife=" + halfLife +
                ", onset=" + onset +
                ", peak=" + peak +
                ", insulinRation=" + insulinRation +
                ", duration=" + duration +
                '}';
    }

}
