package com.techelevator.dao;

import com.techelevator.dao.jdbcdao.JdbcHistoryDao;
import com.techelevator.model.ModelClasses.History;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.SQLException;
import java.util.List;

public class JdbcHistoryDaoTests extends BaseDaoTests {

    private JdbcHistoryDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcHistoryDao(jdbcTemplate);
    }

    @Test
    public void get_one_month_averages() throws SQLException {
        List<History> histories = dao.getHistoryForOneMonth(1);
        Assert.assertEquals(12, histories.size());
    }

    @Test
    public void get_two_week_averages() throws SQLException {
        List<History> histories = dao.getHistoryForTwoWeeks(1);
        Assert.assertEquals(9, histories.size());
    }

    @Test
    public void get_one_week_averages() throws SQLException {
        List<History> histories = dao.getHistoryForOneWeek(1);
        Assert.assertEquals(6, histories.size());
    }

    @Test
    public void get_three_day_averages() throws SQLException {
        List<History> histories = dao.getHistoryForThreeDays(1);
        Assert.assertEquals(3, histories.size());
    }

    @Test
    public void get_one_day_averages() throws SQLException {
        List<History> histories = dao.getHistoryForOneDay(1);
        Assert.assertEquals(3, histories.size());
    }

}
