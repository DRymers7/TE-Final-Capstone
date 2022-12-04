package com.techelevator.dao.dao;

import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.Insulin;

import java.util.List;

public interface InsulinDao {
    public List<Insulin> getInsulinList(int userId);

    Insulin createNewInsulin(int userId, Insulin insulin) throws ServersideOpException;

    void setBaseLevel(double baseLevel, int userId);

    Insulin getInsulin();
}
