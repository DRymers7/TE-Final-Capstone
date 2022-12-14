package com.techelevator.dao.dao;

import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BloodSugar;

import java.sql.SQLException;
import java.util.List;

public interface BloodSugarDao {

    List<BloodSugar> getBloodSugarReadingsTwoWeeks(int userId);

    List<BloodSugar> getBloodSugarReadingsOneWeek(int userId);

    List<BloodSugar> getBloodSugarReadingsThreeDays(int userId);

    List<BloodSugar> getBloodSugarReadingsOneDay(int userId);

    List<BloodSugar> getBloodSugarReadings(int userId);
    BloodSugar createBloodSugarReading(int userId, BloodSugar bloodSugar) throws SQLException;
    boolean updateBloodSugarReading(int bloodSugarId, BloodSugar bloodSugar) throws SQLException;
    boolean deleteBloodSugar(int userId, BloodSugar bloodSugar) throws SQLException;
    BloodSugar getMostRecentReading(int userId) throws NullPointerException;
    List <BloodSugar> getBloodSugarReadingsOneMonth (int userId);
    }
