package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcInsulinDao;
import com.techelevator.helperclasses.InsulinValidationHelper;
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

    private static final BaseInsulin BASE_INSULIN_1 = new BaseInsulin(3, 10.0, 10.0, Timestamp.valueOf("2022-12-11 00:00:00"), "Admelog", "Test Str", 0.40);
    private static final BaseInsulin BASE_INSULIN_2 = new BaseInsulin(3, 10.0, 0, Timestamp.valueOf("2022-12-11 00:00:00"), null, "test", 0);

    private JdbcInsulinDao dao;
    private InsulinValidationHelper insulinValidationHelper;


    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        dao = new JdbcInsulinDao(jdbcTemplate);
        insulinValidationHelper = new InsulinValidationHelper(dao);
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
        BaseInsulin insulin = dao.getInsulinList(1).get(0);
        int newId = insulin.getInsulinId();
        BASE_INSULIN_1.setInsulinId(newId);
        Assert.assertEquals(insulin.getInsulinId(), BASE_INSULIN_1.getInsulinId());
    }

    @Test
    public void update_insulin_test() throws SQLException {
        BaseInsulin insulin = dao.getInsulinList(1).get(0);
        insulin.setInsulinStrength("");
        insulin.setBaseLevel(0);
        insulin.setAverageLevel(99);
        Assert.assertTrue(dao.updateInsulin(insulin));
    }

    @Test
    public void update_insulin_validation_test() throws SQLException {
        BaseInsulin insulin = dao.getInsulinList(1).get(0);
        insulin.setInsulinStrength("");
        insulin.setBaseLevel(0);
        insulin.setAverageLevel(99);
        Assert.assertTrue(insulinValidationHelper.validateInsulinUpdate(insulin, 1));
    }

    @Test
    public void delete_insulin_test() throws SQLException {
        BaseInsulin baseInsulin = dao.getInsulinList(1).get(0);
        Assert.assertTrue(dao.deleteInsulin(baseInsulin, 1));
    }

    @Test
    public void get_brand_names_test() {
        List<String> brandNames = dao.insulinBrandNames();
        Assert.assertEquals(14, brandNames.size());
    }

}
