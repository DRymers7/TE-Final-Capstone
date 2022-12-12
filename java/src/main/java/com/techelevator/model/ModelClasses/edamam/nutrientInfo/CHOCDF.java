package com.techelevator.model.ModelClasses.edamam.nutrientInfo;

import java.util.Objects;

public class CHOCDF {

    private String label;
    private double quantity;
    private String unit;

    public CHOCDF() {};

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
        CHOCDF chocdf = (CHOCDF) o;
        return Double.compare(chocdf.quantity, quantity) == 0 && Objects.equals(label, chocdf.label) && Objects.equals(unit, chocdf.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "CHOCDF{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
