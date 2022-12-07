package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcInsulinDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.InsulinInformation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class JDBCInsulinDAOTests extends BaseDaoTests {

    private static final BaseInsulin BASE_INSULIN_1 = new BaseInsulin(3, 10.0, 10.0, Timestamp.valueOf("2022-12-11 00:00:00"), "test", "test", 0.40);
    private static final BaseInsulin BASE_INSULIN_2 = new BaseInsulin(3, 10.0, 0, Timestamp.valueOf("2022-12-11 00:00:00"), null, "test", 0);

    private JdbcInsulinDao dao;


    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        dao = new JdbcInsulinDao(jdbcTemplate);
    }

    @Test
    public void get_all_insulin_test() throws SQLException {
        List<BaseInsulin> exampleList = dao.getInsulinList(1);
        BaseInsulin item1 = exampleList.get(0);
        BaseInsulin item2 = exampleList.get(1);
        Assert.assertEquals("Wrong list size", 2, exampleList.size());
        Assert.assertEquals(item1.getInsulinId(), 1);
        Assert.assertEquals(item2.getInsulinId(), 2);
    }

    @Test
    public void create_new_insulin_entry_test() throws SQLException {
        BaseInsulin insulin = dao.createNewInsulin(1, BASE_INSULIN_1);
        int newId = insulin.getInsulinId();
        // INSULIN_1.setInsulinId(newId);
        // Assert.assertEquals(insulin.getInsulinId(), INSULIN_1.getInsulinId());
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
