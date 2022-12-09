package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.ModelClasses.Meal;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
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
                "WHERE ud.user_id = ? " +
                "ORDER BY meal_time DESC";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            returnList.add(mapRowToObject(rowSet));
        }
        return returnList;
    }

    @Override
    public Meal createUserMeal(int userId, Meal meal) throws SQLException {

        String sql ="INSERT INTO meals (carbs, food, glycemic_index, meal_time) VALUES (?, ?, ?, ?) RETURNING meal_id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, meal.getCarbs(), meal.getFood(),
                meal.getGlycemicIndex(), meal.getMealTime());
        meal.setMealId(id);

        if (createMealJoinEntry(id, userId)) {
            return meal;
        } else {
            throw new SQLException("Create meal error.");
        }
    }

    @Override
    public boolean updateUserMealData(int mealId, Meal meal) throws SQLException {

        String sql = "UPDATE meals SET carbs = ?, food = ?, glycemic_index = ?, meal_time = ? WHERE meal_id = ?;";

        jdbcTemplate.update(sql, meal.getCarbs(), meal.getFood(), meal.getGlycemicIndex(), meal.getMealTime());
        return true;
    }

    @Override
    public boolean deleteMealData(int userId, Meal meal) throws SQLException {

        if (createMealJoinEntry(meal.getMealId(), userId)) {
            String sql = "DELETE FROM meals WHERE meal_id = ?;";
            jdbcTemplate.update(sql, meal.getMealId());
            return true;
        } else {
            throw new SQLException("Delete meal failed.");
        }
    }

    @Override
    public Meal getMostRecentMeal(int userId) throws SQLException {

        String sql = "SELECT m.meal_id, carbs, food, glycemic_index, meal_time FROM meals m " +
                "JOIN meals_user_join mj ON mj.meal_id = m.meal_id " +
                "JOIN user_data ud ON ud.user_id = mj.user_id " +
                "WHERE ud.user_id = ? " +
                "ORDER BY meal_time DESC " +
                "LIMIT 1;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        if (rowSet.next()) {
            return mapRowToObject(rowSet);
        } else {
            throw new SQLException("Could not find meal");
        }

    }

    private boolean createMealJoinEntry(Integer mealId, int userId) {

        String sql = "INSERT INTO meals_user_join (meal_id, user_id) VALUES (?, ?) RETURNING meal_id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, mealId, userId);
        if (id > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean deleteMealFromJoinTable(int mealId, int userId) {
        String sql = "DELETE FROM meals_user_join WHERE meal_id = ? AND user_id = ?;";
        jdbcTemplate.update(sql, mealId, userId);
        return true;
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
