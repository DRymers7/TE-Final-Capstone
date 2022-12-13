package com.techelevator.model.ModelClasses.fdaApi.childClasses;

public class FoodSearchCriteria {

    private String query;
    private String generalSearchInput;
    private int pageNumber;
    private int numberOfResultsPerPage;
    private int pageSize;
    private boolean requireAllWords;

    public FoodSearchCriteria(){};

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getGeneralSearchInput() {
        return generalSearchInput;
    }

    public void setGeneralSearchInput(String generalSearchInput) {
        this.generalSearchInput = generalSearchInput;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getNumberOfResultsPerPage() {
        return numberOfResultsPerPage;
    }

    public void setNumberOfResultsPerPage(int numberOfResultsPerPage) {
        this.numberOfResultsPerPage = numberOfResultsPerPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isRequireAllWords() {
        return requireAllWords;
    }

    public void setRequireAllWords(boolean requireAllWords) {
        this.requireAllWords = requireAllWords;
    }
}
