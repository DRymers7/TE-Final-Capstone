package com.techelevator.model.ModelClasses.edamam.nutrientInfo;

import java.util.Objects;

public class ENERC_KCAL {

    private String label;
    private double quanitity;
    private String unit;

    public ENERC_KCAL() {};

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(double quanitity) {
        this.quanitity = quanitity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ENERC_KCAL that = (ENERC_KCAL) o;
        return Double.compare(that.quanitity, quanitity) == 0 && Objects.equals(label, that.label) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quanitity, unit);
    }

    @Override
    public String toString() {
        return "ENERC_KCAL{" +
                "label='" + label + '\'' +
                ", quanitity=" + quanitity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
