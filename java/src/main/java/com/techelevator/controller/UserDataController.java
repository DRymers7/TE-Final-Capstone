package com.techelevator.controller;

import com.techelevator.dao.dao.UserDao;
import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.model.ModelClasses.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;

@RestController
@CrossOrigin
public class UserDataController {

    private UserDataDao userDataDao;
    private UserDao userDao;

    public UserDataController(UserDataDao userDataDao, UserDao userDao) {
        this.userDataDao = userDataDao;
        this.userDao = userDao;
    }

    @GetMapping("/userdata")
    public UserData getUserData(Principal principal) {
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return userDataDao.getUserData(userId);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/userdata", method = RequestMethod.POST)
    public String postProfileImage(@RequestBody UserData userData, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return userData.getProfilePic(userId);
    }
}
