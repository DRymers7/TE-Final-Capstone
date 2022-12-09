package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.History;

import java.util.List;

public interface HistoryDao {
    List<History> getHistoryForOneDay(int userId);
}
