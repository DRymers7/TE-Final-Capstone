package com.techelevator.controller;

import com.techelevator.dao.dao.*;
import com.techelevator.helperclasses.InsulinCalculator;
import com.techelevator.model.ModelClasses.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;

@RestController
public class DosageController {

    private MealDao mealDao;
    private UserDataDao userDataDao;
    private InsulinDao insulinDao;
    private BloodSugarDao bloodSugarDao;
    private UserDao userDao;
    private InsulinCalculator insulinCalculator;

    public DosageController(MealDao mealDao, UserDataDao userDataDao,
                            InsulinDao insulinDao, BloodSugarDao bloodSugarDao, UserDao userDao) {
        this.mealDao = mealDao;
        this.userDataDao = userDataDao;
        this.insulinDao = insulinDao;
        this.bloodSugarDao = bloodSugarDao;
        this.userDao = userDao;
        this.insulinCalculator = new InsulinCalculator(insulinDao, mealDao, bloodSugarDao, userDataDao);
    }

    @RequestMapping(path = "/dose", method = RequestMethod.GET)
    public int getUserInsulinDose(Principal principal) {
        try {
            return insulinCalculator.calculateUserInsulinDose(userDao.findIdByUsername(principal.getName()));
        } catch (NullPointerException | SQLException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }


}
