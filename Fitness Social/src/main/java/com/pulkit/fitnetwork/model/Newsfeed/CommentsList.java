package com.pulkit.fitnetwork.model.Newsfeed;

import java.util.List;

/**
 * Created by shikh on 08-Dec-16.
 */
public class CommentsList {

    private List<Comment> commentsList;

    public CommentsList() {
    }

    public CommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }
}
