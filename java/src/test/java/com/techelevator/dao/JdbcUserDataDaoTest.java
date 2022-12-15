package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcUserDataDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.UserData;
import com.techelevator.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.sql.Timestamp;

public class JdbcUserDataDaoTest extends BaseDaoTests{

//  byte[] byteArray = (byte);
//  private static final UserData USER_DATA_1 = new UserData(1, 7.50, 99, 1, 47, Timestamp.valueOf("2022/12/12"), 120, 500, "Active", "614-633-9073", "614-419-3583", "Froggie", );

    private JdbcUserDataDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcUserDataDao(jdbcTemplate);
    }

    @Test
    public void get_user_data() throws SQLException {
        UserData userData = dao.getUserData(1);




    }
}
