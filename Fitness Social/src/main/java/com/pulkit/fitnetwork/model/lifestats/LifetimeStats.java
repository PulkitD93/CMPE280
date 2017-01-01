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
        "best",
        "lifetime"
})
public class LifetimeStats {

    @JsonProperty("best")
    private Best best;
    @JsonProperty("lifetime")
    private Lifetime lifetime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The best
     */
    @JsonProperty("best")
    public Best getBest() {
        return best;
    }

    /**
     *
     * @param best
     * The best
     */
    @JsonProperty("best")
    public void setBest(Best best) {
        this.best = best;
    }

    /**
     *
     * @return
     * The lifetime
     */
    @JsonProperty("lifetime")
    public Lifetime getLifetime() {
        return lifetime;
    }

    /**
     *
     * @param lifetime
     * The lifetime
     */
    @JsonProperty("lifetime")
    public void setLifetime(Lifetime lifetime) {
        this.lifetime = lifetime;
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
