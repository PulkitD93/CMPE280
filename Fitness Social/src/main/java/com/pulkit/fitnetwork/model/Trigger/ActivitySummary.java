package com.pulkit.fitnetwork.model.Trigger;

/**
 * Created by Shibu on 11/27/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "activeScore",
        "activityCalories",
        "caloriesBMR",
        "caloriesOut",
        "distances",
        "fairlyActiveMinutes",
        "lightlyActiveMinutes",
        "marginalCalories",
        "sedentaryMinutes",
        "steps",
        "veryActiveMinutes"
})
public class ActivitySummary {

    @JsonProperty("activeScore")
    private Integer activeScore;
    @JsonProperty("activityCalories")
    private Integer activityCalories;
    @JsonProperty("caloriesBMR")
    private Integer caloriesBMR;
    @JsonProperty("caloriesOut")
    private Integer caloriesOut;
    @JsonProperty("distances")
    private List<Distance> distances = new ArrayList<Distance>();
    @JsonProperty("fairlyActiveMinutes")
    private Integer fairlyActiveMinutes;
    @JsonProperty("lightlyActiveMinutes")
    private Integer lightlyActiveMinutes;
    @JsonProperty("marginalCalories")
    private Integer marginalCalories;
    @JsonProperty("sedentaryMinutes")
    private Integer sedentaryMinutes;
    @JsonProperty("steps")
    private Integer steps;
    @JsonProperty("veryActiveMinutes")
    private Integer veryActiveMinutes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The activeScore
     */
    @JsonProperty("activeScore")
    public Integer getActiveScore() {
        return activeScore;
    }

    /**
     *
     * @param activeScore
     * The activeScore
     */
    @JsonProperty("activeScore")
    public void setActiveScore(Integer activeScore) {
        this.activeScore = activeScore;
    }

    /**
     *
     * @return
     * The activityCalories
     */
    @JsonProperty("activityCalories")
    public Integer getActivityCalories() {
        return activityCalories;
    }

    /**
     *
     * @param activityCalories
     * The activityCalories
     */
    @JsonProperty("activityCalories")
    public void setActivityCalories(Integer activityCalories) {
        this.activityCalories = activityCalories;
    }

    /**
     *
     * @return
     * The caloriesBMR
     */
    @JsonProperty("caloriesBMR")
    public Integer getCaloriesBMR() {
        return caloriesBMR;
    }

    /**
     *
     * @param caloriesBMR
     * The caloriesBMR
     */
    @JsonProperty("caloriesBMR")
    public void setCaloriesBMR(Integer caloriesBMR) {
        this.caloriesBMR = caloriesBMR;
    }

    /**
     *
     * @return
     * The caloriesOut
     */
    @JsonProperty("caloriesOut")
    public Integer getCaloriesOut() {
        return caloriesOut;
    }

    /**
     *
     * @param caloriesOut
     * The caloriesOut
     */
    @JsonProperty("caloriesOut")
    public void setCaloriesOut(Integer caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    /**
     *
     * @return
     * The distances
     */
    @JsonProperty("distances")
    public List<Distance> getDistances() {
        return distances;
    }

    /**
     *
     * @param distances
     * The distances
     */
    @JsonProperty("distances")
    public void setDistances(List<Distance> distances) {
        this.distances = distances;
    }

    /**
     *
     * @return
     * The fairlyActiveMinutes
     */
    @JsonProperty("fairlyActiveMinutes")
    public Integer getFairlyActiveMinutes() {
        return fairlyActiveMinutes;
    }

    /**
     *
     * @param fairlyActiveMinutes
     * The fairlyActiveMinutes
     */
    @JsonProperty("fairlyActiveMinutes")
    public void setFairlyActiveMinutes(Integer fairlyActiveMinutes) {
        this.fairlyActiveMinutes = fairlyActiveMinutes;
    }

    /**
     *
     * @return
     * The lightlyActiveMinutes
     */
    @JsonProperty("lightlyActiveMinutes")
    public Integer getLightlyActiveMinutes() {
        return lightlyActiveMinutes;
    }

    /**
     *
     * @param lightlyActiveMinutes
     * The lightlyActiveMinutes
     */
    @JsonProperty("lightlyActiveMinutes")
    public void setLightlyActiveMinutes(Integer lightlyActiveMinutes) {
        this.lightlyActiveMinutes = lightlyActiveMinutes;
    }

    /**
     *
     * @return
     * The marginalCalories
     */
    @JsonProperty("marginalCalories")
    public Integer getMarginalCalories() {
        return marginalCalories;
    }

    /**
     *
     * @param marginalCalories
     * The marginalCalories
     */
    @JsonProperty("marginalCalories")
    public void setMarginalCalories(Integer marginalCalories) {
        this.marginalCalories = marginalCalories;
    }

    /**
     *
     * @return
     * The sedentaryMinutes
     */
    @JsonProperty("sedentaryMinutes")
    public Integer getSedentaryMinutes() {
        return sedentaryMinutes;
    }

    /**
     *
     * @param sedentaryMinutes
     * The sedentaryMinutes
     */
    @JsonProperty("sedentaryMinutes")
    public void setSedentaryMinutes(Integer sedentaryMinutes) {
        this.sedentaryMinutes = sedentaryMinutes;
    }

    /**
     *
     * @return
     * The steps
     */
    @JsonProperty("steps")
    public Integer getSteps() {
        return steps;
    }

    /**
     *
     * @param steps
     * The steps
     */
    @JsonProperty("steps")
    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    /**
     *
     * @return
     * The veryActiveMinutes
     */
    @JsonProperty("veryActiveMinutes")
    public Integer getVeryActiveMinutes() {
        return veryActiveMinutes;
    }

    /**
     *
     * @param veryActiveMinutes
     * The veryActiveMinutes
     */
    @JsonProperty("veryActiveMinutes")
    public void setVeryActiveMinutes(Integer veryActiveMinutes) {
        this.veryActiveMinutes = veryActiveMinutes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}