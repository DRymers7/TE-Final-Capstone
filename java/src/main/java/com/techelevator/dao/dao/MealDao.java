package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.Meal;

import java.sql.SQLException;
import java.util.List;

public interface MealDao {

    List<Meal> getUserMeals(int userId) throws SQLException;
}
