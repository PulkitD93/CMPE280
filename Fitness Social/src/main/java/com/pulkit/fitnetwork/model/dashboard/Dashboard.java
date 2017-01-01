package com.pulkit.fitnetwork.model.dashboard;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sid on 21-Nov-2016.
 */
public class Dashboard {

    private String recdate;
    private int stepCount;
    private int caloriesBurnt;
    private int caloriesGoal;
    private double waterConsumed;
    private int waterGoal;


    public String getRecdate() {
        return recdate;
    }

    public void setRecdate(String recdate) {
        this.recdate = recdate;
    }

    public int getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(int caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public void setCaloriesBurnt(int caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }

    public double getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(double waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    public int getWaterGoal() {
        return waterGoal;
    }

    public void setWaterGoal(int waterGoal) {
        this.waterGoal = waterGoal;
    }

    public Dashboard() {

    }


}
