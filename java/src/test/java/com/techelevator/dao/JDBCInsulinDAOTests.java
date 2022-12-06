package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcInsulinDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.Insulin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class JDBCInsulinDAOTests extends BaseDaoTests {


    private static final Insulin INSULIN_1 = new Insulin(4, 10.5, 10.5, Timestamp.valueOf("2022-12-12 00:00:00"), "Test type", "Test strength", 10, 10, 10, 0.50, 100);
    private static final Insulin INSULIN_2 = new Insulin(5, 10.5, 10.5, Timestamp.valueOf("2023-10-10 00:00:00"), "Test type2", "Test strength2", 10, 10, 10, 0.50, 100);
    private static final Insulin INSULIN_3 = new Insulin(6, 10.5, 10.5, Timestamp.valueOf("2321-12-31 00:00:00"), "Test type3", "Test strength3", 10, 10, 10, 0.50, 100);
    private static final BaseInsulin BASE_INSULIN_1 = new BaseInsulin(3, 10.0, 10.0, Timestamp.valueOf("2022-12-11 00:00:00"), "test", "test", 0.40);

    private JdbcInsulinDao dao;


    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        dao = new JdbcInsulinDao(jdbcTemplate);
    }

    @Test
    public void get_all_insulin_test() throws SQLException {
        List<Insulin> exampleList = dao.getInsulinList(1);
        Assert.assertEquals("Wrong list size", 2, exampleList.size());
    }

    @Test
    public void create_new_insulin_entry_test() throws SQLException {
        BaseInsulin insulin = dao.createNewInsulin(1, BASE_INSULIN_1);
        int newId = insulin.getInsulinId();
        INSULIN_1.setInsulinId(newId);
        Assert.assertEquals(insulin.getInsulinId(), INSULIN_1.getInsulinId());
    }

    @Test
    public void update_insulin_test() throws SQLException {
        dao.createNewInsulin(1, BASE_INSULIN_1);
        BaseInsulin insulin = new BaseInsulin(3, 11.0, 11.0,Timestamp.valueOf("2022-2-14 00:00:00"), "test1", "test1", 0.41);
        Assert.assertTrue(dao.updateInsulin(insulin));
    }

    @Test
    public void delete_insulin_test() throws SQLException {
        BaseInsulin baseInsulin = dao.createNewInsulin(1, BASE_INSULIN_1);
        Assert.assertTrue(dao.deleteInsulin(baseInsulin));
    }

}
