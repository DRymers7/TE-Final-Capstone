package com.techelevator.controller;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.model.ModelClasses.Meal;
import com.techelevator.model.ModelClasses.edamam.NutritionInfo;
import com.techelevator.services.FDAHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class MealController {

    private MealDao mealDao;
    private UserDao userDao;
    private FDAHelper fdaHelper = new FDAHelper();

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

    @RequestMapping(path = "/meals", method = RequestMethod.POST)
    public Meal createNewMeal(@RequestBody Meal meal, Principal principal) {

        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return mealDao.createUserMeal(userId, meal);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
    }

    @RequestMapping(path = "/meals", method = RequestMethod.PUT)
    public boolean updateMealData(@RequestBody Meal meal) {

        try {
            mealDao.updateUserMealData(meal.getMealId(), meal);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/meals", method = RequestMethod.DELETE)
    public boolean deleteMealData(@RequestBody Meal meal, Principal principal) {

        try {
            int userId = userDao.findIdByUsername(principal.getName());
            mealDao.deleteMealData(userId, meal);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/meals/info/{query}", method = RequestMethod.GET)
    public List<Meal> logNewUserMealAndReturnRunningCarbs(@PathVariable String query, Principal principal) {
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            Meal userMeal = fdaHelper.returnSearchedMealObject(query);
            mealDao.createUserMeal(userId, userMeal);
            return mealDao.getUserMealsToday(userId);

        }catch (SQLException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
