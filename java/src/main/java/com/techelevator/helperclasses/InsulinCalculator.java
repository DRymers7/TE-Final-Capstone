package com.techelevator.helperclasses;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.dao.dao.MealDao;
import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.model.ModelClasses.Meal;
import com.techelevator.services.FDAService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsulinCalculator {

    //private String baseApiUrl = "https://api.nal.usda.gov/fdc/v1/food";

    //private FDAService fdaService = new FDAService(baseApiUrl);
    // get target ranges from blood sugar

    private MealDao mealDao;
    private BloodSugarDao bloodSugarDao;
    private InsulinDao insulinDao;
    private UserDataDao userDataDao;

    public InsulinCalculator(InsulinDao insulinDao, MealDao mealDao, BloodSugarDao bloodSugarDao, UserDataDao userDataDao) {
        this.mealDao = mealDao;
        this.bloodSugarDao = bloodSugarDao;
        this.insulinDao = insulinDao;
        this.userDataDao = userDataDao;
    };

    // insert logic to throw alerts for non-optimal ranges

    // look at target low vs target high with current bs (input_level)
    // if the bs is higher than the high, we need a correction dose
    // if it is lower than the lower bound we need an alert
    // if it is within the range we need a normal calc

    public Integer calculateUserInsulinDose(int userId) throws SQLException, NullPointerException {
        Map<String, Integer> dosageKey = new HashMap<>();
        if (determineCorrectionalDose(userId) == 1) {
             return createHighCorrectionalDose(userId);

        } else if (determineCorrectionalDose(userId) == 2) {
             return createLowCorrectionalDose(userId);

        } else {
            int carbs = getUserCarbs(userId);
            double userRatio = getUserInsulinInfo(userId).getInsulinRatio();
            return (int) Math.ceil(carbs/userRatio);

        }
    }

    private int determineCorrectionalDose(int userId) { // switch statement
        Map<String,Integer> userBloodSugar = getUserBloodSugarData(userId);
        int targetLow = userBloodSugar.get("TargetLow");
        int targetHigh = userBloodSugar.get("TargetHigh");
        int currentLevel = userBloodSugar.get("CurrentLevel");
        if (currentLevel > targetHigh) {
            return 1;
        } else if (currentLevel < targetLow) {
            return 2;
        } else {
            return 3;
        }

    }

    private int createHighCorrectionalDose(int userId) throws SQLException {
        double correctionFactor = (1700 / getUserInsulinInfo(userId).getBaseLevel());
        Map<String,Integer> bloodSugars = getUserBloodSugarData(userId);
        return (int) Math.ceil((bloodSugars.get("CurrentLevel") - bloodSugars.get("TargetHigh")) / correctionFactor);
    }

    private int createLowCorrectionalDose(int userId) throws SQLException {
        double correctionFactor = (1700 / getUserInsulinInfo(userId).getBaseLevel());
        Map<String,Integer> bloodSugars = getUserBloodSugarData(userId);
        return (int) Math.ceil((bloodSugars.get("CurrentLevel") - bloodSugars.get("TargetLow")) / correctionFactor);
    }

    private Map<String,Integer> getUserBloodSugarData(int userId) throws NullPointerException{
        BloodSugar mostRecentReading = bloodSugarDao.getMostRecentReading(userId);
        Map<String,Integer> dataMap = new HashMap<>();
        dataMap.put("CurrentLevel", mostRecentReading.getInputLevel());
        dataMap.put("TargetLow", mostRecentReading.getTargetLow());
        dataMap.put("TargetHigh", mostRecentReading.getTargetHigh());
        return dataMap;
    }

    private int getUserCarbs(int userId) throws SQLException {
        Meal meal = mealDao.getMostRecentMeal(userId);
        return meal.getCarbs();
    }

    private BaseInsulin getUserInsulinInfo(int userId) throws SQLException {
        BaseInsulin insulin = insulinDao.getPrimaryInsulin(userId);
        return insulin;
    }


}
