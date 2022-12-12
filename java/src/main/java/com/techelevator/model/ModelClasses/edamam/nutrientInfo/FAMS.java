package com.techelevator.model.ModelClasses.edamam.nutrientInfo;

import java.util.Objects;

public class FAMS {

    private String label;
    private double quantity;
    private String unit;

    public FAMS() {};

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
        FAMS fams = (FAMS) o;
        return Double.compare(fams.quantity, quantity) == 0 && Objects.equals(label, fams.label) && Objects.equals(unit, fams.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "FAMS{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
