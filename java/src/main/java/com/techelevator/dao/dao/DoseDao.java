package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.Dose;

import java.sql.SQLException;
import java.util.List;

public interface DoseDao {

    List<Dose> getListOfDoses(int userId);
    boolean deleteDose(Dose dose, int userId) throws SQLException;
}
