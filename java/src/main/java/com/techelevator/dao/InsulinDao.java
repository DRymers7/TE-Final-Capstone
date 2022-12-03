package com.techelevator.dao;

import com.techelevator.model.Insulin;

public interface InsulinDao {

    void setBaseLevel(double baseLevel, int userId);

    Insulin getInsulin();
}
