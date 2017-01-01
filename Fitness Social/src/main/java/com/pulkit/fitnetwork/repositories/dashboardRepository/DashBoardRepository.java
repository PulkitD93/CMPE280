package com.pulkit.fitnetwork.repositories.dashboardRepository;

import com.pulkit.fitnetwork.model.dashboard.Dashboard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shikher on 10-Sep-16.
 */

@Repository
public interface DashBoardRepository {

    Dashboard getDailyDashBoard(long userid , String dateid);
    List<Dashboard> getWeekDashBoard(long userid, String startDate, String endDate);

}
