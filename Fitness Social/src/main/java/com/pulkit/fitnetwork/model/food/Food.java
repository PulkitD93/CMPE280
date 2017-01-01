package com.pulkit.fitnetwork.model.food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruchit on 12/1/16.
 */
public class Food {



    private List<Object> foods = new ArrayList<Object>();

    private FoodSummary summary;

    public List<Object> getFoods() {
        return foods;
    }

    public void setFoods(List<Object> foods) {
        this.foods = foods;
    }

    public FoodSummary getSummary() {
        return summary;
    }

    public void setSummary(FoodSummary summary) {
        this.summary = summary;
    }
}
