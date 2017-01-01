package com.pulkit.fitnetwork.model.Newsfeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sid on 26-Nov-2016.
 */

public class Newsfeed {

    private long id;
    private String Description;
    private String nfDateTime;
    private int likecount;
    private String profileImageUrl;
    private List<Usercomment> usercomments = new ArrayList<Usercomment>();
    private String username;
    private List<String> imagesUrls = new ArrayList<String>();

    public Newsfeed() {
    }

    public Newsfeed(long id, String description, String nfDateTime, int likecount, String profileImageUrl, List<Usercomment> usercomments, String username, List<String> imagesUrls) {
        this.id = id;
        Description = description;
        this.nfDateTime = nfDateTime;
        this.likecount = likecount;
        this.profileImageUrl = profileImageUrl;
        this.usercomments = usercomments;
        this.username = username;
        this.imagesUrls = imagesUrls;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getNfDateTime() {
        return nfDateTime;
    }

    public void setNfDateTime(String nfDateTime) {
        this.nfDateTime = nfDateTime;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public List<Usercomment> getUsercomments() {
        return usercomments;
    }

    public void setUsercomments(List<Usercomment> usercomments) {
        this.usercomments = usercomments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }
}
