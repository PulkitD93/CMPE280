package com.pulkit.fitnetwork.model.Trigger;

/**
 * Created by Shibu on 11/27/16.
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
        "accessLevel",
        "amount",
        "brand",
        "calories",
        "foodId",
        "locale",
        "mealTypeId",
        "name",
        "unit",
        "units"
})
public class LoggedFood {

    @JsonProperty("accessLevel")
    private String accessLevel;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("calories")
    private Integer calories;
    @JsonProperty("foodId")
    private Integer foodId;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("mealTypeId")
    private Integer mealTypeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("unit")
    private Unit unit;
    @JsonProperty("units")
    private List<Integer> units = new ArrayList<Integer>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The accessLevel
     */
    @JsonProperty("accessLevel")
    public String getAccessLevel() {
        return accessLevel;
    }

    /**
     *
     * @param accessLevel
     * The accessLevel
     */
    @JsonProperty("accessLevel")
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    /**
     *
     * @return
     * The amount
     */
    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     * The amount
     */
    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     *
     * @return
     * The brand
     */
    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     * The brand
     */
    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

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
     * The foodId
     */
    @JsonProperty("foodId")
    public Integer getFoodId() {
        return foodId;
    }

    /**
     *
     * @param foodId
     * The foodId
     */
    @JsonProperty("foodId")
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     *
     * @return
     * The locale
     */
    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    /**
     *
     * @param locale
     * The locale
     */
    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     *
     * @return
     * The mealTypeId
     */
    @JsonProperty("mealTypeId")
    public Integer getMealTypeId() {
        return mealTypeId;
    }

    /**
     *
     * @param mealTypeId
     * The mealTypeId
     */
    @JsonProperty("mealTypeId")
    public void setMealTypeId(Integer mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    /**
     *
     * @return
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The unit
     */
    @JsonProperty("unit")
    public Unit getUnit() {
        return unit;
    }

    /**
     *
     * @param unit
     * The unit
     */
    @JsonProperty("unit")
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     *
     * @return
     * The units
     */
    @JsonProperty("units")
    public List<Integer> getUnits() {
        return units;
    }

    /**
     *
     * @param units
     * The units
     */
    @JsonProperty("units")
    public void setUnits(List<Integer> units) {
        this.units = units;
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