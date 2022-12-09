package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.History;

import java.sql.SQLException;
import java.util.List;

public interface HistoryDao {
    List<History> getHistoryForOneMonth(int userId) throws SQLException;

    List<History> getHistoryForTwoWeeks(int userId) throws SQLException;

    List<History> getHistoryForOneWeek(int userId) throws SQLException;

    List<History> getHistoryForThreeDays(int userId) throws SQLException;

    List<History> getHistoryForOneDay(int userId) throws SQLException;
}
