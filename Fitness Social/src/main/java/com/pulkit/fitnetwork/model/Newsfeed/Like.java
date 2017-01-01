package com.pulkit.fitnetwork.model.Newsfeed;

import java.util.List;

/**
 * Created by sid on 24-Nov-2016.
 */
public class Like {

    private int likeCount;
    private boolean likestatus;
    public List<String> emailList;

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isLikestatus() {
        return likestatus;
    }

    public void setLikestatus(boolean likestatus) {
        this.likestatus = likestatus;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }
}
