<<<<<<< HEAD
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
=======
package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.ModelClasses.UserData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDataDao implements UserDataDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserData getUserData(int userId) throws SQLException {

        String sql = "SELECT user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level, emergency_contact_1, emergency_contact_2 " +
                "FROM user_data;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        if (rowSet.next()) {
            return mapRowToUserData(rowSet);
        } else {
            throw new SQLException("Could not find applicable user.");
        }

    }

    private UserData mapRowToUserData(SqlRowSet rowSet) {
        UserData userData = new UserData();
        userData.setUserId(rowSet.getInt("user_id"));
        userData.setA1c(rowSet.getDouble("a1c"));
        userData.setFastingGlucose(rowSet.getInt("fasting_glucose"));
        userData.setUserAge(rowSet.getInt("user_age"));
        userData.setLastUpdated(rowSet.getTimestamp("last_updated"));
        userData.setWeight(rowSet.getInt("weight"));
        userData.setHeight(rowSet.getInt("height"));
        userData.setActivityLevel(rowSet.getString("activity_level"));
        userData.setEmergencyContact1(rowSet.getString("emergency_contact_1"));
        userData.setEmergencyContact2(rowSet.getString("emergency_contact_2"));
        return userData;
    }

}
>>>>>>> 9fea58df152620235fea24ea0405fa6d8ccb0276
