package com.techelevator.controller;

import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.helperclasses.InsulinCalculator;
import com.techelevator.helperclasses.InsulinValidationHelper;
import com.techelevator.model.ModelClasses.BaseInsulin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
            if (insulinValidationHelper.validateInsulinUpdate(baseInsulin, userDao.findIdByUsername(principal.getName()))) {
                return true;
            } else {
                throw new ServersideOpException("Could not validate insulin.");
            }
        } catch (SQLException | ServersideOpException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/insulin", method = RequestMethod.DELETE)
    public boolean deleteInsulin(@RequestBody BaseInsulin baseInsulin, Principal principal) {
        try {
            return insulinDao.deleteInsulin(baseInsulin, userDao.findIdByUsername(principal.getName()));
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/insulin-info", method = RequestMethod.GET)
    public List<String> insulinBrandNames() {
        return insulinDao.insulinBrandNames();
    }

}

