package com.pulkit.fitnetwork.model.request;

/**
 * Created by shikh on 27-Nov-16.
 */
public class SignupRequest {

    private String usertype;
    private double latitude;
    private double longitude;
    private String gender;
    private String email;
    private String firstName;
    private String lastName;
    private String userpassword;
    private String fitbitUserID;
    private String fitbitToken;
    private long fitbitTokenDuration;

    public SignupRequest() {
    }

    public SignupRequest(String usertype, double latitude, double longitude, String gender, String email, String firstName, String lastName, String userpassword, String fitbitUserID, String fitbitToken, long fitbitTokenDuration) {
        this.usertype = usertype;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gender = gender;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userpassword = userpassword;
        this.fitbitUserID = fitbitUserID;
        this.fitbitToken = fitbitToken;
        this.fitbitTokenDuration = fitbitTokenDuration;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
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

    public long getFitbitTokenDuration() {
        return fitbitTokenDuration;
    }

    public void setFitbitTokenDuration(long fitbitTokenDuration) {
        this.fitbitTokenDuration = fitbitTokenDuration;
    }
}
