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
        "calories",
        "carbs",
        "fat",
        "fiber",
        "protein",
        "sodium",
        "water"
})
public class Summary {

    @JsonProperty("calories")
    private Integer calories;
    @JsonProperty("carbs")
    private Double carbs;
    @JsonProperty("fat")
    private Double fat;
    @JsonProperty("fiber")
    private Double fiber;
    @JsonProperty("protein")
    private Double protein;
    @JsonProperty("sodium")
    private Integer sodium;
    @JsonProperty("water")
    private Double water;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The calories
     */
    @JsonProperty("calories")
    public Integer getCalories() {
        return calories;
    }

    /**
     *
     * @param calories
     * The calories
     */
    @JsonProperty("calories")
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    /**
     *
     * @return
     * The carbs
     */
    @JsonProperty("carbs")
    public Double getCarbs() {
        return carbs;
    }

    /**
     *
     * @param carbs
     * The carbs
     */
    @JsonProperty("carbs")
    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    /**
     *
     * @return
     * The fat
     */
    @JsonProperty("fat")
    public Double getFat() {
        return fat;
    }

    /**
     *
     * @param fat
     * The fat
     */
    @JsonProperty("fat")
    public void setFat(Double fat) {
        this.fat = fat;
    }

    /**
     *
     * @return
     * The fiber
     */
    @JsonProperty("fiber")
    public Double getFiber() {
        return fiber;
    }

    /**
     *
     * @param fiber
     * The fiber
     */
    @JsonProperty("fiber")
    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    /**
     *
     * @return
     * The protein
     */
    @JsonProperty("protein")
    public Double getProtein() {
        return protein;
    }

    /**
     *
     * @param protein
     * The protein
     */
    @JsonProperty("protein")
    public void setProtein(Double protein) {
        this.protein = protein;
    }

    /**
     *
     * @return
     * The sodium
     */
    @JsonProperty("sodium")
    public Integer getSodium() {
        return sodium;
    }

    /**
     *
     * @param sodium
     * The sodium
     */
    @JsonProperty("sodium")
    public void setSodium(Integer sodium) {
        this.sodium = sodium;
    }

    /**
     *
     * @return
     * The water
     */
    @JsonProperty("water")
    public Double getWater() {
        return water;
    }

    /**
     *
     * @param water
     * The water
     */
    @JsonProperty("water")
    public void setWater(Double water) {
        this.water = water;
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