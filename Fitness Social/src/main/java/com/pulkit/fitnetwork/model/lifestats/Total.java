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
public class Total {

    @JsonProperty("caloriesOut")
    private CaloriesOut caloriesOut;
    @JsonProperty("distance")
    private Distance distance;
    @JsonProperty("floors")
    private Floors floors;
    @JsonProperty("steps")
    private Steps steps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The caloriesOut
     */
    @JsonProperty("caloriesOut")
    public CaloriesOut getCaloriesOut() {
        return caloriesOut;
    }

    /**
     *
     * @param caloriesOut
     * The caloriesOut
     */
    @JsonProperty("caloriesOut")
    public void setCaloriesOut(CaloriesOut caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    /**
     *
     * @return
     * The distance
     */
    @JsonProperty("distance")
    public Distance getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    @JsonProperty("distance")
    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     * The floors
     */
    @JsonProperty("floors")
    public Floors getFloors() {
        return floors;
    }

    /**
     *
     * @param floors
     * The floors
     */
    @JsonProperty("floors")
    public void setFloors(Floors floors) {
        this.floors = floors;
    }

    /**
     *
     * @return
     * The steps
     */
    @JsonProperty("steps")
    public Steps getSteps() {
        return steps;
    }

    /**
     *
     * @param steps
     * The steps
     */
    @JsonProperty("steps")
    public void setSteps(Steps steps) {
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