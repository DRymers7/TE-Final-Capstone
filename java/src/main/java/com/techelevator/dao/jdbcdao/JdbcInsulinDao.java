package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.Insulin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInsulinDao implements InsulinDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInsulinDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // get single insulin object
    // get list of active insulin objects - done
    // create a new insulin data point - done
    // update insulin attributes - done
    // delete insulin objects - done

    @Override
    public List<Insulin> getInsulinList(int userId) throws SQLException {

        List<Insulin> insulinList = new ArrayList<>();

        String sql = "SELECT i.insulin_id, i.base_level, i.avg_level, i.time_last_dose, i.insulin_type, i.insulin_strength, i.half_life, i.onset, i.peak, i.insulin_ration, i.duration FROM insulin i " +
                "JOIN insulin_user_data_join ij ON ij.insulin_id = i.insulin_id " +
                "JOIN user_data ud ON ud.user_id = ij.user_id " +
                "WHERE ud.user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            insulinList.add(mapToRowSet(rowSet));
        }
        if (insulinList.size() != 0) {
            return insulinList;
        } else {
            throw new SQLException("No insulin available.");
        }

    }

    @Override
    public BaseInsulin createNewInsulin(int userId, BaseInsulin baseInsulin) throws SQLException {

        String sql = "INSERT INTO insulin (base_level, avg_level, time_last_dose, insulin_type, insulin_strength, insulin_ration) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING insulin_id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, baseInsulin.getBaseLevel(), baseInsulin.getAverageLevel(), baseInsulin.getTimeSinceLastDose(), baseInsulin.getInsulinType(), baseInsulin.getInsulinStrength(), baseInsulin.getInsulinRation());
        baseInsulin.setInsulinId(id);

        if (createNewJoinInsulinEntry(userId, id)) {
            return baseInsulin;
        } else {
            throw new SQLException("Operation failed.");
        }

    }

    @Override
    public boolean updateInsulin(BaseInsulin baseInsulin) throws SQLException {

        String sql = "UPDATE insulin SET base_level = ?, avg_level = ?, " +
                "time_last_dose = ?, insulin_type = ?, insulin_strength = ?, insulin_ration = ? WHERE insulin_id = ?;";

        int success = jdbcTemplate.update(sql, baseInsulin.getBaseLevel(), baseInsulin.getAverageLevel(), baseInsulin.getTimeSinceLastDose(),
                baseInsulin.getInsulinType(), baseInsulin.getInsulinStrength(), baseInsulin.getInsulinRation(), baseInsulin.getInsulinId());

        if (success == 1) {
            return true;
        } else {
            throw new SQLException("Update insulin failed.");
        }
    }

    @Override
    public boolean deleteInsulin(BaseInsulin baseInsulin) throws SQLException {

        deleteFromJoinTable(baseInsulin.getInsulinId());
        String sql = "DELETE FROM insulin WHERE insulin_id = ?;";

        try {
            jdbcTemplate.update(sql, baseInsulin.getInsulinId());
            return true;
        } catch (InvalidResultSetAccessException e) {
            throw new SQLException("Operation failed.");
        }
    }

    @Override
    public BaseInsulin getSingleInsulin(int userId, int insulinId, BaseInsulin insulin) throws SQLException {

        String sql = "SELECT insulin.insulin_id, base_level, avg_level, time_last_dose, insulin_type, insulin_strength, half_life, onset, peak, insulin_ration, duration " +
                "FROM insulin " +
                "JOIN insulin_data_join ij ON ij.insulin_id = insulin.insulin_id " +
                "JOIN user_data ud ON ud.user_id = ij.user_id " +
                "WHERE ud.user_id = ? AND insulin.insulin_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId, insulin);

        if (rowSet.next()) {
            BaseInsulin baseInsulin = mapToRowSetBaseInsulin(rowSet);
            return baseInsulin;
        } else {
            throw new SQLException("Cannot find single Insulin object");
        }

    }

    private boolean createNewJoinInsulinEntry(int userId, Integer insulinId) {

        String sql = "INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (?, ?) RETURNING insulin_id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, userId, insulinId);
        if (id > 0) {
            return true;
        } else {
            return false;
        }

    }

    private void deleteFromJoinTable(int insulinId) {
        String sql = "DELETE FROM insulin_user_data_join WHERE insulin_id = ?;";
        jdbcTemplate.update(sql, insulinId);
    }

    private Insulin mapToRowSet(SqlRowSet row) {
        Insulin insulin = new Insulin();
        insulin.setInsulinId(row.getInt("insulin_id"));
        insulin.setBaseLevel(row.getDouble("base_level"));
        insulin.setAverageLevel(row.getDouble("avg_level"));
        insulin.setTimeSinceLastDose(row.getTimestamp("time_last_dose"));
        insulin.setInsulinType(row.getString("insulin_type"));
        insulin.setInsulinStrength(row.getString("insulin_strength"));
        insulin.setHalfLife(row.getInt("half_life"));
        insulin.setOnset(row.getInt("onset"));
        insulin.setPeak(row.getInt("peak"));
        insulin.setInsulinRation(row.getDouble("insulin_ration"));
        insulin.setDuration(row.getInt("duration"));
        return insulin;
    }

    private BaseInsulin mapToRowSetBaseInsulin(SqlRowSet rowSet) {
        BaseInsulin insulin = new BaseInsulin();
        insulin.setInsulinId(rowSet.getInt("insulin_id"));
        insulin.setBaseLevel(rowSet.getDouble("base_level"));
        insulin.setAverageLevel(rowSet.getDouble("avg_level"));
        insulin.setTimeSinceLastDose(rowSet.getTimestamp("time_last_dose"));
        insulin.setInsulinType(rowSet.getString("insulin_type"));
        insulin.setInsulinStrength(rowSet.getString("insulin_strength"));
        insulin.setInsulinRation(rowSet.getDouble("insulin_ration"));
        return insulin;
    }

}
