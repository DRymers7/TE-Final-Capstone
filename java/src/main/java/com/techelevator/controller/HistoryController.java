package com.techelevator.controller;

import com.techelevator.dao.dao.*;
import com.techelevator.helperclasses.InsulinCalculator;
import com.techelevator.model.ModelClasses.History;
import com.techelevator.model.ModelClasses.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class HistoryController {

    private MealDao mealDao;
    private UserDataDao userDataDao;
    private BloodSugarDao bloodSugarDao;
    private InsulinDao insulinDao;
    private UserDao userDao;
    private InsulinCalculator insulinCalculator;
    private DoseDao doseDao;
    private HistoryDao historyDao;

    public HistoryController(MealDao mealDao, UserDataDao userDataDao, InsulinDao insulinDao, BloodSugarDao bloodSugarDao, UserDao userDao, DoseDao doseDao) {
        this.mealDao = mealDao;
        this.userDataDao = userDataDao;
        this.bloodSugarDao = bloodSugarDao;
        this.userDao = userDao;
        this.insulinCalculator = new InsulinCalculator(insulinDao, mealDao, bloodSugarDao, userDataDao);
        this.doseDao = doseDao;
        this.historyDao = historyDao;
        this.insulinDao = insulinDao;
    }

    @RequestMapping(path = "/average/one-month", method = RequestMethod.GET)
    public List<History> getHistoryForOneMonth(Principal principal) {

        try {
            List<History> histories = historyDao.getHistoryForOneMonth(userDao.findIdByUsername(principal.getName()));
            return histories;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/average/two-weeks", method = RequestMethod.GET)
    public List<History> getHistoryForTwoWeeks(Principal principal) {

        try {
            List<History> histories = historyDao.getHistoryForTwoWeeks(userDao.findIdByUsername(principal.getName()));
            return histories;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/average/one-week", method = RequestMethod.GET)
    public List<History> getHistoryForOneWeek(Principal principal) {

        try {
            List<History> histories = historyDao.getHistoryForOneWeek(userDao.findIdByUsername(principal.getName()));
            return histories;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/average/three-days", method = RequestMethod.GET)
    public List<History> getHistoryForThreeDays(Principal principal) {

        try {
            List<History> histories = historyDao.getHistoryForThreeDays(userDao.findIdByUsername(principal.getName()));
            return histories;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/average/one-day", method = RequestMethod.GET)
    public List<History> getHistoryForOneDay(Principal principal) {

        try {
            List<History> histories = historyDao.getHistoryForOneDay(userDao.findIdByUsername(principal.getName()));
            return histories;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
