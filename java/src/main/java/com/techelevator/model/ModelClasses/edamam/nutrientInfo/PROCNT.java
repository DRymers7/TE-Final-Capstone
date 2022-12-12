package com.techelevator.model.ModelClasses.edamam.nutrientInfo;

import java.util.Objects;

public class PROCNT {

    private String label;
    private double quantity;
    private String unit;

    public PROCNT() {};

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
        PROCNT procnt = (PROCNT) o;
        return Double.compare(procnt.quantity, quantity) == 0 && Objects.equals(label, procnt.label) && Objects.equals(unit, procnt.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "PROCNT{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
