package com.pulkit.fitnetwork.model.Newsfeed;

import java.util.List;

/**
 * Created by sid on 05-Dec-2016.
 */
public class NewsfeedList {
    public List<Newsfeed> getNewsfeed() {
        return newsfeed;
    }

    public void setNewsfeed(List<Newsfeed> newsfeed) {
        this.newsfeed = newsfeed;
    }

    public int getNewsFeedEntries() {
        return newsFeedEntries;
    }

    public void setNewsFeedEntries(int newsFeedEntries) {
        this.newsFeedEntries = newsFeedEntries;
    }

    List<Newsfeed> newsfeed;
    int newsFeedEntries;
}
