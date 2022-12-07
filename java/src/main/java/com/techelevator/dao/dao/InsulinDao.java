package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.BaseInsulin;

import java.sql.SQLException;
import java.util.List;

public interface InsulinDao {
    List<BaseInsulin> getInsulinList(int userId) throws SQLException;
    BaseInsulin createNewInsulin(int userId, BaseInsulin baseInsulin) throws SQLException;
    boolean updateInsulin(BaseInsulin baseInsulin) throws SQLException;
    boolean deleteInsulin(BaseInsulin baseInsulin, int userId) throws SQLException;
    List<String> insulinBrandNames();
    BaseInsulin getPrimaryInsulin(int userId) throws SQLException;
}
