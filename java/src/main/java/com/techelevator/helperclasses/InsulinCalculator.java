package com.techelevator.helperclasses;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.dao.dao.MealDao;
import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.services.FDAService;

public class InsulinCalculator {

    //private String baseApiUrl = "https://api.nal.usda.gov/fdc/v1/food";

    //private FDAService fdaService = new FDAService(baseApiUrl);

    private MealDao mealDao;
    private BloodSugarDao bloodSugarDao;
    private InsulinDao insulinDao;
    private UserDataDao userDataDao;

    public InsulinCalculator() {};

    public int calculateUserInsulinDose() {
        return -1;
    }

    private int calculateCHOCoverage() {
        return -1;
    }


}
