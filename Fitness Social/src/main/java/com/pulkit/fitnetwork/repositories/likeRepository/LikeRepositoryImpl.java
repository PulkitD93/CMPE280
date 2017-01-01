package com.pulkit.fitnetwork.repositories.likeRepository;


import com.pulkit.fitnetwork.model.Newsfeed.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sid on 26-Nov-2016.
 */

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    private JdbcOperations jdbcOperations;
    private String setLikeOperation = "insert into likes (userId , id ) VALUES (?,?)";
    private String getLikeCountQuery = "select distinct count(userId) from likes where id = ?";
    private String setUnlikeOperation = "delete from likes where userId = ? and id = ?";
    private String getLikeEmailList = "select distinct email from user A inner join likes B\n" +
            "on A.userId = B.userId where B.id = ?";
    private String likeBoolean = "select count(userId) from likes where id = ? and userId = ?";

    @Autowired
    public LikeRepositoryImpl(JdbcOperations jdbcOperations){this.jdbcOperations = jdbcOperations;}

    @Override
    public Like setLikeStatus(int id , long userid) {

        int Result = jdbcOperations.update(setLikeOperation,userid,id);
        Like likeStatus = new Like();
        List<String> listEmail = new ArrayList<String>();
        listEmail = jdbcOperations.queryForList(getLikeEmailList,String.class,id);
        Integer likeCount = jdbcOperations.queryForObject(getLikeCountQuery,Integer.class,id);

        if(Result == 1) {
            likeStatus.setLikestatus(true);
            likeStatus.setLikeCount(likeCount);
            likeStatus.setEmailList(listEmail);
        }
        else
        {
            likeStatus.setLikestatus(false);
            likeStatus.setLikeCount(likeCount);
            likeStatus.setEmailList(listEmail);
        }

        return likeStatus;
    }


    @Override
    public Like setUnlikeStatus(int id , long userid) {

        int UnlikeResult = jdbcOperations.update(setUnlikeOperation,userid,id);
        Integer likecount = jdbcOperations.queryForObject(getLikeCountQuery,Integer.class,id);
        Like unlikeStatus = new Like();
        List<String> listEmail = new ArrayList<String>();
        listEmail = jdbcOperations.queryForList(getLikeEmailList,String.class,id);

        if(UnlikeResult == 1) {
            unlikeStatus.setLikestatus(true);
            unlikeStatus.setLikeCount(likecount);
            unlikeStatus.setEmailList(listEmail);
        }
        else
        {
            unlikeStatus.setLikestatus(false);
            unlikeStatus.setLikeCount(likecount);
            unlikeStatus.setEmailList(listEmail);
        }

        return unlikeStatus;
    }

    @Override
    public Like getLikeList(int id, long userid) {

        Integer islikeStatus = jdbcOperations.queryForObject(likeBoolean,Integer.class,id,userid);
        Integer likecount = jdbcOperations.queryForObject(getLikeCountQuery,Integer.class,id);
        Like getLikeStatus = new Like();
        List<String> listEmail = new ArrayList<String>();
        listEmail = jdbcOperations.queryForList(getLikeEmailList,String.class,id);

        if(islikeStatus == 1) {
            getLikeStatus.setLikestatus(true);
            getLikeStatus.setLikeCount(likecount);
            getLikeStatus.setEmailList(listEmail);
        }
        else
        {
            getLikeStatus.setLikestatus(false);
            getLikeStatus.setLikeCount(likecount);
            getLikeStatus.setEmailList(listEmail);
        }

        return getLikeStatus;

    }

}
