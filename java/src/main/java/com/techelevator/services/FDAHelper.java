package com.techelevator.services;

import com.techelevator.model.ModelClasses.edamam.NutritionInfo;

public class FDAHelper {

    private FDAService fdaService = new FDAService("https://api.edamam.com/api/nutrition-data");

    public FDAHelper() {}

    public NutritionInfo returnSearchedMealObject(String searchQuery) {
        return fdaService.getListOfQueriedFoods(searchQuery);
    }

}
