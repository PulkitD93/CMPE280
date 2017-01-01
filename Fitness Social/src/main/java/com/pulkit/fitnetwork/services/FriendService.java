package com.pulkit.fitnetwork.services;

import com.pulkit.fitnetwork.model.suggestion.FriendSuggestion;
import com.pulkit.fitnetwork.model.friend;
import com.pulkit.fitnetwork.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Please be careful while doing modifications to all friends file Its codeby RUCHIT
 * Created by Ruchit on 11/22/16.
 */
@Service
public class FriendService {


    @Autowired
    FriendRepository friendRepository;


    public void insert(friend f){
        friendRepository.insert(f);
    }


    // show aall friend request
    public FriendSuggestion getAllFriends(long userid)
    {
        return friendRepository.getAllFriends(userid);
    }

    public void confirmFriendRequest(long userid, long friendUserId){
        friendRepository.confirmFriendRequest(userid, friendUserId);
    }
    public void rejectFriendRequest(long userid, long friendUserId)
    {
        friendRepository.rejectFriendRequest(userid,friendUserId);
    }


    public FriendSuggestion showAllFriends(long userid) {
        return friendRepository.showAllFriends(userid);
    }
}
