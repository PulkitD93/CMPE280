package com.pulkit.fitnetwork.model;

/**
 *
 * Please be careful while doing modifications to all friends file Its codeby RUCHIT
 * Created by Ruchit on 11/22/16.
 */

public class friend {
    private long userId;
    private long friendUserId;
    private String status;

    public friend() {
    }

    public friend(long userId, long friendUserId, String status) {

        this.userId = userId;
        this.friendUserId = friendUserId;
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFriendUserId() {
        return friendUserId;
    }

    public void setFriendUserId(long friendUserId) {
        this.friendUserId = friendUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



