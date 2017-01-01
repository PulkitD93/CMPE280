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
        "total",
        "tracker"
})
public class Lifetime {

    @JsonProperty("total")
    private Total_ total;
    @JsonProperty("tracker")
    private Tracker_ tracker;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The total
     */
    @JsonProperty("total")
    public Total_ getTotal() {
        return total;
    }

    /**
     *
     * @param total
     * The total
     */
    @JsonProperty("total")
    public void setTotal(Total_ total) {
        this.total = total;
    }

    /**
     *
     * @return
     * The tracker
     */
    @JsonProperty("tracker")
    public Tracker_ getTracker() {
        return tracker;
    }

    /**
     *
     * @param tracker
     * The tracker
     */
    @JsonProperty("tracker")
    public void setTracker(Tracker_ tracker) {
        this.tracker = tracker;
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