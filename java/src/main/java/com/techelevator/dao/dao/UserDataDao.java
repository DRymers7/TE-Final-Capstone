package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.UserData;

import java.util.List;

public interface UserDataDao {

    public List<UserData> getUserData(int userId);

}
