package com.techelevator.model.ModelClasses.fdaApi.childClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Foods {

    private int fdcId;
    private String description;
    private String lowercaseDescription;
    private String dataType;
    private String gtinUpc;
    private String publishedDate;
    private String brandOwner;
    private String brandName;
    private String ingredients;
    private String marketCountry;
    private String foodCategory;
    private String modifiedDate;
    private String dataSource;
    private String packageWeight;
    private String servingSizeUnit;
    private double servingSize;
    private String[] tradeChannels;
    private String allHighlightFields;
    private double score;
    @JsonIgnore
    private String[] microbes;
    @JsonIgnore
    private foodNutrients[] foodNutrients;
    @JsonIgnore
    private String[] finalFoodInputFoods;
    @JsonIgnore
    private String[] foodMeasures;
    @JsonIgnore
    private String[] foodAttributes;
    @JsonIgnore
    private String[] foodAttributeTypes;
    @JsonIgnore
    private String[] foodVersionIds;

    public Foods() {}

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLowercaseDescription() {
        return lowercaseDescription;
    }

    public void setLowercaseDescription(String lowercaseDescription) {
        this.lowercaseDescription = lowercaseDescription;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getGtinUpc() {
        return gtinUpc;
    }

    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMarketCountry() {
        return marketCountry;
    }

    public void setMarketCountry(String marketCountry) {
        this.marketCountry = marketCountry;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(String packageWeight) {
        this.packageWeight = packageWeight;
    }

    public String getServingSizeUnit() {
        return servingSizeUnit;
    }

    public void setServingSizeUnit(String servingSizeUnit) {
        this.servingSizeUnit = servingSizeUnit;
    }

    public double getServingSize() {
        return servingSize;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public String[] getTradeChannels() {
        return tradeChannels;
    }

    public void setTradeChannels(String[] tradeChannels) {
        this.tradeChannels = tradeChannels;
    }

    public String getAllHighlightFields() {
        return allHighlightFields;
    }

    public void setAllHighlightFields(String allHighlightFields) {
        this.allHighlightFields = allHighlightFields;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String[] getMicrobes() {
        return microbes;
    }

    public void setMicrobes(String[] microbes) {
        this.microbes = microbes;
    }

    public com.techelevator.model.ModelClasses.fdaApi.childClasses.foodNutrients[] getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(com.techelevator.model.ModelClasses.fdaApi.childClasses.foodNutrients[] foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    public String[] getFinalFoodInputFoods() {
        return finalFoodInputFoods;
    }

    public void setFinalFoodInputFoods(String[] finalFoodInputFoods) {
        this.finalFoodInputFoods = finalFoodInputFoods;
    }

    public String[] getFoodMeasures() {
        return foodMeasures;
    }

    public void setFoodMeasures(String[] foodMeasures) {
        this.foodMeasures = foodMeasures;
    }

    public String[] getFoodAttributes() {
        return foodAttributes;
    }

    public void setFoodAttributes(String[] foodAttributes) {
        this.foodAttributes = foodAttributes;
    }

    public String[] getFoodAttributeTypes() {
        return foodAttributeTypes;
    }

    public void setFoodAttributeTypes(String[] foodAttributeTypes) {
        this.foodAttributeTypes = foodAttributeTypes;
    }

    public String[] getFoodVersionIds() {
        return foodVersionIds;
    }

    public void setFoodVersionIds(String[] foodVersionIds) {
        this.foodVersionIds = foodVersionIds;
    }
}
