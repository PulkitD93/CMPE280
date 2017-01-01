package com.pulkit.fitnetwork.model.Trigger;

/**
 * Created by Shikher on 20-Nov-16.
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
            "age",
            "avatar",
            "avatar150",
            "averageDailySteps",
            "clockTimeDisplayFormat",
            "corporate",
            "corporateAdmin",
            "dateOfBirth",
            "displayName",
            "displayNameSetting",
            "distanceUnit",
            "encodedId",
            "features",
            "foodsLocale",
            "fullName",
            "gender",
            "glucoseUnit",
            "height",
            "heightUnit",
            "locale",
            "memberSince",
            "mfaEnabled",
            "offsetFromUTCMillis",
            "startDayOfWeek",
            "strideLengthRunning",
            "strideLengthRunningType",
            "strideLengthWalking",
            "strideLengthWalkingType",
            "swimUnit",
            "timezone",
            "topBadges",
            "waterUnit",
            "waterUnitName",
            "weight",
            "weightUnit"
    })
    public class User {

        @JsonProperty("age")
        private Integer age;
        @JsonProperty("avatar")
        private String avatar;
        @JsonProperty("avatar150")
        private String avatar150;
        @JsonProperty("averageDailySteps")
        private Integer averageDailySteps;
        @JsonProperty("clockTimeDisplayFormat")
        private String clockTimeDisplayFormat;
        @JsonProperty("corporate")
        private Boolean corporate;
        @JsonProperty("corporateAdmin")
        private Boolean corporateAdmin;
        @JsonProperty("dateOfBirth")
        private String dateOfBirth;
        @JsonProperty("displayName")
        private String displayName;
        @JsonProperty("displayNameSetting")
        private String displayNameSetting;
        @JsonProperty("distanceUnit")
        private String distanceUnit;
        @JsonProperty("encodedId")
        private String encodedId;
        @JsonProperty("features")
        private Features features;
        @JsonProperty("foodsLocale")
        private String foodsLocale;
        @JsonProperty("fullName")
        private String fullName;
        @JsonProperty("gender")
        private String gender;
        @JsonProperty("glucoseUnit")
        private String glucoseUnit;
        @JsonProperty("height")
        private Double height;
        @JsonProperty("heightUnit")
        private String heightUnit;
        @JsonProperty("locale")
        private String locale;
        @JsonProperty("memberSince")
        private String memberSince;
        @JsonProperty("mfaEnabled")
        private Boolean mfaEnabled;
        @JsonProperty("offsetFromUTCMillis")
        private Integer offsetFromUTCMillis;
        @JsonProperty("startDayOfWeek")
        private String startDayOfWeek;
        @JsonProperty("strideLengthRunning")
        private Double strideLengthRunning;
        @JsonProperty("strideLengthRunningType")
        private String strideLengthRunningType;
        @JsonProperty("strideLengthWalking")
        private Double strideLengthWalking;
        @JsonProperty("strideLengthWalkingType")
        private String strideLengthWalkingType;
        @JsonProperty("swimUnit")
        private String swimUnit;
        @JsonProperty("timezone")
        private String timezone;
        @JsonProperty("topBadges")
        private List<TopBadge> topBadges = new ArrayList<TopBadge>();
        @JsonProperty("waterUnit")
        private String waterUnit;
        @JsonProperty("waterUnitName")
        private String waterUnitName;
        @JsonProperty("weight")
        private Double weight;
        @JsonProperty("weightUnit")
        private String weightUnit;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         *
         * @return
         * The age
         */
        @JsonProperty("age")
        public Integer getAge() {
            return age;
        }

        /**
         *
         * @param age
         * The age
         */
        @JsonProperty("age")
        public void setAge(Integer age) {
            this.age = age;
        }

        /**
         *
         * @return
         * The avatar
         */
        @JsonProperty("avatar")
        public String getAvatar() {
            return avatar;
        }

        /**
         *
         * @param avatar
         * The avatar
         */
        @JsonProperty("avatar")
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        /**
         *
         * @return
         * The avatar150
         */
        @JsonProperty("avatar150")
        public String getAvatar150() {
            return avatar150;
        }

        /**
         *
         * @param avatar150
         * The avatar150
         */
        @JsonProperty("avatar150")
        public void setAvatar150(String avatar150) {
            this.avatar150 = avatar150;
        }

        /**
         *
         * @return
         * The averageDailySteps
         */
        @JsonProperty("averageDailySteps")
        public Integer getAverageDailySteps() {
            return averageDailySteps;
        }

        /**
         *
         * @param averageDailySteps
         * The averageDailySteps
         */
        @JsonProperty("averageDailySteps")
        public void setAverageDailySteps(Integer averageDailySteps) {
            this.averageDailySteps = averageDailySteps;
        }

        /**
         *
         * @return
         * The clockTimeDisplayFormat
         */
        @JsonProperty("clockTimeDisplayFormat")
        public String getClockTimeDisplayFormat() {
            return clockTimeDisplayFormat;
        }

        /**
         *
         * @param clockTimeDisplayFormat
         * The clockTimeDisplayFormat
         */
        @JsonProperty("clockTimeDisplayFormat")
        public void setClockTimeDisplayFormat(String clockTimeDisplayFormat) {
            this.clockTimeDisplayFormat = clockTimeDisplayFormat;
        }

        /**
         *
         * @return
         * The corporate
         */
        @JsonProperty("corporate")
        public Boolean getCorporate() {
            return corporate;
        }

        /**
         *
         * @param corporate
         * The corporate
         */
        @JsonProperty("corporate")
        public void setCorporate(Boolean corporate) {
            this.corporate = corporate;
        }

        /**
         *
         * @return
         * The corporateAdmin
         */
        @JsonProperty("corporateAdmin")
        public Boolean getCorporateAdmin() {
            return corporateAdmin;
        }

        /**
         *
         * @param corporateAdmin
         * The corporateAdmin
         */
        @JsonProperty("corporateAdmin")
        public void setCorporateAdmin(Boolean corporateAdmin) {
            this.corporateAdmin = corporateAdmin;
        }

        /**
         *
         * @return
         * The dateOfBirth
         */
        @JsonProperty("dateOfBirth")
        public String getDateOfBirth() {
            return dateOfBirth;
        }

        /**
         *
         * @param dateOfBirth
         * The dateOfBirth
         */
        @JsonProperty("dateOfBirth")
        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        /**
         *
         * @return
         * The displayName
         */
        @JsonProperty("displayName")
        public String getDisplayName() {
            return displayName;
        }

        /**
         *
         * @param displayName
         * The displayName
         */
        @JsonProperty("displayName")
        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        /**
         *
         * @return
         * The displayNameSetting
         */
        @JsonProperty("displayNameSetting")
        public String getDisplayNameSetting() {
            return displayNameSetting;
        }

        /**
         *
         * @param displayNameSetting
         * The displayNameSetting
         */
        @JsonProperty("displayNameSetting")
        public void setDisplayNameSetting(String displayNameSetting) {
            this.displayNameSetting = displayNameSetting;
        }

        /**
         *
         * @return
         * The distanceUnit
         */
        @JsonProperty("distanceUnit")
        public String getDistanceUnit() {
            return distanceUnit;
        }

        /**
         *
         * @param distanceUnit
         * The distanceUnit
         */
        @JsonProperty("distanceUnit")
        public void setDistanceUnit(String distanceUnit) {
            this.distanceUnit = distanceUnit;
        }

        /**
         *
         * @return
         * The encodedId
         */
        @JsonProperty("encodedId")
        public String getEncodedId() {
            return encodedId;
        }

        /**
         *
         * @param encodedId
         * The encodedId
         */
        @JsonProperty("encodedId")
        public void setEncodedId(String encodedId) {
            this.encodedId = encodedId;
        }

        /**
         *
         * @return
         * The features
         */
        @JsonProperty("features")
        public Features getFeatures() {
            return features;
        }

        /**
         *
         * @param features
         * The features
         */
        @JsonProperty("features")
        public void setFeatures(Features features) {
            this.features = features;
        }

        /**
         *
         * @return
         * The foodsLocale
         */
        @JsonProperty("foodsLocale")
        public String getFoodsLocale() {
            return foodsLocale;
        }

        /**
         *
         * @param foodsLocale
         * The foodsLocale
         */
        @JsonProperty("foodsLocale")
        public void setFoodsLocale(String foodsLocale) {
            this.foodsLocale = foodsLocale;
        }

        /**
         *
         * @return
         * The fullName
         */
        @JsonProperty("fullName")
        public String getFullName() {
            return fullName;
        }

        /**
         *
         * @param fullName
         * The fullName
         */
        @JsonProperty("fullName")
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        /**
         *
         * @return
         * The gender
         */
        @JsonProperty("gender")
        public String getGender() {
            return gender;
        }

        /**
         *
         * @param gender
         * The gender
         */
        @JsonProperty("gender")
        public void setGender(String gender) {
            this.gender = gender;
        }

        /**
         *
         * @return
         * The glucoseUnit
         */
        @JsonProperty("glucoseUnit")
        public String getGlucoseUnit() {
            return glucoseUnit;
        }

        /**
         *
         * @param glucoseUnit
         * The glucoseUnit
         */
        @JsonProperty("glucoseUnit")
        public void setGlucoseUnit(String glucoseUnit) {
            this.glucoseUnit = glucoseUnit;
        }

        /**
         *
         * @return
         * The height
         */
        @JsonProperty("height")
        public Double getHeight() {
            return height;
        }

        /**
         *
         * @param height
         * The height
         */
        @JsonProperty("height")
        public void setHeight(Double height) {
            this.height = height;
        }

        /**
         *
         * @return
         * The heightUnit
         */
        @JsonProperty("heightUnit")
        public String getHeightUnit() {
            return heightUnit;
        }

        /**
         *
         * @param heightUnit
         * The heightUnit
         */
        @JsonProperty("heightUnit")
        public void setHeightUnit(String heightUnit) {
            this.heightUnit = heightUnit;
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
         * The memberSince
         */
        @JsonProperty("memberSince")
        public String getMemberSince() {
            return memberSince;
        }

        /**
         *
         * @param memberSince
         * The memberSince
         */
        @JsonProperty("memberSince")
        public void setMemberSince(String memberSince) {
            this.memberSince = memberSince;
        }

        /**
         *
         * @return
         * The mfaEnabled
         */
        @JsonProperty("mfaEnabled")
        public Boolean getMfaEnabled() {
            return mfaEnabled;
        }

        /**
         *
         * @param mfaEnabled
         * The mfaEnabled
         */
        @JsonProperty("mfaEnabled")
        public void setMfaEnabled(Boolean mfaEnabled) {
            this.mfaEnabled = mfaEnabled;
        }

        /**
         *
         * @return
         * The offsetFromUTCMillis
         */
        @JsonProperty("offsetFromUTCMillis")
        public Integer getOffsetFromUTCMillis() {
            return offsetFromUTCMillis;
        }

        /**
         *
         * @param offsetFromUTCMillis
         * The offsetFromUTCMillis
         */
        @JsonProperty("offsetFromUTCMillis")
        public void setOffsetFromUTCMillis(Integer offsetFromUTCMillis) {
            this.offsetFromUTCMillis = offsetFromUTCMillis;
        }

        /**
         *
         * @return
         * The startDayOfWeek
         */
        @JsonProperty("startDayOfWeek")
        public String getStartDayOfWeek() {
            return startDayOfWeek;
        }

        /**
         *
         * @param startDayOfWeek
         * The startDayOfWeek
         */
        @JsonProperty("startDayOfWeek")
        public void setStartDayOfWeek(String startDayOfWeek) {
            this.startDayOfWeek = startDayOfWeek;
        }

        /**
         *
         * @return
         * The strideLengthRunning
         */
        @JsonProperty("strideLengthRunning")
        public Double getStrideLengthRunning() {
            return strideLengthRunning;
        }

        /**
         *
         * @param strideLengthRunning
         * The strideLengthRunning
         */
        @JsonProperty("strideLengthRunning")
        public void setStrideLengthRunning(Double strideLengthRunning) {
            this.strideLengthRunning = strideLengthRunning;
        }

        /**
         *
         * @return
         * The strideLengthRunningType
         */
        @JsonProperty("strideLengthRunningType")
        public String getStrideLengthRunningType() {
            return strideLengthRunningType;
        }

        /**
         *
         * @param strideLengthRunningType
         * The strideLengthRunningType
         */
        @JsonProperty("strideLengthRunningType")
        public void setStrideLengthRunningType(String strideLengthRunningType) {
            this.strideLengthRunningType = strideLengthRunningType;
        }

        /**
         *
         * @return
         * The strideLengthWalking
         */
        @JsonProperty("strideLengthWalking")
        public Double getStrideLengthWalking() {
            return strideLengthWalking;
        }

        /**
         *
         * @param strideLengthWalking
         * The strideLengthWalking
         */
        @JsonProperty("strideLengthWalking")
        public void setStrideLengthWalking(Double strideLengthWalking) {
            this.strideLengthWalking = strideLengthWalking;
        }

        /**
         *
         * @return
         * The strideLengthWalkingType
         */
        @JsonProperty("strideLengthWalkingType")
        public String getStrideLengthWalkingType() {
            return strideLengthWalkingType;
        }

        /**
         *
         * @param strideLengthWalkingType
         * The strideLengthWalkingType
         */
        @JsonProperty("strideLengthWalkingType")
        public void setStrideLengthWalkingType(String strideLengthWalkingType) {
            this.strideLengthWalkingType = strideLengthWalkingType;
        }

        /**
         *
         * @return
         * The swimUnit
         */
        @JsonProperty("swimUnit")
        public String getSwimUnit() {
            return swimUnit;
        }

        /**
         *
         * @param swimUnit
         * The swimUnit
         */
        @JsonProperty("swimUnit")
        public void setSwimUnit(String swimUnit) {
            this.swimUnit = swimUnit;
        }

        /**
         *
         * @return
         * The timezone
         */
        @JsonProperty("timezone")
        public String getTimezone() {
            return timezone;
        }

        /**
         *
         * @param timezone
         * The timezone
         */
        @JsonProperty("timezone")
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        /**
         *
         * @return
         * The topBadges
         */
        @JsonProperty("topBadges")
        public List<TopBadge> getTopBadges() {
            return topBadges;
        }

        /**
         *
         * @param topBadges
         * The topBadges
         */
        @JsonProperty("topBadges")
        public void setTopBadges(List<TopBadge> topBadges) {
            this.topBadges = topBadges;
        }

        /**
         *
         * @return
         * The waterUnit
         */
        @JsonProperty("waterUnit")
        public String getWaterUnit() {
            return waterUnit;
        }

        /**
         *
         * @param waterUnit
         * The waterUnit
         */
        @JsonProperty("waterUnit")
        public void setWaterUnit(String waterUnit) {
            this.waterUnit = waterUnit;
        }

        /**
         *
         * @return
         * The waterUnitName
         */
        @JsonProperty("waterUnitName")
        public String getWaterUnitName() {
            return waterUnitName;
        }

        /**
         *
         * @param waterUnitName
         * The waterUnitName
         */
        @JsonProperty("waterUnitName")
        public void setWaterUnitName(String waterUnitName) {
            this.waterUnitName = waterUnitName;
        }

        /**
         *
         * @return
         * The weight
         */
        @JsonProperty("weight")
        public Double getWeight() {
            return weight;
        }

        /**
         *
         * @param weight
         * The weight
         */
        @JsonProperty("weight")
        public void setWeight(Double weight) {
            this.weight = weight;
        }

        /**
         *
         * @return
         * The weightUnit
         */
        @JsonProperty("weightUnit")
        public String getWeightUnit() {
            return weightUnit;
        }

        /**
         *
         * @param weightUnit
         * The weightUnit
         */
        @JsonProperty("weightUnit")
        public void setWeightUnit(String weightUnit) {
            this.weightUnit = weightUnit;
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




