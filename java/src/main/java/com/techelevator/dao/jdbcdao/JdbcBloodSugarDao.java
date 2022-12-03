package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.model.ModelClasses.BloodSugar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBloodSugarDao implements BloodSugarDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBloodSugarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BloodSugar> getBloodSugarInformation(int userId) {
        List<BloodSugar> bloodSugars = new ArrayList<>();

        String sql = "SELECT user_id, target_low, target_high, input_level, last_measurement from blood_sugar WHERE user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            bloodSugars.add(mapRowToObject(rowSet));
        }
        return bloodSugars;
    }

    //todo Should return Bloodsugar for integration test
    @Override
    public void updateBloodSugar(int targetLow, int targetHigh, int userID) {
        BloodSugar bloodSugar = new BloodSugar();

        String sql = "UPDATE blood_sugar " +
                "SET target_low = ?, " +
                "target_high = ? " +
                "WHERE user_Id = ?;";

        jdbcTemplate.update(sql, targetLow, targetHigh, userID);

    }

    private BloodSugar mapRowToObject(SqlRowSet row) {
        BloodSugar bloodSugar = new BloodSugar();

        bloodSugar.setUserId(row.getInt("user_id"));
        bloodSugar.setTargetLow(row.getInt("target_low"));
        bloodSugar.setTargetHigh(row.getInt("target_high"));
        bloodSugar.setLastMeasurement(row.getDate("last_measurment").toLocalDate());
        return bloodSugar;
    }

}
