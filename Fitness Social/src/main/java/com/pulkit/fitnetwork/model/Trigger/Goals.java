package com.pulkit.fitnetwork.model.Trigger;

/**
 * Created by Shibu on 11/27/16.
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
        "activeMinutes",
        "caloriesOut",
        "distance",
        "steps"
})
public class Goals {

    @JsonProperty("activeMinutes")
    private Integer activeMinutes;
    @JsonProperty("caloriesOut")
    private Integer caloriesOut;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("steps")
    private Integer steps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The activeMinutes
     */
    @JsonProperty("activeMinutes")
    public Integer getActiveMinutes() {
        return activeMinutes;
    }

    /**
     *
     * @param activeMinutes
     * The activeMinutes
     */
    @JsonProperty("activeMinutes")
    public void setActiveMinutes(Integer activeMinutes) {
        this.activeMinutes = activeMinutes;
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
     * The distance
     */
    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
