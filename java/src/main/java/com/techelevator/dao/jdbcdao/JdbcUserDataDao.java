package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.ModelClasses.UserData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcUserDataDao implements UserDataDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserData> getUserData(int userId) {

        List<UserData> returnList = new ArrayList<>();

        String sql = "";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            returnList.add(mapRowToObject(rowSet));
        }
        return returnList;
    }

    private UserData mapRowToObject(SqlRowSet rowSet) {
        UserData user = new UserData();

        return user;
    }

}
