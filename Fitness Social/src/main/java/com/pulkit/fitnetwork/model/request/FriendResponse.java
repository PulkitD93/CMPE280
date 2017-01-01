package com.pulkit.fitnetwork.model.request;

/**
 * Created by ruchit on 11/29/16.
 */
public class FriendResponse {
    Long userId;

    String email;
    String firstname;
    String profileImageUrl;
    String lastname;

    public FriendResponse() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public FriendResponse(String email, String firstname, String profileImageUrl, String lastname, Long userId) {
        this.email = email;
        this.firstname = firstname;

        this.profileImageUrl = profileImageUrl;
        this.lastname = lastname;

        this.userId=userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
