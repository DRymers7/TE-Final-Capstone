package com.techelevator.controller;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.helperclasses.InsulinValidationHelper;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.model.ModelClasses.Insulin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class InsulinController {

    private InsulinDao insulinDao;
    private UserDao userDao;
    private InsulinValidationHelper insulinValidationHelper;


    public InsulinController(InsulinDao insulinDao, UserDao userDao)  {
        this.insulinDao = insulinDao;
        this.userDao = userDao;
        this.insulinValidationHelper = new InsulinValidationHelper(insulinDao);
    }

    @RequestMapping(path = "/insulin", method = RequestMethod.GET)
    public List<BaseInsulin> getActiveInsulin(Principal principal) {
        try {
            return insulinDao.getInsulinList(userDao.findIdByUsername(principal.getName()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/insulin", method = RequestMethod.POST)
    public BaseInsulin createNewInsulin(@RequestBody BaseInsulin baseInsulin, Principal principal) {

        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return insulinDao.createNewInsulin(userId, baseInsulin);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(path = "/insulin", method = RequestMethod.PUT)
    public boolean updateInsulinDetails(@RequestBody BaseInsulin baseInsulin, Principal principal) {
        try {
            if (insulinValidationHelper.validateInsulin(baseInsulin, userDao.findIdByUsername(principal.getName()))) {
                return insulinDao.updateInsulin(baseInsulin);
            } else {
                throw new ServersideOpException("Could not validate insulin.");
            }
        } catch (SQLException | ServersideOpException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/insulin", method = RequestMethod.DELETE)
    public boolean deleteInsulin(@RequestBody BaseInsulin baseInsulin) {
        try {
            return insulinDao.deleteInsulin(baseInsulin);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
    /*
    @RequestMapping(path="/dashboard/profile/blood-sugar", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarData(Principal principal) {
        return bloodSugarDao.getBloodSugarInformation(userDao.findIdByUsername(principal.getName()));
    }

    //todo make helper pojo that only contains info we're updating
    @RequestMapping(path="/dashboard/profile/blood-sugar", method = RequestMethod.PUT)
    public void bloodSugarUpdate(@RequestBody int targetLow, @RequestBody int targetHigh, Principal principal) {
        bloodSugarDao.updateBloodSugar(targetLow, targetHigh, userDao.findIdByUsername(principal.getName()));
    }

     */

    //todo write post request for blood_sugar endpoint


}

