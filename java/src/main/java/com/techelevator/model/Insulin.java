package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Insulin {

    private int userId;
    private double baseLevel;
    private double averageLevel;
    private LocalDate daySinceLastDose;

    public Insulin(){}

    public Insulin(int userId, double baseLevel, double averageLevel, LocalDate daySinceLastDose) {
        this.userId = userId;
        this.baseLevel = baseLevel;
        this.averageLevel = averageLevel;
        this.daySinceLastDose = daySinceLastDose;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public LocalDate getDaySinceLastDose() {
        return daySinceLastDose;
    }

    public void setDaySinceLastDose(LocalDate daySinceLastDose) {
        this.daySinceLastDose = daySinceLastDose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insulin insulin = (Insulin) o;
        return userId == insulin.userId && Double.compare(insulin.baseLevel, baseLevel) == 0 && Double.compare(insulin.averageLevel, averageLevel) == 0 && Objects.equals(daySinceLastDose, insulin.daySinceLastDose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, baseLevel, averageLevel, daySinceLastDose);
    }

    @Override
    public String toString() {
        return "Insulin{" +
                "userId=" + userId +
                ", baseLevel=" + baseLevel +
                ", averageLevel=" + averageLevel +
                ", daySinceLastDose=" + daySinceLastDose +
                '}';
    }
}
