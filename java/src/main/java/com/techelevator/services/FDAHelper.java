package com.techelevator.services;

import com.techelevator.model.ModelClasses.Meal;
import com.techelevator.model.ModelClasses.edamam.NutritionInfo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FDAHelper {

    private FDAService fdaService = new FDAService("https://api.edamam.com/api/nutrition-data");

    public FDAHelper() {}

    public Meal returnSearchedMealObject(String searchQuery) {
        NutritionInfo info = fdaService.getListOfQueriedFoods(searchQuery);
        Meal meal = prepareNutritionInfoForProcessing(info, searchQuery);
        return meal;
    }

    private Meal prepareNutritionInfoForProcessing(NutritionInfo info, String query) {
        double carbs = info.getTotalNutrients().getChocdfNet().getQuantity();
        String food = query;
        int glycemicIndex = (int) Math.ceil(((carbs - info.getTotalNutrients().getFibtg().getQuantity())));
        Timestamp mealTime = Timestamp.valueOf(LocalDateTime.now());
        Meal meal = new Meal();
        meal.setFood(food);
        meal.setGlycemicIndex(glycemicIndex);
        meal.setMealTime(mealTime);
        return meal;
    }

}
