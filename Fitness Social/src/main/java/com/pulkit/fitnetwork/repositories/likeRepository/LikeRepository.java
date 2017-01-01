package com.pulkit.fitnetwork.repositories.likeRepository;

import com.pulkit.fitnetwork.model.Newsfeed.Like;
import org.springframework.stereotype.Repository;

/**
 * Created by sid on 26-Nov-2016.
 */


@Repository
public interface LikeRepository {

    Like setLikeStatus (int id , long userid);
    Like setUnlikeStatus (int id , long userid);
    Like getLikeList (int id , long userid);

}