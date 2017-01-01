package com.pulkit.fitnetwork.model;

/**
 * Created by Shikher on 20-Nov-16.
 */
public class User {

    private Long userId;
    private String usertype;
    private String userToken;
    private String Street;
    private String Apartment;
    private String City;
    private String State;
    private Long zip;
    private Double latitude;
    private Double longitude;
    private String gender;
    private String email;
    private String firstName;
    private String lastName;
    private String userpassword;
    private Double height;
    private Integer age;
    private Integer loginCount;
    private String fitbitUserID;
    private String fitbitToken;
    private Long fitbitTokenDuration;
    private String profileImageUrl;
    private Integer rank;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getApartment() {
        return Apartment;
    }

    public void setApartment(String apartment) {
        Apartment = apartment;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getFitbitUserID() {
        return fitbitUserID;
    }

    public void setFitbitUserID(String fitbitUserID) {
        this.fitbitUserID = fitbitUserID;
    }

    public String getFitbitToken() {
        return fitbitToken;
    }

    public void setFitbitToken(String fitbitToken) {
        this.fitbitToken = fitbitToken;
    }

    public Long getFitbitTokenDuration() {
        return fitbitTokenDuration;
    }

    public void setFitbitTokenDuration(Long fitbitTokenDuration) {
        this.fitbitTokenDuration = fitbitTokenDuration;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
