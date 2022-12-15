package com.techelevator.controller;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.dao.DoseDao;
import com.techelevator.dao.dao.UserDao;
import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.helperclasses.BloodSugarValidationHelper;
import com.techelevator.model.ModelClasses.Azure.BLOB;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.services.MLModelHelper;
import org.springframework.http.HttpStatus;
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
    private BloodSugarValidationHelper bloodSugarValidationHelper;
    private MLModelHelper mlModelHelper = new MLModelHelper();
    private UserDataDao userDataDao;

    public BloodSugarController(BloodSugarDao bloodSugarDao, UserDao userDao, UserDataDao userDataDao) {
        this.bloodSugarDao = bloodSugarDao;
        this.userDao = userDao;
        this.bloodSugarValidationHelper = new BloodSugarValidationHelper(bloodSugarDao);
        this.userDataDao = userDataDao;
    }

    @RequestMapping(path = "/predictions", method = RequestMethod.GET)
    public double getBloodSugarPrediction(Principal principal) {
        try {
            BLOB blob = userDataDao.getFacilitatorBlob(userDao.findIdByUsername(principal.getName()));
            return mlModelHelper.returnUserBloodSugarPredictionFromAzure(blob);
        } catch (SQLException | ServersideOpException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/blood-sugars/one-month", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarReadingsOneMonth(Principal principal) {

        try {
            List<BloodSugar> bloodSugarReadings = bloodSugarDao.getBloodSugarReadingsOneMonth(userDao.findIdByUsername(principal.getName()));
            if (bloodSugarReadings.size() == 0) {
                throw new ServersideOpException("No readings available");
            } else {
                return bloodSugarReadings;
            }
        } catch (ServersideOpException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/blood-sugars/two-weeks", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarReadingsTwoWeeks(Principal principal) {

        try {
            List<BloodSugar> bloodSugarReadings = bloodSugarDao.getBloodSugarReadingsTwoWeeks(userDao.findIdByUsername(principal.getName()));
            if (bloodSugarReadings.size() == 0) {
                throw new ServersideOpException("No readings available");
            } else {
                return bloodSugarReadings;
            }
        } catch (ServersideOpException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/blood-sugars/one-week", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarReadingsOneWeek(Principal principal) {

        try {
            List<BloodSugar> bloodSugarReadings = bloodSugarDao.getBloodSugarReadingsOneWeek(userDao.findIdByUsername(principal.getName()));
            if (bloodSugarReadings.size() == 0) {
                throw new ServersideOpException("No readings available");
            } else {
                return bloodSugarReadings;
            }
        } catch (ServersideOpException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/blood-sugars/three-days", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarReadingsThreeDays(Principal principal) {

        try {
            List<BloodSugar> bloodSugarReadings = bloodSugarDao.getBloodSugarReadingsThreeDays(userDao.findIdByUsername(principal.getName()));
            if (bloodSugarReadings.size() == 0) {
                throw new ServersideOpException("No readings available");
            } else {
                return bloodSugarReadings;
            }
        } catch (ServersideOpException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/blood-sugars/one-day", method = RequestMethod.GET)
    public List<BloodSugar> getBloodSugarReadingsOneDay(Principal principal) {

        try {
            List<BloodSugar> bloodSugarReadings = bloodSugarDao.getBloodSugarReadingsOneDay(userDao.findIdByUsername(principal.getName()));
            if (bloodSugarReadings.size() == 0) {
                throw new ServersideOpException("No readings available");
            } else {
                return bloodSugarReadings;
            }
        } catch (ServersideOpException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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
            BloodSugar patched = bloodSugarValidationHelper.patchNewBloodSugar(bloodSugar, userId);
            return bloodSugarDao.createBloodSugarReading(userId, patched);

        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/blood-sugars", method = RequestMethod.PUT)
    public boolean updateBloodSugar(@RequestBody BloodSugar bloodSugar, Principal principal) {

        try {
            bloodSugarValidationHelper.validateBloodSugarUpdate(bloodSugar, userDao.findIdByUsername(principal.getName()));
            return true;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/blood-sugars", method = RequestMethod.DELETE)
    public boolean deleteBloodSugar(@RequestBody BloodSugar bloodSugar, Principal principal) {

        try {
            int userId = userDao.findIdByUsername(principal.getName());
            bloodSugarDao.deleteBloodSugar(userId, bloodSugar);
            return true;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
