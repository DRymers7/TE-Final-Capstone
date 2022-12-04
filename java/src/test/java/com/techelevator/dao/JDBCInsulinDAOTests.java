package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcInsulinDao;
import com.techelevator.model.ModelClasses.Insulin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

public class JDBCInsulinDAOTests extends BaseDaoTests {


    private static final Insulin insulin_test = new Insulin(1, 50.500, 50.500, LocalDate.of(2022, 12, 12));
    private JdbcInsulinDao dao;


    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        dao = new JdbcInsulinDao(jdbcTemplate);
    }

    @Test
    public void test_for_jdbc_base_insulin_update() {
        Assert.assertEquals(insulin_test, dao.getInsulin());
    }


}
