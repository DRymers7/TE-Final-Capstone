package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcInsulinDao;
import com.techelevator.model.ModelClasses.Insulin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

public class JDBCInsulinDAOTests extends BaseDaoTests {


    private static final Insulin insulin_1 = new Insulin(1, 10.0, 10.0, LocalDate.now());
    private JdbcInsulinDao dao;


    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        dao = new JdbcInsulinDao(jdbcTemplate);
    }

    @Test
    public void test_for_jdbc_base_insulin_update() {
        insulin_1.setBaseLevel(10);
        Assert.assertEquals(insulin_1.getBaseLevel(), 10, 0.009);
    }


}
