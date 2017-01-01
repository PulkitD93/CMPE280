package com.pulkit.fitnetwork.repositories.dashboardRepository;

import com.pulkit.fitnetwork.model.dashboard.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by sid on 21-Nov-2016.
 */

@Repository
public class DashBoardRepositoryImpl implements DashBoardRepository {

    private JdbcOperations jdbcOperations;

    private String getDailyDashboard = "select A.recdate,B.email,stepCount,caloriesBurnt,caloriesGoal,waterConsumed,waterGoal " +
            "from dashboard A inner join user B on  A.userId = B.userId " +
            "where A.userId = ? AND A.recdate = ?";

    private String getWeekDashboard = "select A.recdate,B.email,stepCount,caloriesBurnt,caloriesGoal,waterConsumed,waterGoal" +
            " from dashboard A inner join user B on  A.userId = B.userId where A.userId = ? and A.recdate >= ? and A.recdate <= ?";

    @Autowired
    public DashBoardRepositoryImpl(JdbcOperations jdbcOperations){this.jdbcOperations = jdbcOperations;}

    @Override
    public Dashboard getDailyDashBoard(long userid , String dateid) {
        System.out.println(userid+" in dashboard-impl " + dateid);
        return jdbcOperations.queryForObject(getDailyDashboard,
                new BeanPropertyRowMapper<>(Dashboard.class),
                userid,dateid);
    }

    @Override
    public List<Dashboard> getWeekDashBoard(long userid, String startDate, String endDate) {
        return jdbcOperations.query(getWeekDashboard,
                new BeanPropertyRowMapper<>(Dashboard.class),
                userid,startDate,endDate);
    }
}


