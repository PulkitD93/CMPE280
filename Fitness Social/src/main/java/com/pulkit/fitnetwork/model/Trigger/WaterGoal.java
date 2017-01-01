package com.pulkit.fitnetwork.model.Trigger;

/**
 * Created by Shibu on 11/26/16.
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
        "goal"
})
public class WaterGoal {

    @JsonProperty("goal")
    private Goal goal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The goal
     */
    @JsonProperty("goal")
    public Goal getGoal() {
        return goal;
    }

    /**
     *
     * @param goal
     * The goal
     */
    @JsonProperty("goal")
    public void setGoal(Goal goal) {
        this.goal = goal;
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