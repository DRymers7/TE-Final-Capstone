package com.techelevator.model.ModelClasses.edamam.nutrientInfo;

import java.util.Objects;

public class FOLAC {

    private String label;
    private double quantity;
    private String unit;

    public FOLAC() {};

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
        FOLAC folac = (FOLAC) o;
        return Double.compare(folac.quantity, quantity) == 0 && Objects.equals(label, folac.label) && Objects.equals(unit, folac.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "FOLAC{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
