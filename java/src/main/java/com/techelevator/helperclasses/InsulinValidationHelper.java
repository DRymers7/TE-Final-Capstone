package com.techelevator.helperclasses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.Insulin;

import java.time.LocalDateTime;

public class InsulinValidationHelper {

    private InsulinDao insulinDao;

    public InsulinValidationHelper(InsulinDao insulinDao) {
        this.insulinDao = insulinDao;
    }

    public boolean validateInsulin(BaseInsulin insulin) {
        return false;
    }

    private boolean populateInsulinNullValues(BaseInsulin insulin, int userId) {
        BaseInsulin baseInsulin = insulinDao.getSingleInsulin(insulin.getInsulinId(), userId, insulin);

        return false;
    }


}
