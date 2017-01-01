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
        "date",
        "value"
})
public class Floors {

    @JsonProperty("date")
    private String date;
    @JsonProperty("value")
    private Integer value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The value
     */
    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
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
