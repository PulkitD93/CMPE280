
package com.pulkit.fitnetwork.model.userprofile;

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
    "badgeGradientEndColor",
    "badgeGradientStartColor",
    "badgeType",
    "category",
    "cheers",
    "dateTime",
    "description",
    "earnedMessage",
    "encodedId",
    "image100px",
    "image125px",
    "image300px",
    "image50px",
    "image75px",
    "marketingDescription",
    "mobileDescription",
    "name",
    "shareImage640px",
    "shareText",
    "shortDescription",
    "shortName",
    "timesAchieved",
    "value",
    "unit"
})
public class TopBadge {

    @JsonProperty("badgeGradientEndColor")
    private String badgeGradientEndColor;
    @JsonProperty("badgeGradientStartColor")
    private String badgeGradientStartColor;
    @JsonProperty("badgeType")
    private String badgeType;
    @JsonProperty("category")
    private String category;
    @JsonProperty("cheers")
    private List<Object> cheers = new ArrayList<Object>();
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("description")
    private String description;
    @JsonProperty("earnedMessage")
    private String earnedMessage;
    @JsonProperty("encodedId")
    private String encodedId;
    @JsonProperty("image100px")
    private String image100px;
    @JsonProperty("image125px")
    private String image125px;
    @JsonProperty("image300px")
    private String image300px;
    @JsonProperty("image50px")
    private String image50px;
    @JsonProperty("image75px")
    private String image75px;
    @JsonProperty("marketingDescription")
    private String marketingDescription;
    @JsonProperty("mobileDescription")
    private String mobileDescription;
    @JsonProperty("name")
    private String name;
    @JsonProperty("shareImage640px")
    private String shareImage640px;
    @JsonProperty("shareText")
    private String shareText;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("timesAchieved")
    private Integer timesAchieved;
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("unit")
    private String unit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The badgeGradientEndColor
     */
    @JsonProperty("badgeGradientEndColor")
    public String getBadgeGradientEndColor() {
        return badgeGradientEndColor;
    }

    /**
     * 
     * @param badgeGradientEndColor
     *     The badgeGradientEndColor
     */
    @JsonProperty("badgeGradientEndColor")
    public void setBadgeGradientEndColor(String badgeGradientEndColor) {
        this.badgeGradientEndColor = badgeGradientEndColor;
    }

    /**
     * 
     * @return
     *     The badgeGradientStartColor
     */
    @JsonProperty("badgeGradientStartColor")
    public String getBadgeGradientStartColor() {
        return badgeGradientStartColor;
    }

    /**
     * 
     * @param badgeGradientStartColor
     *     The badgeGradientStartColor
     */
    @JsonProperty("badgeGradientStartColor")
    public void setBadgeGradientStartColor(String badgeGradientStartColor) {
        this.badgeGradientStartColor = badgeGradientStartColor;
    }

    /**
     * 
     * @return
     *     The badgeType
     */
    @JsonProperty("badgeType")
    public String getBadgeType() {
        return badgeType;
    }

    /**
     * 
     * @param badgeType
     *     The badgeType
     */
    @JsonProperty("badgeType")
    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    /**
     * 
     * @return
     *     The category
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The cheers
     */
    @JsonProperty("cheers")
    public List<Object> getCheers() {
        return cheers;
    }

    /**
     * 
     * @param cheers
     *     The cheers
     */
    @JsonProperty("cheers")
    public void setCheers(List<Object> cheers) {
        this.cheers = cheers;
    }

    /**
     * 
     * @return
     *     The dateTime
     */
    @JsonProperty("dateTime")
    public String getDateTime() {
        return dateTime;
    }

    /**
     * 
     * @param dateTime
     *     The dateTime
     */
    @JsonProperty("dateTime")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The earnedMessage
     */
    @JsonProperty("earnedMessage")
    public String getEarnedMessage() {
        return earnedMessage;
    }

    /**
     * 
     * @param earnedMessage
     *     The earnedMessage
     */
    @JsonProperty("earnedMessage")
    public void setEarnedMessage(String earnedMessage) {
        this.earnedMessage = earnedMessage;
    }

    /**
     * 
     * @return
     *     The encodedId
     */
    @JsonProperty("encodedId")
    public String getEncodedId() {
        return encodedId;
    }

    /**
     * 
     * @param encodedId
     *     The encodedId
     */
    @JsonProperty("encodedId")
    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }

    /**
     * 
     * @return
     *     The image100px
     */
    @JsonProperty("image100px")
    public String getImage100px() {
        return image100px;
    }

    /**
     * 
     * @param image100px
     *     The image100px
     */
    @JsonProperty("image100px")
    public void setImage100px(String image100px) {
        this.image100px = image100px;
    }

    /**
     * 
     * @return
     *     The image125px
     */
    @JsonProperty("image125px")
    public String getImage125px() {
        return image125px;
    }

    /**
     * 
     * @param image125px
     *     The image125px
     */
    @JsonProperty("image125px")
    public void setImage125px(String image125px) {
        this.image125px = image125px;
    }

    /**
     * 
     * @return
     *     The image300px
     */
    @JsonProperty("image300px")
    public String getImage300px() {
        return image300px;
    }

    /**
     * 
     * @param image300px
     *     The image300px
     */
    @JsonProperty("image300px")
    public void setImage300px(String image300px) {
        this.image300px = image300px;
    }

    /**
     * 
     * @return
     *     The image50px
     */
    @JsonProperty("image50px")
    public String getImage50px() {
        return image50px;
    }

    /**
     * 
     * @param image50px
     *     The image50px
     */
    @JsonProperty("image50px")
    public void setImage50px(String image50px) {
        this.image50px = image50px;
    }

    /**
     * 
     * @return
     *     The image75px
     */
    @JsonProperty("image75px")
    public String getImage75px() {
        return image75px;
    }

    /**
     * 
     * @param image75px
     *     The image75px
     */
    @JsonProperty("image75px")
    public void setImage75px(String image75px) {
        this.image75px = image75px;
    }

    /**
     * 
     * @return
     *     The marketingDescription
     */
    @JsonProperty("marketingDescription")
    public String getMarketingDescription() {
        return marketingDescription;
    }

    /**
     * 
     * @param marketingDescription
     *     The marketingDescription
     */
    @JsonProperty("marketingDescription")
    public void setMarketingDescription(String marketingDescription) {
        this.marketingDescription = marketingDescription;
    }

    /**
     * 
     * @return
     *     The mobileDescription
     */
    @JsonProperty("mobileDescription")
    public String getMobileDescription() {
        return mobileDescription;
    }

    /**
     * 
     * @param mobileDescription
     *     The mobileDescription
     */
    @JsonProperty("mobileDescription")
    public void setMobileDescription(String mobileDescription) {
        this.mobileDescription = mobileDescription;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The shareImage640px
     */
    @JsonProperty("shareImage640px")
    public String getShareImage640px() {
        return shareImage640px;
    }

    /**
     * 
     * @param shareImage640px
     *     The shareImage640px
     */
    @JsonProperty("shareImage640px")
    public void setShareImage640px(String shareImage640px) {
        this.shareImage640px = shareImage640px;
    }

    /**
     * 
     * @return
     *     The shareText
     */
    @JsonProperty("shareText")
    public String getShareText() {
        return shareText;
    }

    /**
     * 
     * @param shareText
     *     The shareText
     */
    @JsonProperty("shareText")
    public void setShareText(String shareText) {
        this.shareText = shareText;
    }

    /**
     * 
     * @return
     *     The shortDescription
     */
    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 
     * @param shortDescription
     *     The shortDescription
     */
    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * 
     * @return
     *     The shortName
     */
    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    /**
     * 
     * @param shortName
     *     The shortName
     */
    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 
     * @return
     *     The timesAchieved
     */
    @JsonProperty("timesAchieved")
    public Integer getTimesAchieved() {
        return timesAchieved;
    }

    /**
     * 
     * @param timesAchieved
     *     The timesAchieved
     */
    @JsonProperty("timesAchieved")
    public void setTimesAchieved(Integer timesAchieved) {
        this.timesAchieved = timesAchieved;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The unit
     */
    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    /**
     * 
     * @param unit
     *     The unit
     */
    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
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
