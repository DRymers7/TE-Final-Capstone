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

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInsulinDao implements InsulinDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInsulinDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // get insulin object
    // get list of active insulin objects - done
    // create a new insulin data point
    // update insulin attributes
    // delete insulin objects

    @Override
    public List<Insulin> getInsulinList(int userId) {

        List<Insulin> insulinList = new ArrayList<>();

        String sql = "SELECT i.insulin_id, i.base_level, i.avg_level, i.time_last_dose, i.insulin_type, i.insulin_strength, i.half_life, i.onset, i.peak, i.insulin_ration, i.duration FROM insulin i " +
                "JOIN insulin_user_data_join ij ON ij.insulin_id = i.insulin_id " +
                "JOIN user_data ud ON ud.user_id = ij.user_id " +
                "WHERE ud.user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            insulinList.add(mapToRowSet(rowSet));
        }
        return insulinList;
    }

    @Override
    public BaseInsulin createNewInsulin(int userId, BaseInsulin baseInsulin) throws ServersideOpException {

        String sql = "INSERT INTO insulin (base_level, avg_level, time_last_dose, insulin_type, insulin_strength, insulin_ration) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING insulin_id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, baseInsulin.getBaseLevel(), baseInsulin.getAverageLevel(), baseInsulin.getTimeSinceLastDose(), baseInsulin.getInsulinType(), baseInsulin.getInsulinStrength(), baseInsulin.getInsulinRation());
        baseInsulin.setInsulinId(id);

        if (createNewJoinInsulinEntry(userId, id)) {
            return baseInsulin;
        } else {
            throw new ServersideOpException("Operation failed.");
        }

    }

    @Override
    public boolean updateInsulin(BaseInsulin baseInsulin) throws ServersideOpException {

        String sql = "UPDATE insulin SET base_level = ?, avg_level = ?, " +
                "time_last_dose = ?, insulin_type = ?, insulin_strength = ?, insulin_ration = ? WHERE insulin_id = ?;";

        try {
            jdbcTemplate.update(sql, baseInsulin.getBaseLevel(), baseInsulin.getAverageLevel(), baseInsulin.getTimeSinceLastDose(),
                    baseInsulin.getInsulinType(), baseInsulin.getInsulinStrength(), baseInsulin.getInsulinRation(), baseInsulin.getInsulinId());
            return true;
        } catch (InvalidResultSetAccessException e) {
            throw new ServersideOpException("Operation failed.");
        }

    }

    @Override
    public boolean deleteInsulin(BaseInsulin baseInsulin) throws ServersideOpException {

        deleteFromJoinTable(baseInsulin.getInsulinId());
        String sql = "DELETE FROM insulin WHERE insulin_id = ?;";

        try {
            jdbcTemplate.update(sql, baseInsulin.getInsulinId());
            return true;
        } catch (InvalidResultSetAccessException e) {
            throw new ServersideOpException("Operation failed.");
        }
    }

    @Override
    public void setBaseLevel(double baseLevel, int userId) {

        String sql = "UPDATE insulin " +
                     "SET base_level = ? " +
                     "WHERE user_id = ? ";

        jdbcTemplate.update(sql, baseLevel, userId);
    }

    @Override
    public Insulin getInsulin() {
        Insulin insulin = null;
        String sql = "SELECT user_id, base_level, avg_level, time_last_dose FROM insulin;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        if (rowSet.next()) {
            insulin = mapToRowSet(rowSet);
        }
        return insulin;
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
        insulin.setTimeSinceLastDose(row.getTimestamp("time_last_dose").toLocalDateTime());
        insulin.setInsulinType(row.getString("insulin_type"));
        insulin.setInsulinStrength(row.getString("insulin_strength"));
        insulin.setHalfLife(row.getInt("half_life"));
        insulin.setOnset(row.getInt("onset"));
        insulin.setPeak(row.getInt("peak"));
        insulin.setInsulinRation(row.getDouble("insulin_ration"));
        insulin.setDuration(row.getInt("duration"));
        return insulin;
    }

}
