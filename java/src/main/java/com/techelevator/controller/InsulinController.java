package com.techelevator.controller;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.model.ModelClasses.Insulin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class InsulinController {

    private InsulinDao insulinDao;
    private UserDao userDao;


    public InsulinController(InsulinDao insulinDao, UserDao userDao, BloodSugarDao bloodSugarDao) {
        this.insulinDao = insulinDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/insulin", method = RequestMethod.GET)
    public List<Insulin> getActiveInsulin(Principal principal) {
        try {
            if (insulinDao.getInsulinList(userDao.findIdByUsername(principal.getName())).size() == 0) {
                throw new ServersideOpException("No insulin associated with this account");
            } else {
                return insulinDao.getInsulinList(userDao.findIdByUsername(principal.getName()));
            }

        } catch (ServersideOpException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path="/dashboard/profile/base-insulin", method= RequestMethod.PUT)
    public void setBaseInsulin(Principal principal) {
        int userID = userDao.findIdByUsername(principal.getName());
        insulinDao.setBaseLevel(10, userID);
    }

    @RequestMapping(path="/dashboard/profile/base-insulin", method = RequestMethod.GET)
    public Insulin getInsulinTest() {
        return insulinDao.getInsulin();
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

