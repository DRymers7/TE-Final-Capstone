package com.techelevator.model.ModelClasses.fdaApi.childClasses;

public class foodNutrients {

    private int nutrientId;
    private String nutrientName;
    private String nutrientNumber;
    private String unitName;
    private String derivationCode;
    private String derivationDescription;
    private int derivationId;
    private double value;
    private int foodNutrientSourceId;
    private String foodNutrientSourceCode;
    private int rank;
    private int indentLevel;
    private int foodNutrientId;

    public foodNutrients(){}

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDerivationCode() {
        return derivationCode;
    }

    public void setDerivationCode(String derivationCode) {
        this.derivationCode = derivationCode;
    }

    public String getDerivationDescription() {
        return derivationDescription;
    }

    public void setDerivationDescription(String derivationDescription) {
        this.derivationDescription = derivationDescription;
    }

    public int getDerivationId() {
        return derivationId;
    }

    public void setDerivationId(int derivationId) {
        this.derivationId = derivationId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getFoodNutrientSourceId() {
        return foodNutrientSourceId;
    }

    public void setFoodNutrientSourceId(int foodNutrientSourceId) {
        this.foodNutrientSourceId = foodNutrientSourceId;
    }

    public String getFoodNutrientSourceCode() {
        return foodNutrientSourceCode;
    }

    public void setFoodNutrientSourceCode(String foodNutrientSourceCode) {
        this.foodNutrientSourceCode = foodNutrientSourceCode;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getIndentLevel() {
        return indentLevel;
    }

    public void setIndentLevel(int indentLevel) {
        this.indentLevel = indentLevel;
    }

    public int getFoodNutrientId() {
        return foodNutrientId;
    }

    public void setFoodNutrientId(int foodNutrientId) {
        this.foodNutrientId = foodNutrientId;
    }
}
