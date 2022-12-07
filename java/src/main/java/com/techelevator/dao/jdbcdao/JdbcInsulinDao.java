package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.model.ModelClasses.BaseInsulin;
import com.techelevator.model.ModelClasses.InsulinInformation;
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

    // get single insulin object -done
    // get list of active insulin objects - done
    // create a new insulin data point - done
    // update insulin attributes - done
    // delete insulin objects - done

    @Override
    public List<BaseInsulin> getInsulinList(int userId) {

        List<BaseInsulin> insulinList = new ArrayList<>();

        String sql = "SELECT i.insulin_id, base_level, avg_level, time_last_dose, insulin_brand_name, insulin_strength, insulin_ratio " +
                "FROM insulin i " +
                "JOIN insulin_user_data_join ij ON i.insulin_id = ij.insulin_id " +
                "JOIN user_data ud ON ud.user_id = ij.user_id " +
                "WHERE ud.user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            insulinList.add(mapToRowSetBaseInsulin(rowSet));
        }
        return insulinList;
    }

    @Override
    public BaseInsulin createNewInsulin(int userId, BaseInsulin baseInsulin) throws SQLException {

        String sql = "INSERT INTO insulin (base_level, avg_level, time_last_dose, insulin_brand_name, insulin_strength, insulin_ratio) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING insulin_id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, baseInsulin.getBaseLevel(), baseInsulin.getAverageLevel(), baseInsulin.getTimeSinceLastDose(),
                baseInsulin.getInsulinBrandName(), baseInsulin.getInsulinStrength(), baseInsulin.getInsulinRatio());
        baseInsulin.setInsulinId(id);

        if (createNewJoinInsulinEntry(userId, id)) {
            return baseInsulin;
        } else {
            throw new SQLException("Create insulin error.");
        }

    }

    @Override
    public boolean updateInsulin(BaseInsulin baseInsulin) throws SQLException {

        String sql = "UPDATE insulin SET base_level = ?, avg_level = ?, time_last_dose = ?, insulin_brand_name = ?, " +
                "insulin_strength = ?, insulin_ratio = ? WHERE insulin_id = ?;";

        int success = jdbcTemplate.update(sql, baseInsulin.getBaseLevel(), baseInsulin.getAverageLevel(), baseInsulin.getTimeSinceLastDose(),
                baseInsulin.getInsulinBrandName(), baseInsulin.getInsulinStrength(), baseInsulin.getInsulinRatio(), baseInsulin.getInsulinId());

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

        String sql = "SELECT i.insulin_id, base_level, avg_level, time_last_dose, insulin_brand_name, insulin_strength, insulin_ratio " +
                "FROM insulin i " +
                "JOIN insulin_user_data_join ij ON i.insulin_id = ij.insulin_id " +
                "JOIN user_data ud ON ud.user_id = ij.user_id " +
                "WHERE ud.user_id = ? AND i.insulin_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId, insulin);

        if (rowSet.next()) {
            return mapToRowSetBaseInsulin(rowSet);
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

    private void deleteFromJoinTable(int insulinId) throws SQLException {
        String sql = "DELETE FROM insulin_user_data_join WHERE insulin_id = ? AND user_id = ?;";
        int rowsAffected = jdbcTemplate.update(sql, insulinId);
        if (rowsAffected != 1) {
            throw new SQLException("Delete failed.");
        }
    }

    private InsulinInformation mapToRowSetInsulinInformation(SqlRowSet rowSet) {
        InsulinInformation insulin = new InsulinInformation();
        fillSharedRows(rowSet, insulin);
        insulin.setInsulinType(rowSet.getString("insulin_type"));
        insulin.setHalfLife(rowSet.getInt("half_life"));
        insulin.setOnsetLow(rowSet.getInt("onset_low"));
        insulin.setOnsetLow(rowSet.getInt("onset_high"));
        insulin.setPeak(rowSet.getInt("peak"));
        insulin.setDuration(rowSet.getInt("duration"));
        return insulin;
    }

    private BaseInsulin mapToRowSetBaseInsulin(SqlRowSet rowSet) {
        BaseInsulin insulin = new BaseInsulin();
        fillSharedRows(rowSet, insulin);
        return insulin;
    }

    private void fillSharedRows(SqlRowSet rowSet, BaseInsulin insulin) {
        insulin.setInsulinId(rowSet.getInt("insulin_id"));
        insulin.setBaseLevel(rowSet.getDouble("base_level"));
        insulin.setAverageLevel(rowSet.getDouble("avg_level"));
        insulin.setTimeSinceLastDose(rowSet.getTimestamp("time_last_dose"));
        insulin.setInsulinBrandName(rowSet.getString("insulin_brand_name"));
        insulin.setInsulinStrength(rowSet.getString("insulin_strength"));
        insulin.setInsulinRatio(rowSet.getDouble("insulin_ratio"));
    }

}
