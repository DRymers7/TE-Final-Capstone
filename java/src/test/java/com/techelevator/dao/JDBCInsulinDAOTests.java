package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcInsulinDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.Insulin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class JDBCInsulinDAOTests extends BaseDaoTests {


    private static final Insulin INSULIN_1 = new Insulin(4, 10.5, 10.5, LocalDateTime.now(), "Test type", "Test strength", 10, 10, 10, 0.50, 100);
    private static final Insulin INSULIN_2 = new Insulin(5, 10.5, 10.5, LocalDateTime.now(), "Test type2", "Test strength2", 10, 10, 10, 0.50, 100);
    private static final Insulin INSULIN_3 = new Insulin(6, 10.5, 10.5, LocalDateTime.now(), "Test type3", "Test strength3", 10, 10, 10, 0.50, 100);
    private static final BaseInsulin BASE_INSULIN_1 = new BaseInsulin(3, 10.0, 10.0, LocalDateTime.now(), "test", "test", 0.40);

    private JdbcInsulinDao dao;


    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        dao = new JdbcInsulinDao(jdbcTemplate);
    }

    @Test
    public void get_all_insulin_test() {
        List<Insulin> exampleList = dao.getInsulinList(1);
        Assert.assertEquals("Wrong list size", 2, exampleList.size());
    }

    @Test
    public void create_new_insulin_entry_test() throws ServersideOpException {
        BaseInsulin insulin = dao.createNewInsulin(1, BASE_INSULIN_1);
        int newId = insulin.getInsulinId();
        INSULIN_1.setInsulinId(newId);
        Assert.assertEquals(insulin.getInsulinId(), INSULIN_1.getInsulinId());
    }




}
