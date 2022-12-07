package com.techelevator.helperclasses;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.dao.dao.MealDao;
import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.model.ModelClasses.Meal;
import com.techelevator.services.FDAService;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public int calculateUserInsulinDose(int userId) throws SQLException, NullPointerException {
        List<Integer> targetRanges = getUserBloodSugarData(userId);
        int carbs = getUserCarbs(userId);
        double userRatio = getUserInsulinInfo(userId);
        return (int) Math.ceil(carbs/userRatio);
    }

    private List<Integer> getUserBloodSugarData(int userId) throws NullPointerException{
        BloodSugar mostRecentReading = bloodSugarDao.getMostRecentReading(userId);
        List<Integer> targetBloodSugarRange = new ArrayList<>();
        targetBloodSugarRange.add(mostRecentReading.getTargetLow());
        targetBloodSugarRange.add(mostRecentReading.getTargetHigh());
        return targetBloodSugarRange;
    }

    private int getUserCarbs(int userId) throws SQLException {
        Meal meal = mealDao.getMostRecentMeal(userId);
        return meal.getCarbs();
    }

    private double getUserInsulinInfo(int userId) throws SQLException {
        BaseInsulin insulin = insulinDao.getPrimaryInsulin(userId);
        return insulin.getInsulinRatio();
    }


}
