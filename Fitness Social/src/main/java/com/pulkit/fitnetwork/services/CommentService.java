package com.pulkit.fitnetwork.services;

import com.pulkit.fitnetwork.model.Newsfeed.BooleanResponse;
import com.pulkit.fitnetwork.model.Newsfeed.CommentsList;
import com.pulkit.fitnetwork.repositories.commentRepository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sid on 26-Nov-2016.
 */

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public CommentsList getComments(int id){
        return commentRepository.getComments(id);
    }

    public BooleanResponse setComments(int id, String text , long timestamp,Long userId){
        return commentRepository.setComments(id , text , timestamp, userId);
    }

}
