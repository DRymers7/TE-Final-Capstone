package com.techelevator.controller;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.model.ModelClasses.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class MealController {

    private MealDao mealDao;
    private UserDao userDao;

    public MealController(MealDao mealDao, UserDao userDao) {
        this.mealDao = mealDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/meals", method = RequestMethod.GET)
    public List<Meal> getUserMeals(Principal principal) {

        try {
            List<Meal> meals = mealDao.getUserMeals(userDao.findIdByUsername(principal.getName()));
            return meals;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
