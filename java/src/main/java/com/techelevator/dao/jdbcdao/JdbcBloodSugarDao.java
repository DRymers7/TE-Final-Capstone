package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BloodSugar;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBloodSugarDao implements BloodSugarDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBloodSugarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // get single blood sugar reading
    // get list of blood sugar readings
    // create a new blood sugar reading
    // update a blood sugar reading
    // delete a blood sugar reading

    @Override
    public List<BloodSugar> getBloodSugarReadings(int userId) {
        List<BloodSugar> bloodSugars = new ArrayList<>();

        String sql = "SELECT bs.blood_sugar_id, target_low, target_high, input_level, last_measurement FROM blood_sugar bs " +
        "JOIN blood_sugar_user_data_join bj ON bs.blood_sugar_id = bj.blood_sugar_id " +
        "JOIN user_data ud ON ud.user_id = bj.user_id " +
        "WHERE ud.user_id = ? " +
        "ORDER BY last_measurement DESC;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            bloodSugars.add(mapRowToObject(rowSet));
        }
        return bloodSugars;
    }

    @Override
    public BloodSugar createBloodSugarReading(int userId, BloodSugar bloodSugar) throws SQLException {

        String sql = "INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement) " +
                "VALUES (?, ? ,?, ?) RETURNING blood_sugar_id;";
        validateTimeInPost(bloodSugar);


        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, bloodSugar.getTargetLow(), bloodSugar.getTargetHigh(),
                bloodSugar.getInputLevel(), bloodSugar.getLastMeasurement());
        bloodSugar.setBloodSugarId(id);

        if (createBloodSugarJoinEntry(id, userId)) {
            return bloodSugar;
        } else {
            throw new SQLException("Operation failed.");
        }


    }

    @Override
    public boolean updateBloodSugarReading(int bloodSugarId, BloodSugar bloodSugar) throws SQLException  {

        String sql = "UPDATE blood_sugar SET target_low = ?, target_high = ?, input_level = ?, last_measurement = ? " +
                "WHERE blood_sugar_id = ?;";

        int success = jdbcTemplate.update(sql, bloodSugar.getTargetLow(), bloodSugar.getTargetHigh(), bloodSugar.getInputLevel(), bloodSugar.getLastMeasurement(),
                bloodSugarId);
        if (success == 1) {
            return true;
        } else {
            throw new SQLException("Update Blood sugar failed.");
        }
    }

    @Override
    public boolean deleteBloodSugar(int userId, BloodSugar bloodSugar) throws SQLException {

        deleteFromJoinTable(bloodSugar.getBloodSugarId(), userId);
        String sql = "DELETE FROM blood_sugar WHERE blood_sugar_id = ?;";
        try {
            jdbcTemplate.update(sql, bloodSugar.getBloodSugarId());
            return true;
        } catch (InvalidResultSetAccessException e) {
            throw new SQLException("Cannot delete blood sugar. Violation of join table constraint.");
        }


    }

    @Override
    public BloodSugar getMostRecentReading(int userId) throws NullPointerException {

        String sql = "SELECT bs.blood_sugar_id, target_low, target_high, input_level, last_measurement FROM blood_sugar bs JOIN blood_sugar_user_data_join bj ON bj.blood_sugar_id = bs.blood_sugar_id " +
                "JOIN user_data ud ON ud.user_id = bj.user_id " +
                "WHERE ud.user_id = ? " +
                "ORDER BY last_measurement DESC " +
                "LIMIT 1;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        if (rowSet.next()) {
            return mapRowToObject(rowSet);
        } else {
            return null;
        }
    }

    private boolean createBloodSugarJoinEntry(Integer bloodSugarId, int userId) throws SQLException {

        String sql = "INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (?, ?) RETURNING blood_sugar_id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, bloodSugarId, userId);
        if (id > 0) {
            return true;
        } else {
            return false;
        }

    }

    private void deleteFromJoinTable(int bloodSugarId, int userId) throws SQLException {
        String sql = "DELETE FROM blood_sugar_user_data_join WHERE blood_sugar_id = ? AND user_id = ?;";
        int rowsAffected = jdbcTemplate.update(sql, bloodSugarId, userId);
        if (rowsAffected != 1) {
            throw new SQLException("Delete Failed.");
        }
    }

    private BloodSugar validateTimeInPost(BloodSugar bloodSugar){
        if (bloodSugar.getLastMeasurement()==null){
            bloodSugar.setLastMeasurement(new Timestamp(System.currentTimeMillis()));
        }
        return bloodSugar;
    }


    private BloodSugar mapRowToObject(SqlRowSet row) {
        BloodSugar bloodSugar = new BloodSugar();

        bloodSugar.setBloodSugarId(row.getInt("blood_sugar_id"));
        bloodSugar.setTargetLow(row.getInt("target_low"));
        bloodSugar.setTargetHigh(row.getInt("target_high"));
        bloodSugar.setLastMeasurement(row.getTimestamp("last_measurement"));
        return bloodSugar;
    }

}
