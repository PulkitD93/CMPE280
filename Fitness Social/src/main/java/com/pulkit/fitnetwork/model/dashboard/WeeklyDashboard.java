package com.pulkit.fitnetwork.model.dashboard;

import java.util.List;

/**
 * Created by shikh on 08-Dec-16.
 */
public class WeeklyDashboard {
    private List<Dashboard> list;

    public WeeklyDashboard(List<Dashboard> list) {
        this.list = list;
    }

    public WeeklyDashboard() {
    }

    public List<Dashboard> getList() {
        return list;
    }

    public void setList(List<Dashboard> list) {
        this.list = list;
    }
}
