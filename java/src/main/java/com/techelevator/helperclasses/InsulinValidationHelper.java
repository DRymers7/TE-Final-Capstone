package com.techelevator.helperclasses;

import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BaseInsulin;

import java.sql.SQLException;

public class InsulinValidationHelper {

    private InsulinDao insulinDao;

    public InsulinValidationHelper(InsulinDao insulinDao) {
        this.insulinDao = insulinDao;
    }

    public boolean validateInsulin(BaseInsulin insulin, int userId) throws SQLException, ServersideOpException {
        return populateInsulinNullValues(insulin, userId);
    }

    private boolean populateInsulinNullValues(BaseInsulin insulin, int userId) throws SQLException, ServersideOpException {
        try {
            BaseInsulin baseInsulin = insulinDao.getSingleInsulin(insulin.getInsulinId(), userId, insulin);
            BaseInsulin completedObject = setMissingValues(insulin, baseInsulin);
            insulinDao.updateInsulin(completedObject);
            return true;
        } catch (SQLException e) {
            throw new ServersideOpException("Could not populate correctly.");
        }
    }

    private BaseInsulin setMissingValues(BaseInsulin insulin, BaseInsulin baseInsulin) {
        if (insulin.getInsulinId() == 0) {
            insulin.setInsulinId(baseInsulin.getInsulinId());
        }
        if (insulin.getBaseLevel() == 0) {
            insulin.setBaseLevel(baseInsulin.getBaseLevel());
        }
        if (insulin.getAverageLevel() == 0) {
            insulin.setAverageLevel(baseInsulin.getAverageLevel());
        }
        if (insulin.getTimeSinceLastDose() == null) {
            insulin.setTimeSinceLastDose(baseInsulin.getTimeSinceLastDose());
        }
        if (insulin.getInsulinType() == null) {
            insulin.setInsulinType(baseInsulin.getInsulinType());
        }
        if (insulin.getInsulinStrength() == null) {
            insulin.setInsulinStrength(baseInsulin.getInsulinStrength());
        }
        if (insulin.getInsulinRation() == 0) {
            insulin.setInsulinRation(baseInsulin.getInsulinRation());
        }
        return insulin;
    }


}
