package com.techelevator.controller;

import com.techelevator.dao.InsulinDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Insulin;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class ProfileController {

    private InsulinDao insulinDao;
    private UserDao userDao;

    public ProfileController(InsulinDao insulinDao, UserDao userDao) {
        this.insulinDao = insulinDao;
        this.userDao = userDao;

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


}
