package com.pulkit.fitnetwork.repositories.newsfeedRepository;

import com.pulkit.fitnetwork.model.Newsfeed.Newsfeed;
import com.pulkit.fitnetwork.model.Newsfeed.NewsfeedList;
import com.pulkit.fitnetwork.model.Newsfeed.Usercomment;
import com.pulkit.fitnetwork.model.request.FriendResponse;
import com.pulkit.fitnetwork.model.suggestion.Suggestlist;
import com.pulkit.fitnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sid on 26-Nov-2016.
 */

@Repository
public class NewsfeedRepositoryImpl implements NewsfeedRepository {

    @Autowired
    UserService userService;

    private JdbcOperations jdbcOperations;

    private String userCommentsQuery = "select C.email , concat(C.firstName,\" \",C.lastName) as userName , C.profileImageUrl , D.text from newsfeed A\n" +
            "            inner join comment D on A.id = D.id\n" +
            "            inner join user C on C.userId = D. userId where A.id = ? ORDER BY D.commentTime ASC";


    private String getNewsfeedQueryByUser = "select A.id, A.Description, A.nfDateTime , count(B.userId) as likecount , C.profileImageUrl , concat(C.firstName,\" \",C.lastName) as username\n" +
            "from newsfeed A\n" +
            "left outer join likes B on  A.id = B.id\n" +
            "inner join user C on C.userId = A.userId and A.userId = ? GROUP BY  A.id\n" +
            "ORDER BY A.id DESC\n";

    private String getNewsfeedImagesQuery = "select imageUrl from newsfeedimages where id = ?";

    private String getNewsfeedCountQuery = "select count(*) as count from newsfeed where userId = ?";



    @Autowired
    public NewsfeedRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public NewsfeedList getNewsfeed(List<Suggestlist> friends, int pagenumber) {

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("(");

        for (int i = 0; i < friends.size(); i++) {
            long userId = userService.getCurrentUserIdByEmail(friends.get(i).getEmail());
            stringBuilder.append(String.valueOf(userId));
            if (i != friends.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        String getNewsfeedQuery = "select A.id, A.Description, A.nfDateTime , count(B.userId) as likecount , C.profileImageUrl , concat(C.firstName,\" \",C.lastName) as username\n" +
                "from newsfeed A\n" +
                "left outer join likes B on  A.id = B.id\n" +
                "inner join user C on C.userId = A.userId and A.userId in " + stringBuilder.toString() + " GROUP BY  A.id\n" +
                "ORDER BY A.id DESC LIMIT ?,? \n";

        String getNewsfeedCountQuery = "select count(*) as count from newsfeed where userId in " + stringBuilder.toString() + ";";


        int newsFeedCount = 0;
        int fetchSize = 5;

        List<Newsfeed> res = new ArrayList<Newsfeed>();
        NewsfeedList list = new NewsfeedList();
        List<Newsfeed> newsfeeditems = jdbcOperations.query(getNewsfeedQuery, new Object[]{((pagenumber - 1) * 5), fetchSize},
                new BeanPropertyRowMapper<Newsfeed>(Newsfeed.class));
        newsFeedCount = jdbcOperations.queryForObject(getNewsfeedCountQuery, Integer.class);

        for (Newsfeed rs : newsfeeditems) {
            Newsfeed n = new Newsfeed();
            n.setId(rs.getId());
            List<String> imageURLs = jdbcOperations.queryForList(getNewsfeedImagesQuery, new Object[]{rs.getId()}, String.class);
            n.setImagesUrls(imageURLs);
            List<Usercomment> uc = jdbcOperations.query(userCommentsQuery,
                    new BeanPropertyRowMapper<>(Usercomment.class), rs.getId());
            n.setDescription(rs.getDescription());
            n.setNfDateTime(rs.getNfDateTime());
            n.setLikecount(rs.getLikecount());
            n.setProfileImageUrl(rs.getProfileImageUrl());
            n.setUsername(rs.getUsername());
            n.setUsercomments(uc);
            res.add(n);
            list.setNewsfeed(res);
        }
        list.setNewsFeedEntries(newsFeedCount);
        return list;
    }

    @Override
    public NewsfeedList getNewsfeedByUser(List<FriendResponse> friends) {

        List<Newsfeed> res = new ArrayList<Newsfeed>();
        NewsfeedList list = new NewsfeedList();
        int newsFeedCount = 0;
        for (int i = 0; i < friends.size(); i++) {
            List<Newsfeed> newsfeeditems = jdbcOperations.query(getNewsfeedQueryByUser, new Object[]{friends.get(i).getUserId()},
                    new BeanPropertyRowMapper<Newsfeed>(Newsfeed.class));
            newsFeedCount += jdbcOperations.queryForObject(getNewsfeedCountQuery, Integer.class, friends.get(i).getUserId());
            for (Newsfeed rs : newsfeeditems) {
                Newsfeed n = new Newsfeed();
                n.setId(rs.getId());
                Long newsfeedID = rs.getId();
                List<String> imageURLs = jdbcOperations.queryForList(getNewsfeedImagesQuery, new Object[]{rs.getId()}, String.class);
                n.setImagesUrls(imageURLs);
                List<Usercomment> uc = jdbcOperations.query(userCommentsQuery,
                        new BeanPropertyRowMapper<>(Usercomment.class), rs.getId());
                n.setDescription(rs.getDescription());
                n.setNfDateTime(rs.getNfDateTime());
                n.setLikecount(rs.getLikecount());
                n.setProfileImageUrl(rs.getProfileImageUrl());
                n.setUsername(rs.getUsername());
                n.setUsercomments(uc);
                res.add(n);
            }

            list.setNewsfeed(res);

        }
        list.setNewsFeedEntries(newsFeedCount);
        return list;
    }
}
