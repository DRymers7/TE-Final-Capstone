package com.techelevator.dao.dao;

import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.Insulin;

import java.sql.SQLException;
import java.util.List;

public interface InsulinDao {
    List<BaseInsulin> getInsulinList(int userId) throws SQLException;
    BaseInsulin createNewInsulin(int userId, BaseInsulin baseInsulin) throws SQLException;
    boolean updateInsulin(BaseInsulin baseInsulin) throws SQLException;
    boolean deleteInsulin(BaseInsulin baseInsulin) throws SQLException;
    BaseInsulin getSingleInsulin(int insulinId, int userId, BaseInsulin insulin) throws SQLException;
}
