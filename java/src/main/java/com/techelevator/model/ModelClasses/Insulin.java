package com.techelevator.model.ModelClasses;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class Insulin extends BaseInsulin {

    private int halfLife;
    private int onset;
    private int peak;
    private int duration;
    private Timestamp timeSinceLastDose;

    public Insulin(){}

    public Insulin(int insulinId, double baseLevel, double averageLevel, Timestamp timeSinceLastDose, String insulinType, String insulinStrength, int halfLife, int onset, int peak, double insulinRation, int duration) {
        super(insulinId, baseLevel, averageLevel, timeSinceLastDose, insulinType, insulinStrength, insulinRation);
        this.halfLife = halfLife;
        this.onset = onset;
        this.peak = peak;
        this.duration = duration;
        this.timeSinceLastDose = timeSinceLastDose;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public Timestamp getTimeSinceLastDose() {
        return timeSinceLastDose;
    }

    public void setTimeSinceLastDose(Timestamp timeSinceLastDose) {
        this.timeSinceLastDose = timeSinceLastDose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Insulin insulin = (Insulin) o;
        return halfLife == insulin.halfLife && onset == insulin.onset && peak == insulin.peak && duration == insulin.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), halfLife, onset, peak, duration);
    }
}
