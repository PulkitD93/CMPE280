
package com.pulkit.fitnetwork.model.userprofile;

import com.fasterxml.jackson.annotation.*;
import com.pulkit.fitnetwork.model.Newsfeed.NewsfeedList;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "username",
    "email",
    "description",
    "profileImageUrl",
    "address",
    "height",
    "age",
    "weight",
    "averageDailySteps",
    "dateOfBirth",
    "gender",
    "topBadges",
    "newsfeed"
})
public class WebUserProfile {
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("description")
    private String description;
    @JsonProperty("profileImageUrl")
    private String profileImageUrl;
    @JsonProperty("address")
    private String address;
    @JsonProperty("height")
    private Double height;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("averageDailySteps")
    private Integer averageDailySteps;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("topBadges")
    private List<TopBadge> topBadges = new ArrayList<TopBadge>();
    @JsonProperty("newsfeed")
    private NewsfeedList newsfeed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
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
     *     The profileImageUrl
     */
    @JsonProperty("profileImageUrl")
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     * 
     * @param profileImageUrl
     *     The profileImageUrl
     */
    @JsonProperty("profileImageUrl")
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The height
     */
    @JsonProperty("height")
    public Double getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    @JsonProperty("height")
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The age
     */
    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     * @return
     *     The weight
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 
     * @return
     *     The averageDailySteps
     */
    @JsonProperty("averageDailySteps")
    public Integer getAverageDailySteps() {
        return averageDailySteps;
    }

    /**
     * 
     * @param averageDailySteps
     *     The averageDailySteps
     */
    @JsonProperty("averageDailySteps")
    public void setAverageDailySteps(Integer averageDailySteps) {
        this.averageDailySteps = averageDailySteps;
    }

    /**
     * 
     * @return
     *     The dateOfBirth
     */
    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 
     * @param dateOfBirth
     *     The dateOfBirth
     */
    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * 
     * @return
     *     The gender
     */
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The topBadges
     */
    @JsonProperty("topBadges")
    public List<TopBadge> getTopBadges() {
        return topBadges;
    }

    /**
     * 
     * @param topBadges
     *     The topBadges
     */
    @JsonProperty("topBadges")
    public void setTopBadges(List<TopBadge> topBadges) {
        this.topBadges = topBadges;
    }

    /**
     * 
     * @return
     *     The newsfeed
     */
    @JsonProperty("newsfeed")
    public NewsfeedList getNewsfeed() {
        return newsfeed;
    }

    /**
     * 
     * @param newsfeed
     *     The newsfeed
     */
    @JsonProperty("newsfeed")
    public void setNewsfeed(NewsfeedList newsfeed) {
        this.newsfeed = newsfeed;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
