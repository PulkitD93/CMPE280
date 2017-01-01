package com.pulkit.fitnetwork.model;

/**
 * Created by shikh on 27-Nov-16.
 */
public class Result {

    private String message;

    public Result() {
    }

    public Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
