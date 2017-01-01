package com.pulkit.fitnetwork.model.dashboard;

/**
 * Created by sid on 29-Nov-2016.
 */
public class TopBadge {


    private String badgeType;

    private String category;

    private String dateTime;

    private String description;

    private String image;

    private Integer value;

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}