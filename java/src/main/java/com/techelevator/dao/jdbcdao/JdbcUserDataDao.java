package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.ModelClasses.Azure.BLOB;
import com.techelevator.model.ModelClasses.Azure.UserInfoObject;
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

    @Override
    public BLOB getFacilitatorBlob(int userId) throws SQLException {
        String sql = "SELECT dose_units, user_age, (weight/POWER(height/100, 2)) AS bmi, diabetes_type from user_data ud " +
                "JOIN dose_user_data_join dj ON ud.user_id = dj.user_id " +
                "JOIN dose d ON d.dose_id = dj.dose_id " +
                "WHERE ud.user_id = ? " +
                "ORDER BY time_of_dose DESC " +
                "LIMIT 1";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        if (rowSet.next()) {
            return mapRowToBLOB(rowSet);
        } else {
            throw new SQLException("CANT FUNCTIO SHUTTING DOQWN");
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

    private BLOB mapRowToBLOB(SqlRowSet rowSet) {
        BLOB blob = new BLOB();
        blob.setDoseUnits(rowSet.getInt("dose_units"));
        blob.setUserAge(rowSet.getInt("user_age"));
        blob.setBmi(rowSet.getDouble("bmi"));
        blob.setDiabetesType(rowSet.getInt("diabetes_type"));
        return blob;
    }

}



