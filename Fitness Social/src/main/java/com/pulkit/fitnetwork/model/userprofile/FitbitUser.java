
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
    "aboutMe",
    "age",
    "avatar",
    "avatar150",
    "averageDailySteps",
    "city",
    "clockTimeDisplayFormat",
    "corporate",
    "country",
    "dateOfBirth",
    "displayName",
    "encodedId",
    "features",
    "friend",
    "fullName",
    "gender",
    "height",
    "locale",
    "memberSince",
    "mfaEnabled",
    "nickname",
    "offsetFromUTCMillis",
    "startDayOfWeek",
    "state",
    "strideLengthRunning",
    "strideLengthWalking",
    "timezone",
    "topBadges",
    "weight"
})
public class FitbitUser {

    @JsonProperty("aboutMe")
    private String aboutMe;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("avatar150")
    private String avatar150;
    @JsonProperty("averageDailySteps")
    private Integer averageDailySteps;
    @JsonProperty("city")
    private String city;
    @JsonProperty("clockTimeDisplayFormat")
    private String clockTimeDisplayFormat;
    @JsonProperty("corporate")
    private Boolean corporate;
    @JsonProperty("country")
    private String country;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("encodedId")
    private String encodedId;
    @JsonProperty("features")
    private Features features;
    @JsonProperty("friend")
    private Boolean friend;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("height")
    private Double height;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("memberSince")
    private String memberSince;
    @JsonProperty("mfaEnabled")
    private Boolean mfaEnabled;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("offsetFromUTCMillis")
    private Integer offsetFromUTCMillis;
    @JsonProperty("startDayOfWeek")
    private String startDayOfWeek;
    @JsonProperty("state")
    private String state;
    @JsonProperty("strideLengthRunning")
    private Integer strideLengthRunning;
    @JsonProperty("strideLengthWalking")
    private Integer strideLengthWalking;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("topBadges")
    private List<TopBadge> topBadges = new ArrayList<TopBadge>();
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The aboutMe
     */
    @JsonProperty("aboutMe")
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * 
     * @param aboutMe
     *     The aboutMe
     */
    @JsonProperty("aboutMe")
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
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
     *     The avatar
     */
    @JsonProperty("avatar")
    public String getAvatar() {
        return avatar;
    }

    /**
     * 
     * @param avatar
     *     The avatar
     */
    @JsonProperty("avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     * @return
     *     The avatar150
     */
    @JsonProperty("avatar150")
    public String getAvatar150() {
        return avatar150;
    }

    /**
     * 
     * @param avatar150
     *     The avatar150
     */
    @JsonProperty("avatar150")
    public void setAvatar150(String avatar150) {
        this.avatar150 = avatar150;
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
     *     The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The clockTimeDisplayFormat
     */
    @JsonProperty("clockTimeDisplayFormat")
    public String getClockTimeDisplayFormat() {
        return clockTimeDisplayFormat;
    }

    /**
     * 
     * @param clockTimeDisplayFormat
     *     The clockTimeDisplayFormat
     */
    @JsonProperty("clockTimeDisplayFormat")
    public void setClockTimeDisplayFormat(String clockTimeDisplayFormat) {
        this.clockTimeDisplayFormat = clockTimeDisplayFormat;
    }

    /**
     * 
     * @return
     *     The corporate
     */
    @JsonProperty("corporate")
    public Boolean getCorporate() {
        return corporate;
    }

    /**
     * 
     * @param corporate
     *     The corporate
     */
    @JsonProperty("corporate")
    public void setCorporate(Boolean corporate) {
        this.corporate = corporate;
    }

    /**
     * 
     * @return
     *     The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
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
     *     The displayName
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The displayName
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
     *     The features
     */
    @JsonProperty("features")
    public Features getFeatures() {
        return features;
    }

    /**
     * 
     * @param features
     *     The features
     */
    @JsonProperty("features")
    public void setFeatures(Features features) {
        this.features = features;
    }

    /**
     * 
     * @return
     *     The friend
     */
    @JsonProperty("friend")
    public Boolean getFriend() {
        return friend;
    }

    /**
     * 
     * @param friend
     *     The friend
     */
    @JsonProperty("friend")
    public void setFriend(Boolean friend) {
        this.friend = friend;
    }

    /**
     * 
     * @return
     *     The fullName
     */
    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @param fullName
     *     The fullName
     */
    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     *     The locale
     */
    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    /**
     * 
     * @param locale
     *     The locale
     */
    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * 
     * @return
     *     The memberSince
     */
    @JsonProperty("memberSince")
    public String getMemberSince() {
        return memberSince;
    }

    /**
     * 
     * @param memberSince
     *     The memberSince
     */
    @JsonProperty("memberSince")
    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    /**
     * 
     * @return
     *     The mfaEnabled
     */
    @JsonProperty("mfaEnabled")
    public Boolean getMfaEnabled() {
        return mfaEnabled;
    }

    /**
     * 
     * @param mfaEnabled
     *     The mfaEnabled
     */
    @JsonProperty("mfaEnabled")
    public void setMfaEnabled(Boolean mfaEnabled) {
        this.mfaEnabled = mfaEnabled;
    }

    /**
     * 
     * @return
     *     The nickname
     */
    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    /**
     * 
     * @param nickname
     *     The nickname
     */
    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 
     * @return
     *     The offsetFromUTCMillis
     */
    @JsonProperty("offsetFromUTCMillis")
    public Integer getOffsetFromUTCMillis() {
        return offsetFromUTCMillis;
    }

    /**
     * 
     * @param offsetFromUTCMillis
     *     The offsetFromUTCMillis
     */
    @JsonProperty("offsetFromUTCMillis")
    public void setOffsetFromUTCMillis(Integer offsetFromUTCMillis) {
        this.offsetFromUTCMillis = offsetFromUTCMillis;
    }

    /**
     * 
     * @return
     *     The startDayOfWeek
     */
    @JsonProperty("startDayOfWeek")
    public String getStartDayOfWeek() {
        return startDayOfWeek;
    }

    /**
     * 
     * @param startDayOfWeek
     *     The startDayOfWeek
     */
    @JsonProperty("startDayOfWeek")
    public void setStartDayOfWeek(String startDayOfWeek) {
        this.startDayOfWeek = startDayOfWeek;
    }

    /**
     * 
     * @return
     *     The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The strideLengthRunning
     */
    @JsonProperty("strideLengthRunning")
    public Integer getStrideLengthRunning() {
        return strideLengthRunning;
    }

    /**
     * 
     * @param strideLengthRunning
     *     The strideLengthRunning
     */
    @JsonProperty("strideLengthRunning")
    public void setStrideLengthRunning(Integer strideLengthRunning) {
        this.strideLengthRunning = strideLengthRunning;
    }

    /**
     * 
     * @return
     *     The strideLengthWalking
     */
    @JsonProperty("strideLengthWalking")
    public Integer getStrideLengthWalking() {
        return strideLengthWalking;
    }

    /**
     * 
     * @param strideLengthWalking
     *     The strideLengthWalking
     */
    @JsonProperty("strideLengthWalking")
    public void setStrideLengthWalking(Integer strideLengthWalking) {
        this.strideLengthWalking = strideLengthWalking;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
