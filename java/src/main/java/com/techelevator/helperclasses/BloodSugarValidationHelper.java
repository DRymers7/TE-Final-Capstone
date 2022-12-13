package com.techelevator.helperclasses;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.BloodSugar;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BloodSugarValidationHelper {

    private BloodSugarDao bloodSugarDao;

    public BloodSugarValidationHelper(BloodSugarDao bloodSugarDao) {
        this.bloodSugarDao = bloodSugarDao;
    }

    public boolean validateBloodSugarUpdate(BloodSugar bloodSugar, int userId) throws SQLException {
        List<BloodSugar> bloodSugarList = bloodSugarDao.getBloodSugarReadings(userId);
        bloodSugarList.removeIf(item -> (item.getBloodSugarId() != bloodSugar.getBloodSugarId()));
        return populateResultingObject(cleanAndPrepareForPopulation(bloodSugarList), bloodSugar);
    }

    public BloodSugar patchNewBloodSugar(BloodSugar bloodSugar, int userId) {
        List<BloodSugar> mostRecentList = bloodSugarDao.getBloodSugarReadings(userId);
        BloodSugar mostRecent = findBestChoice(mostRecentList);
        if (bloodSugar.getTargetLow() == 0) {
            bloodSugar.setTargetLow(mostRecent.getTargetLow());
        }
        if (bloodSugar.getTargetHigh() == 0) {
            bloodSugar.setTargetHigh(mostRecent.getTargetHigh());
        }
        if (bloodSugar.getLastMeasurement() == null) {
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp toset = Timestamp.valueOf(formatter.format(ts));
            bloodSugar.setLastMeasurement(toset);
        }
        return bloodSugar;
    }

    private BloodSugar findBestChoice(List<BloodSugar> list) {
        BloodSugar bestChoice = null;
        for (BloodSugar bloodSugar : list) {
            if (bloodSugar.getTargetLow() != 0 && bloodSugar.getTargetHigh() != 0) {
                bestChoice = bloodSugar;
            }
        }
        return bestChoice;
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
            if (bloodSugarToUpdate.getLastMeasurement()==null || bloodSugarToUpdate.getLastMeasurement().equals("")) {
                System.out.println("AAAA");
                bloodSugarToUpdate.setLastMeasurement(new Timestamp(System.currentTimeMillis()));
            }
            bloodSugarDao.updateBloodSugarReading(bloodSugarToUpdate.getBloodSugarId(), bloodSugarToUpdate);
            return true;
        }

//            cleanPotentiallyNullStringValues(bloodSugarFromRecords, bloodSugarToUpdate);
//            bloodSugarDao.updateBloodSugarReading(bloodSugarToUpdate.getBloodSugarId(), bloodSugarToUpdate);
//            return true;
    }


}
