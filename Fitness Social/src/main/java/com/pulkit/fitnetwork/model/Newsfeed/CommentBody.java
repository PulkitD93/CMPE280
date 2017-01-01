package com.pulkit.fitnetwork.model.Newsfeed;

/**
 * Created by Pulkit on 12/4/16.
 */
public class CommentBody {
    private long timestamp;
    private String description;

    public CommentBody(long timestamp, String description) {
        this.timestamp = timestamp;
        this.description = description;
    }

    public CommentBody() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
