package com.pulkit.fitnetwork.repositories;

import com.pulkit.fitnetwork.model.suggestion.FriendSuggestion;
import com.pulkit.fitnetwork.model.suggestion.Suggestlist;
import com.pulkit.fitnetwork.model.friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * Please be careful while doing modifications to all friends file Its codeby RUCHIT
 * Created by Ruchit on 11/22/16.
 */
@Repository
public class FriendRepository {
    private JdbcOperations jdbcOperations;


    @Autowired
    public FriendRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    public void insert(friend f) {
        System.out.println("indside friend dao sql quer" + f.getStatus() + f.getUserId() + f.getFriendUserId());

        String sql = "INSERT INTO friend " +
                "(status,userId, friendUserId) VALUES (?, ?, ?)";

        try {
            jdbcOperations.update(sql, new Object[]{f.getStatus().toString(), f.getUserId(), f.getFriendUserId()
            });
        } catch (Exception e) {
            System.out.println("errpr" + e);
        } finally {

            System.out.println("finally");
        }
    }

/*
    public List<friend> getAllFriends(long friendUserId) {

        System.out.println("isnide friend request sent repository");
        String sql = "select * from friend where friendUserId = ? and status='requestSent'";
        List<friend> friends = jdbcOperations.query(sql, new BeanPropertyRowMapper<>(friend.class), friendUserId);
        System.out.println("isnide friend request sent repository afer");
        return friends;
    }*/


    public FriendSuggestion getAllFriends(long userId) {

        String sql = "select user.email,concat(user.firstName,' ',user.lastName) as name, user.profileImageUrl from user where userId in (select userId from friend where friendUserId = ? and status='requestSent')";
        List<Suggestlist> suggestlist = jdbcOperations.query(sql,new BeanPropertyRowMapper<>(Suggestlist.class),userId);
        FriendSuggestion friendSuggestion =new FriendSuggestion();
        friendSuggestion.setSuggestlist(suggestlist);
        return friendSuggestion;
    }


    public void confirmFriendRequest(long userid, long friendUserId) {
        String sql = "UPDATE friend set status=? where userid=? and friendUserId=?  and  status=? ";

        jdbcOperations.update(sql, new Object[]{"friend", userid, friendUserId, "requestSent"});

    }

    public void rejectFriendRequest(long userid, long friendUserId) {

        String sql = "DELETE from friend where userid=? and friendUserId=? and status=? ";

        jdbcOperations.update(sql, new Object[]{userid, friendUserId, "requestSent"});

    }


    public FriendSuggestion showAllFriends(long userId) {

        System.out.println("isnide showAllFriends request sent repository");
        String sql = "select user.email,concat(user.firstName,' ',user.lastName) as name, user.profileImageUrl from user where userId in (select userid  from friend where friendUserId = ? and status='friend' UNION select friendUserId from friend where userid = ? and status='friend' )";
        List<Suggestlist> suggestlist = jdbcOperations.query(sql,new BeanPropertyRowMapper<>(Suggestlist.class),userId,userId);
        FriendSuggestion friendSuggestion =new FriendSuggestion();
        friendSuggestion.setSuggestlist(suggestlist);
        return friendSuggestion;
    }
}