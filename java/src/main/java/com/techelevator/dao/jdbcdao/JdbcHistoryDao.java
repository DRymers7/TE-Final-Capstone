package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.HistoryDao;
import com.techelevator.model.ModelClasses.History;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHistoryDao implements HistoryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcHistoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<History> getHistoryForOneDay(int userId) {
        List<History> history = new ArrayList<>();

        String sql = "SELECT dose.dose_id, dose_units, time_of_dose, type_of_dose, input_level FROM dose " +
                "JOIN dose_user_data_join dud ON dose.dose_id = dud.dose_id " +
                "JOIN user_data ud ON ud.user_id = dud.user_id " +
                "WHERE ud.user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            history.add(mapRowToObject(rowSet));
        }
        return history;
    };

    private History mapRowToObject(SqlRowSet row) {
        History history = new History();

        history.setDoseId(row.getInt("dose_id"));
        history.setDoseUnits(row.getInt("dose_units"));
        history.setTimeOfDose(row.getTimestamp("time_of_dose"));
        history.setTypeOfDose(row.getString("type_of_dose"));
        history.setInputLevel(row.getInt("input_level"));
        history.setBloodSugarId(row.getInt("blood_sugar_id"));
        history.setTargetLow(row.getInt("target_low"));
        history.setTargetHigh(row.getInt("target_high"));
        history.setLastMeasurement(row.getTimestamp("last_measurement"));
        return history;
    }
}
