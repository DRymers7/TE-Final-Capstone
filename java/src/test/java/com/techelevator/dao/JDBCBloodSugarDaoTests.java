package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcBloodSugarDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BloodSugar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class JDBCBloodSugarDaoTests extends BaseDaoTests {

    private static final BloodSugar BLOOD_SUGAR_1 = new BloodSugar(4, 10, 10, 10, Timestamp.valueOf("2022/12/12"));

    private JdbcBloodSugarDao dao;

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        dao = new JdbcBloodSugarDao(jdbcTemplate);
    }

    @Test
    public void get_blood_sugar_readings_test() {
        List<BloodSugar> exampleList = dao.getBloodSugarReadings(1);
        Assert.assertEquals(3, exampleList.size());
    }

    @Test
    public void create_new_blood_sugar_reading_test() throws SQLException {
        BloodSugar bloodSugar = dao.createBloodSugarReading(1, BLOOD_SUGAR_1);
        int newId = bloodSugar.getBloodSugarId();
        BLOOD_SUGAR_1.setBloodSugarId(newId);
        Assert.assertEquals(bloodSugar.getBloodSugarId(), BLOOD_SUGAR_1.getBloodSugarId());
    }

    @Test
    public void update_blood_sugar_test() throws SQLException {
        BloodSugar bloodSugar = dao.createBloodSugarReading(1, BLOOD_SUGAR_1);
        BloodSugar bloodSugar1 = new BloodSugar(1, 10, 10, 10, Timestamp.valueOf("2022/12/12"));
        Assert.assertTrue(dao.updateBloodSugarReading(bloodSugar1.getBloodSugarId(), bloodSugar1));
    }

    @Test
    public void delete_blood_sugar_test() throws SQLException {
        BloodSugar bloodSugar = dao.createBloodSugarReading(1, BLOOD_SUGAR_1);
        Assert.assertTrue(dao.deleteBloodSugar(1, BLOOD_SUGAR_1));
    }


}
