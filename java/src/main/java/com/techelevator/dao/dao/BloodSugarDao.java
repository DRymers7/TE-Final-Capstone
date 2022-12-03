package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.BloodSugar;

import java.util.List;

public interface BloodSugarDao {

    List<BloodSugar> getBloodSugarInformation(int userId);
    void updateBloodSugar(int targetLow, int targetHigh, int userID);
}
