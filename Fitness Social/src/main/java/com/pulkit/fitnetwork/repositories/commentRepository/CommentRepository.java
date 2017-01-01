package com.pulkit.fitnetwork.repositories.commentRepository;

import com.pulkit.fitnetwork.model.Newsfeed.BooleanResponse;
import com.pulkit.fitnetwork.model.Newsfeed.CommentsList;
import org.springframework.stereotype.Repository;

/**
 * Created by sid on 26-Nov-2016.
 */

@Repository
public interface CommentRepository {

    CommentsList getComments(int userid);

    BooleanResponse setComments(int id, String text, long timestamp, Long userId);
}
