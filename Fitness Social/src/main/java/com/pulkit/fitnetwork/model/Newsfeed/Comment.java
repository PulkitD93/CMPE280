package com.pulkit.fitnetwork.model.Newsfeed;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sid on 26-Nov-2016.
 */

public class Comment {

    String email;
    String userName;
    String profileImageUrl;
    String text;

    public Comment() {
    }

    public Comment(String email, String userName, String profileImageUrl, String text) {
        this.email = email;
        this.userName = userName;
        this.profileImageUrl = profileImageUrl;
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}



