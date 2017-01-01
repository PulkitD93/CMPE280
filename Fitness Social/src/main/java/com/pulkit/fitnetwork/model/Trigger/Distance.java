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
        "activity",
        "distance"
})
public class Distance {

    @JsonProperty("activity")
    private String activity;
    @JsonProperty("distance")
    private Integer distance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The activity
     */
    @JsonProperty("activity")
    public String getActivity() {
        return activity;
    }

    /**
     *
     * @param activity
     * The activity
     */
    @JsonProperty("activity")
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     *
     * @return
     * The distance
     */
    @JsonProperty("distance")
    public Integer getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    @JsonProperty("distance")
    public void setDistance(Integer distance) {
        this.distance = distance;
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