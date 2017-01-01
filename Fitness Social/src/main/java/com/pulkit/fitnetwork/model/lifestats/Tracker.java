package com.pulkit.fitnetwork.model.lifestats;

/**
 * Created by ruchit on 12/1/16.
 */

import java.util.HashMap;
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
        "caloriesOut",
        "distance",
        "floors",
        "steps"
})
public class Tracker {

    @JsonProperty("caloriesOut")
    private CaloriesOut_ caloriesOut;
    @JsonProperty("distance")
    private Distance_ distance;
    @JsonProperty("floors")
    private Floors_ floors;
    @JsonProperty("steps")
    private Steps_ steps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The caloriesOut
     */
    @JsonProperty("caloriesOut")
    public CaloriesOut_ getCaloriesOut() {
        return caloriesOut;
    }

    /**
     *
     * @param caloriesOut
     * The caloriesOut
     */
    @JsonProperty("caloriesOut")
    public void setCaloriesOut(CaloriesOut_ caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    /**
     *
     * @return
     * The distance
     */
    @JsonProperty("distance")
    public Distance_ getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    @JsonProperty("distance")
    public void setDistance(Distance_ distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     * The floors
     */
    @JsonProperty("floors")
    public Floors_ getFloors() {
        return floors;
    }

    /**
     *
     * @param floors
     * The floors
     */
    @JsonProperty("floors")
    public void setFloors(Floors_ floors) {
        this.floors = floors;
    }

    /**
     *
     * @return
     * The steps
     */
    @JsonProperty("steps")
    public Steps_ getSteps() {
        return steps;
    }

    /**
     *
     * @param steps
     * The steps
     */
    @JsonProperty("steps")
    public void setSteps(Steps_ steps) {
        this.steps = steps;
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
