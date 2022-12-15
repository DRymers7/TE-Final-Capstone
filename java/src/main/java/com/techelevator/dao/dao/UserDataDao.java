package com.techelevator.dao.dao;
import com.techelevator.model.ModelClasses.Azure.BLOB;
import com.techelevator.model.ModelClasses.Image;
import com.techelevator.model.ModelClasses.UserData;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface UserDataDao {

    UserData getUserData(int userId) throws SQLException;

    String postProfilePicture(int userId, String imageData) throws SQLException;

    BLOB getFacilitatorBlob(int userId) throws SQLException;

    Image retrieveProfilePicture(int userId);

}
