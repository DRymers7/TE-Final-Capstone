package com.techelevator.controller;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.model.ModelClasses.Insulin;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ProfileController {

    private InsulinDao insulinDao;
    private UserDao userDao;
    private BloodSugarDao bloodSugarDao;

    public ProfileController(InsulinDao insulinDao, UserDao userDao, BloodSugarDao bloodSugarDao) {
        this.insulinDao = insulinDao;
        this.userDao = userDao;
        this.bloodSugarDao = bloodSugarDao;
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

    @RequestMapping(path="/dashboard/profile/blood-sugar", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarData(Principal principal) {
        return bloodSugarDao.getBloodSugarInformation(userDao.findIdByUsername(principal.getName()));
    }

    //todo make helper pojo that only contains info we're updating
    @RequestMapping(path="/dashboard/profile/blood-sugar", method = RequestMethod.PUT)
    public void bloodSugarUpdate(@RequestBody int targetLow, @RequestBody int targetHigh, Principal principal) {
        bloodSugarDao.updateBloodSugar(targetLow, targetHigh, userDao.findIdByUsername(principal.getName()));
    }

    //todo write post request for blood_sugar endpoint


}

