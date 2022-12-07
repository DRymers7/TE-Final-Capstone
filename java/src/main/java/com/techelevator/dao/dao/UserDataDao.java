package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.UserData;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface UserDataDao {

    UserData getUserData(int userId) throws SQLException;
    boolean updateUserData(int userId) throws SQLException;

}
