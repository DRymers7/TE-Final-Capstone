package com.techelevator.controller;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BloodSugar;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class BloodSugarController {

    private BloodSugarDao bloodSugarDao;
    private UserDao userDao;

    public BloodSugarController(BloodSugarDao bloodSugarDao, UserDao userDao) {
        this.bloodSugarDao = bloodSugarDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/blood-sugars", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarReadings(Principal principal) {

        try {
            List<BloodSugar> bloodSugarReadings = bloodSugarDao.getBloodSugarReadings(userDao.findIdByUsername(principal.getName()));
            if (bloodSugarReadings.size() == 0) {
                throw new ServersideOpException("No readings available");
            } else {
                return bloodSugarReadings;
            }
        } catch (ServersideOpException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/blood-sugars", method = RequestMethod.POST)
    public BloodSugar createNewBloodSugarReading(@RequestBody BloodSugar bloodSugar, Principal principal) {

        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return bloodSugarDao.createBloodSugarReading(userId, bloodSugar);

        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
