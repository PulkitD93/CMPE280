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
        "isFavorite",
        "logDate",
        "logId",
        "loggedFood",
        "nutritionalValues"
})
public class Food {

    @JsonProperty("isFavorite")
    private Boolean isFavorite;
    @JsonProperty("logDate")
    private String logDate;
    @JsonProperty("logId")
    private Long logId;
    @JsonProperty("loggedFood")
    private LoggedFood loggedFood;
    @JsonProperty("nutritionalValues")
    private NutritionalValues nutritionalValues;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The isFavorite
     */
    @JsonProperty("isFavorite")
    public Boolean getIsFavorite() {
        return isFavorite;
    }

    /**
     *
     * @param isFavorite
     * The isFavorite
     */
    @JsonProperty("isFavorite")
    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    /**
     *
     * @return
     * The logDate
     */
    @JsonProperty("logDate")
    public String getLogDate() {
        return logDate;
    }

    /**
     *
     * @param logDate
     * The logDate
     */
    @JsonProperty("logDate")
    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    /**
     *
     * @return
     * The logId
     */
    @JsonProperty("logId")
    public Long getLogId() {
        return logId;
    }

    /**
     *
     * @param logId
     * The logId
     */
    @JsonProperty("logId")
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     *
     * @return
     * The loggedFood
     */
    @JsonProperty("loggedFood")
    public LoggedFood getLoggedFood() {
        return loggedFood;
    }

    /**
     *
     * @param loggedFood
     * The loggedFood
     */
    @JsonProperty("loggedFood")
    public void setLoggedFood(LoggedFood loggedFood) {
        this.loggedFood = loggedFood;
    }

    /**
     *
     * @return
     * The nutritionalValues
     */
    @JsonProperty("nutritionalValues")
    public NutritionalValues getNutritionalValues() {
        return nutritionalValues;
    }

    /**
     *
     * @param nutritionalValues
     * The nutritionalValues
     */
    @JsonProperty("nutritionalValues")
    public void setNutritionalValues(NutritionalValues nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
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