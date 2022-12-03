package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.InsulinDao;
import com.techelevator.model.ModelClasses.Insulin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcInsulinDao implements InsulinDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInsulinDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

    private Insulin mapToRowSet(SqlRowSet row) {
        Insulin insulin = new Insulin();
        String dateReturn = row.getString("time_last_dose");

        insulin.setUserId(row.getInt("user_id"));
        insulin.setBaseLevel(row.getDouble("base_level"));
        insulin.setAverageLevel(row.getDouble("avg_level"));
        insulin.setDaySinceLastDose(row.getDate("time_last_dose").toLocalDate());

        return insulin;
    }

}
