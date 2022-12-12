package com.techelevator.model.ModelClasses.edamam.nutrientInfo;

import java.util.Objects;

public class FAT {

    private String label;
    private double quantity;
    private String unit;

    public FAT() {};

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
        FAT fat = (FAT) o;
        return Double.compare(fat.quantity, quantity) == 0 && Objects.equals(label, fat.label) && Objects.equals(unit, fat.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "FAT{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
