package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcBloodSugarDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BloodSugar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class JDBCBloodSugarDaoTests extends BaseDaoTests {

    private static final BloodSugar BLOOD_SUGAR_1 = new BloodSugar(4, 10, 10, 10, LocalDateTime.now());

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



}
