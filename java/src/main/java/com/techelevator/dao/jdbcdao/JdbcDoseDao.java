package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.DoseDao;
import com.techelevator.model.ModelClasses.BloodSugar;
import com.techelevator.model.ModelClasses.Dose;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoseDao implements DoseDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDoseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   @Override
   public List<Dose> getListOfDoses(int userId) {
        List<Dose> dose = new ArrayList<>();

        String sql = "SELECT dose.dose_id, dose_units, time_of_dose, type_of_dose, input_level FROM dose " +
                "JOIN dose_user_data_join dud ON dose.dose_id = dud.dose_id " +
                "JOIN user_data ud ON ud.user_id = dud.user_id " +
                "WHERE ud.user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            dose.add(mapRowToObject(rowSet));
        }
        return dose;
    }

    private Dose mapRowToObject(SqlRowSet row) {
        Dose dose = new Dose();

        dose.setDoseId(row.getInt("dose_id"));
        dose.setDoseUnits(row.getInt("dose_units"));
        dose.setTimeOfDose(row.getTimestamp("time_of_dose"));
        dose.setTypeOfDose(row.getString("type_of_dose"));
        dose.setInputLevel(row.getInt("input_level"));
        return dose;
    }
}
