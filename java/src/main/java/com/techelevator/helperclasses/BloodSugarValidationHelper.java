package com.techelevator.helperclasses;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.BloodSugar;

import java.sql.SQLException;
import java.util.List;

public class BloodSugarValidationHelper {

    private BloodSugarDao bloodSugarDao;

    public BloodSugarValidationHelper(BloodSugarDao bloodSugarDao) {
        this.bloodSugarDao = bloodSugarDao;
    }

    public boolean validateBloodSugarUpdate(BloodSugar bloodSugar, int blood_sugar_Id) throws SQLException {
        List<BloodSugar> bloodSugarList = bloodSugarDao.getBloodSugarReadings(blood_sugar_Id);
        bloodSugarList.removeIf(item -> (item.getBloodSugarId() != bloodSugar.getBloodSugarId()));
        return populateResultingObject(cleanAndPrepareForPopulation(bloodSugarList), bloodSugar);
    }

    private BloodSugar cleanAndPrepareForPopulation(List<BloodSugar> list) throws SQLException {
        if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new SQLException("Too many blood sugar objects returned.");
        }
    }

    private boolean populateResultingObject(BloodSugar bloodSugarFromRecords, BloodSugar bloodSugarToUpdate) throws SQLException {
        if (bloodSugarFromRecords.equals(bloodSugarToUpdate)) {
            return true;
        } else {
            if (bloodSugarToUpdate.getTargetHigh() == 0) {
                bloodSugarToUpdate.setTargetHigh(bloodSugarFromRecords.getTargetHigh());
            }
            if (bloodSugarToUpdate.getTargetLow() == 0) {
                bloodSugarToUpdate.setTargetLow(bloodSugarFromRecords.getTargetHigh());
            }
            if (bloodSugarToUpdate.getInputLevel() == 0) {
                bloodSugarToUpdate.setInputLevel(bloodSugarFromRecords.getInputLevel());
            }
        }
        if (bloodSugarToUpdate.getLastMeasurement().equals(null) || bloodSugarToUpdate.getLastMeasurement().equals("")) {
            System.out.println("AAAA");
            bloodSugarToUpdate.setLastMeasurement(bloodSugarFromRecords.getLastMeasurement());
        }
//            cleanPotentiallyNullStringValues(bloodSugarFromRecords, bloodSugarToUpdate);
//            bloodSugarDao.updateBloodSugarReading(bloodSugarToUpdate.getBloodSugarId(), bloodSugarToUpdate);
//            return true;
        return true;
    }


}
