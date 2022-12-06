package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.ModelClasses.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> getUserMeals(int userId) throws SQLException {

        List<Meal> returnList = new ArrayList<>();

        String sql = "SELECT m.meal_id, carbs, food, glycemic_index, meal_time FROM meals m " +
                "JOIN meals_user_join mj ON mj.meal_id = m.meal_id " +
                "JOIN user_data ud ON ud.user_id = mj.user_id " +
                "WHERE ud.user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            returnList.add(mapRowToObject(rowSet));
        }
        return returnList;
    }

    private Meal mapRowToObject(SqlRowSet rowSet) {
        Meal meal = new Meal();
        meal.setMealId(rowSet.getInt("meal_id"));
        meal.setCarbs(rowSet.getInt("carbs"));
        meal.setFood(rowSet.getString("food"));
        meal.setGlycemicIndex(rowSet.getInt("glycemic_index"));
        meal.setMealTime(rowSet.getTimestamp("meal_time"));
        return meal;
    }
}
