package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcMealDao;
import com.techelevator.model.ModelClasses.Meal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class JDBCMealDaoTests extends BaseDaoTests {

    private JdbcMealDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcMealDao(jdbcTemplate);
    }

    @Test
    public void get_all_meals_test() throws SQLException {
        List<Meal> mealList = dao.getUserMeals(1);
        Assert.assertEquals(3, mealList.size());
    }

    @Test
    public void get_recent_meal_test() throws SQLException {
        Meal returnValue = dao.getMostRecentMeal(1);
        Assert.assertEquals(52, returnValue.getCarbs());
    }



}
