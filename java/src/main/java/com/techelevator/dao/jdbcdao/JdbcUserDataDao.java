package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.ModelClasses.UserData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JdbcUserDataDao implements UserDataDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserData getUserData(int userId) throws SQLException {

        String sql = "SELECT ud.user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level, emergency_contact_1, emergency_contact_2, profile_pic, u.username " +
                "FROM user_data ud " +
                "JOIN users u ON u.user_id = ud.user_id " +
                "WHERE ud.user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        if (rowSet.next()) {
            return mapRowToUserData(rowSet);
        } else {
            throw new SQLException("Could not find applicable user.");
        }
    }

    @Override
    public String postProfilePicture(int userId, byte[] imageData) throws SQLException {

        String sql = "UPDATE user_data SET profile_pic = ? " +
                     "WHERE user_id = ?";

       int success = jdbcTemplate.update(sql, imageData, userId);
       if (success == 1) {
          return imageData.toString();
       } else {
           throw new SQLException("update profile picture failed");
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
        userData.setProfilePic((byte[]) rowSet.getObject("profile_pic"));
        userData.setUsername(rowSet.getString("username"));

        return userData;
    }

}



