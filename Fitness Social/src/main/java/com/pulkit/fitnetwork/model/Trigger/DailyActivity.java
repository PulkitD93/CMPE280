package com.pulkit.fitnetwork.model.Trigger;

/**
 * Created by Shibu on 11/26/16.
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
        "activities",
        "goals",
        "summary"
})
public class DailyActivity {

    @JsonProperty("activities")
    private List<Object> activities = new ArrayList<Object>();
    @JsonProperty("goals")
    private Goals goals;
    @JsonProperty("summary")
    private ActivitySummary summary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The activities
     */
    @JsonProperty("activities")
    public List<Object> getActivities() {
        return activities;
    }

    /**
     *
     * @param activities
     * The activities
     */
    @JsonProperty("activities")
    public void setActivities(List<Object> activities) {
        this.activities = activities;
    }

    /**
     *
     * @return
     * The goals
     */
    @JsonProperty("goals")
    public Goals getGoals() {
        return goals;
    }

    /**
     *
     * @param goals
     * The goals
     */
    @JsonProperty("goals")
    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    /**
     *
     * @return
     * The summary
     */
    @JsonProperty("summary")
    public ActivitySummary getSummary() {
        return summary;
    }

    /**
     *
     * @param summary
     * The summary
     */
    @JsonProperty("summary")
    public void setSummary(ActivitySummary summary) {
        this.summary = summary;
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