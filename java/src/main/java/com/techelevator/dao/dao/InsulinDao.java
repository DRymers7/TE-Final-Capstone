package com.techelevator.dao.dao;

import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.Insulin;

import java.util.List;

public interface InsulinDao {
    public List<Insulin> getInsulinList(int userId);
    BaseInsulin createNewInsulin(int userId, BaseInsulin baseInsulin) throws ServersideOpException;
    boolean updateInsulin(BaseInsulin baseInsulin) throws ServersideOpException;
    boolean deleteInsulin(BaseInsulin baseInsulin) throws ServersideOpException;
    Insulin getSingleInsulin(int insulinId, int userId, BaseInsulin insulin);

    void setBaseLevel(double baseLevel, int userId);

    Insulin getInsulin();
}
