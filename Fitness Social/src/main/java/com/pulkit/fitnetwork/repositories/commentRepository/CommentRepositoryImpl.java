package com.pulkit.fitnetwork.repositories.commentRepository;

import com.pulkit.fitnetwork.model.Newsfeed.BooleanResponse;
import com.pulkit.fitnetwork.model.Newsfeed.Comment;
import com.pulkit.fitnetwork.model.Newsfeed.CommentsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sid on 26-Nov-2016.
 */

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private JdbcOperations jdbcOperations;
    private String getComments = "select user.email,concat(user.firstName,\" \",user.lastName) as userName,user.profileImageUrl,comment.text " +
            "from comment,user where user.userId = comment.userId and id = ? order by commentTime ASC";
    private String putComments = "insert into comment(text,commentTime,userId,id) values (?,?,?,?)";

    @Autowired
    public CommentRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public CommentsList getComments(int id) {
        List<Comment> commentsList = jdbcOperations.query(getComments,
                new BeanPropertyRowMapper<>(Comment.class),
                id);

        CommentsList commentsListIns = new CommentsList();
        commentsListIns.setCommentsList(commentsList);
        return commentsListIns;
    }

    @Override
    public BooleanResponse setComments(int id, String text, long timestamp, Long userId) {
        Date date = new Date(timestamp);
        Format format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        System.out.println(format.format(date));
        int Result = jdbcOperations.update(putComments, text, format.format(date), userId, id);

        BooleanResponse b = new BooleanResponse();
        if (Result == 1)
            b.setResult(true);
        else b.setResult(false);

        return b;

    }
}
