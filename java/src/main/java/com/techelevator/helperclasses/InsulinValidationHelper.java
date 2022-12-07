package com.techelevator.helperclasses;

import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BaseInsulin;

import java.sql.SQLException;
import java.util.List;

public class InsulinValidationHelper {

    private InsulinDao insulinDao;

    public InsulinValidationHelper(InsulinDao insulinDao) {
        this.insulinDao = insulinDao;
    }

    public boolean validateInsulinUpdate(BaseInsulin insulin, int userId) throws SQLException {
        List<BaseInsulin> insulinList = insulinDao.getInsulinList(userId);
        insulinList.removeIf(item -> (item.getInsulinId() != insulin.getInsulinId()));
        return populateResultingObject(cleanAndPrepareForPopulation(insulinList), insulin);
    }

    private BaseInsulin cleanAndPrepareForPopulation(List<BaseInsulin> list) throws SQLException {
        if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new SQLException("Too many insulin objects returned.");
        }
    }

    private boolean populateResultingObject(BaseInsulin insulinFromRecords, BaseInsulin insulinToUpdate) throws SQLException {
        if (insulinFromRecords.equals(insulinToUpdate)) {
            return true;
        } else {
            if (insulinToUpdate.getBaseLevel() == 0) {
                insulinToUpdate.setBaseLevel(insulinFromRecords.getBaseLevel());
            }
            if (insulinToUpdate.getAverageLevel() == 0) {
                insulinToUpdate.setAverageLevel(insulinFromRecords.getAverageLevel());
            }
            if (insulinToUpdate.getTimeSinceLastDose().equals(null) || insulinToUpdate.getTimeSinceLastDose().equals("")) {
                System.out.println("AAAA");
                insulinToUpdate.setTimeSinceLastDose(insulinFromRecords.getTimeSinceLastDose());
            }
            cleanPotentiallyNullStringValues(insulinFromRecords, insulinToUpdate);
            insulinDao.updateInsulin(insulinToUpdate);
            return true;
        }
    }

    private void cleanPotentiallyNullStringValues(BaseInsulin insulinFromRecords, BaseInsulin insulinToUpdate) {
        if (insulinToUpdate.getInsulinBrandName() == null || insulinToUpdate.getInsulinBrandName().equals("")) {
            insulinToUpdate.setInsulinBrandName(insulinFromRecords.getInsulinBrandName());
        }
        if (insulinToUpdate.getInsulinStrength() == null || insulinToUpdate.getInsulinStrength().equals("")) {
            insulinToUpdate.setInsulinStrength(insulinFromRecords.getInsulinStrength());
        }
        if (insulinToUpdate.getInsulinRatio() == 0) {
            insulinToUpdate.setInsulinRatio(insulinFromRecords.getInsulinRatio());
        }
    }


}
