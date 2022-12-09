package com.techelevator.controller;

import com.techelevator.dao.dao.*;
import com.techelevator.helperclasses.InsulinCalculator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HistoryController {

    private MealDao mealDao;
    private UserDataDao userDataDao;
    private InsulinDao insulinDao;
    private BloodSugarDao bloodSugarDao;
    private UserDao userDao;
    private InsulinCalculator insulinCalculator;
    private DoseDao doseDao;

    public HistoryController(MealDao mealDao, UserDataDao userDataDao, InsulinDao insulinDao, BloodSugarDao bloodSugarDao, UserDao userDao, InsulinCalculator insulinCalculator, DoseDao doseDao) {
        this.mealDao = mealDao;
        this.userDataDao = userDataDao;
        this.insulinDao = insulinDao;
        this.bloodSugarDao = bloodSugarDao;
        this.userDao = userDao;
        this.insulinCalculator = insulinCalculator;
        this.doseDao = doseDao;
    }


}
