package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.Insulin;

public interface InsulinDao {

    void setBaseLevel(double baseLevel, int userId);

    Insulin getInsulin();
}
