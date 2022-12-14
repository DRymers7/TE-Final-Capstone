package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcUserDataDao;
import com.techelevator.model.ModelClasses.UserData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class JdbcUserDataTest extends BaseDaoTests{

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
