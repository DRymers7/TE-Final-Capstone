package com.techelevator.dao.dao;

import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BloodSugar;

import java.sql.SQLException;
import java.util.List;

public interface BloodSugarDao {

    List<BloodSugar> getBloodSugarReadings(int userId);
    BloodSugar createBloodSugarReading(int userId, BloodSugar bloodSugar) throws SQLException;
    void updateBloodSugar(int targetLow, int targetHigh, int userID);
}
