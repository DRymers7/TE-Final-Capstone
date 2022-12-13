package com.techelevator.model.ModelClasses.fdaApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.model.ModelClasses.fdaApi.childClasses.FoodSearchCriteria;
import com.techelevator.model.ModelClasses.fdaApi.childClasses.Foods;

public class Response {

    @JsonProperty("totalHits")
    private int totalHits;
    @JsonProperty("currentPage")
    private int currentPage;
    @JsonProperty("totalPages")
    private int totalPages;
    @JsonProperty("pageList")
    private int[] pageList;
    @JsonProperty("foodSearchCriteria")
    private FoodSearchCriteria foodSearchCriteria;
    @JsonProperty("foods")
    private Foods[] foods;

    public Response() {}

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int[] getPageList() {
        return pageList;
    }

    public void setPageList(int[] pageList) {
        this.pageList = pageList;
    }

    public FoodSearchCriteria getFoodSearchCriteria() {
        return foodSearchCriteria;
    }

    public void setFoodSearchCriteria(FoodSearchCriteria foodSearchCriteria) {
        this.foodSearchCriteria = foodSearchCriteria;
    }

    public Foods[] getFoods() {
        return foods;
    }

    public void setFoods(Foods[] foods) {
        this.foods = foods;
    }
}
