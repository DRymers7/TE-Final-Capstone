package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.Meal;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.List;

public interface MealDao {

    List<Meal> getUserMeals(int userId) throws SQLException;
    Meal createUserMeal(int userId, Meal meal) throws SQLException ;
    boolean updateUserMealData(int mealId, Meal meal) throws SQLException;
    boolean deleteMealData(int userId, Meal meal) throws SQLException;

}
