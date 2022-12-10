package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.HistoryDao;
import com.techelevator.model.ModelClasses.History;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHistoryDao implements HistoryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcHistoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<History> getHistoryForOneMonth(int userId) throws SQLException {
        List<History> history = new ArrayList<>();

        String sql = "SELECT dose.dose_id, dose_units, time_of_dose, type_of_dose, dose.input_level, " +
                "blood_sugar.input_level, target_low, target_high, last_measurement, blood_sugar.blood_sugar_id, ud.user_id FROM dose " +
        "JOIN dose_user_data_join dud ON dose.dose_id = dud.dose_id " +
        "JOIN user_data ud ON ud.user_id = dud.user_id " +
        "FULL OUTER JOIN blood_sugar ON dose.input_level = blood_sugar.input_level " +
        "WHERE ud.user_id = ? AND time_of_dose > (select CURRENT_DATE - interval '1 month' as month_w_31_days) AND last_measurement > (select CURRENT_DATE - interval '1 month' as month_w_31_days) "
                + "ORDER BY time_of_dose DESC;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            history.add(mapRowToObject(rowSet));
        }
        filterHistoryList(history);
        return history;
    };

    @Override
    public List<History> getHistoryForTwoWeeks(int userId) throws SQLException{
        List<History> history = new ArrayList<>();

        String sql = "SELECT dose.dose_id, dose_units, time_of_dose, type_of_dose, dose.input_level, " +
                "blood_sugar.input_level, target_low, target_high, last_measurement, blood_sugar.blood_sugar_id, ud.user_id FROM dose " +
                "JOIN dose_user_data_join dud ON dose.dose_id = dud.dose_id " +
                "JOIN user_data ud ON ud.user_id = dud.user_id " +
                "FULL OUTER JOIN blood_sugar ON dose.input_level = blood_sugar.input_level " +
                "WHERE ud.user_id = ? AND time_of_dose > (select CURRENT_DATE - interval '2 week' as month_w_31_days) AND last_measurement > (select CURRENT_DATE - interval '2 week' as month_w_31_days) " +
                "ORDER BY time_of_dose DESC;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            history.add(mapRowToObject(rowSet));
        }
        filterHistoryList(history);
        return history;
    };

    @Override
    public List<History> getHistoryForOneWeek(int userId) throws SQLException{
        List<History> history = new ArrayList<>();

        String sql = "SELECT dose.dose_id, dose_units, time_of_dose, type_of_dose, dose.input_level, " +
                "blood_sugar.input_level, target_low, target_high, last_measurement, blood_sugar.blood_sugar_id, ud.user_id FROM dose " +
                "JOIN dose_user_data_join dud ON dose.dose_id = dud.dose_id " +
                "JOIN user_data ud ON ud.user_id = dud.user_id " +
                "FULL OUTER JOIN blood_sugar ON dose.input_level = blood_sugar.input_level " +
                "WHERE ud.user_id = ? AND time_of_dose > (select CURRENT_DATE - interval '1 week' as month_w_31_days) AND last_measurement > (select CURRENT_DATE - interval '1 week' as month_w_31_days) " +
                "ORDER BY time_of_dose DESC;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            history.add(mapRowToObject(rowSet));
        }
        filterHistoryList(history);
        return history;
    };

    @Override
    public List<History> getHistoryForThreeDays(int userId) throws SQLException{
        List<History> history = new ArrayList<>();

        String sql = "SELECT dose.dose_id, dose_units, time_of_dose, type_of_dose, dose.input_level, " +
                "blood_sugar.input_level, target_low, target_high, last_measurement, blood_sugar.blood_sugar_id, ud.user_id FROM dose " +
                "JOIN dose_user_data_join dud ON dose.dose_id = dud.dose_id " +
                "JOIN user_data ud ON ud.user_id = dud.user_id " +
                "FULL OUTER JOIN blood_sugar ON dose.input_level = blood_sugar.input_level " +
                "WHERE ud.user_id = ? AND time_of_dose > (select CURRENT_DATE - interval '3 day' as month_w_31_days) AND last_measurement > (select CURRENT_DATE - interval '3 day' as month_w_31_days) " +
                "ORDER BY time_of_dose DESC;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            history.add(mapRowToObject(rowSet));
        }
        filterHistoryList(history);
        return history;
    };

    @Override
    public List<History> getHistoryForOneDay(int userId) throws SQLException{
        List<History> history = new ArrayList<>();

        String sql = "SELECT dose.dose_id, dose_units, time_of_dose, type_of_dose, dose.input_level, " +
                "blood_sugar.input_level, target_low, target_high, last_measurement, blood_sugar.blood_sugar_id, ud.user_id FROM dose " +
                "JOIN dose_user_data_join dud ON dose.dose_id = dud.dose_id " +
                "JOIN user_data ud ON ud.user_id = dud.user_id " +
                "JOIN blood_sugar ON dose.input_level = blood_sugar.input_level " +
                "WHERE ud.user_id = ? AND time_of_dose > (select CURRENT_DATE - interval '1 day' as month_w_31_days) AND last_measurement > (select CURRENT_DATE - interval '1 day' as month_w_31_days) " +
                "ORDER BY time_of_dose DESC;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            history.add(mapRowToObject(rowSet));
        }
        filterHistoryList(history);
        return history;
    };

    private void filterHistoryList(List<History> historyList) {
         List<History> filterList = new ArrayList<History>();
        for (History history : historyList) {
                filterList.add(history);
            }
    }


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
