package com.techelevator.model.ModelClasses.edamam.nutrientInfo;

import java.util.Objects;

public class THIA {

    private String label;
    private double quantity;
    private String unit;

    public THIA() {};

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
        THIA thia = (THIA) o;
        return Double.compare(thia.quantity, quantity) == 0 && Objects.equals(label, thia.label) && Objects.equals(unit, thia.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "THIA{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
