package com.pulkit.fitnetwork.repositories.searchRepository;

/**
 * Created by Pulkit on 11/29/16.
 */

import com.pulkit.fitnetwork.model.search.SearchResponse;
import com.pulkit.fitnetwork.model.search.Userlist;
import com.pulkit.fitnetwork.model.search.Feedlist;
import com.pulkit.fitnetwork.model.search.Usercomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pulkit on 11/27/16.
 */
@Repository
public class SearchResultRepositoryImpl implements SearchResultRepository {
    private JdbcOperations jdbcOperations;
    private JdbcTemplate jdbcTemplate;


    private SearchResponse searchResponse;

    private String getAllUsersQuery = "select concat(firstName,' ', lastName) as name, email, profileImageUrl \n" +
            "from user where concat(firstName,' ', lastName) like ?";

    private String userCommentsQuery = "select C.email , concat(C.firstName,' ',C.lastName) as name , C.profileImageUrl , D.text as comment from newsfeed A " +
            "inner join comment D on A.id = D.id " +
            "inner join user C on C.userId = D. userId where A.id = ? ORDER BY D.commentTime ASC";

    private String getNewsfeedQuery = "select A.id, A.Description, A.nfDateTime , count(B.userId) as likecount , concat(C.firstName,' ',C.lastName) as username,C.profileImageUrl \n" +
            "from newsfeed A left outer join likes B on  A.id = B.id \n" +
            "inner join user C on C.userId = A.userId where A.Description like ? GROUP BY  A.id\n";

    private String isFriendsQuery = "select count(*) from friend where status = 'friend' and userId = ?  or friendUserID = ?\n" +
            "and userId in (select userId from user where email = ?)\n" +
            "or friendUserID in (select userId from user where email = ?)\n";


    @Autowired
    public SearchResultRepositoryImpl(JdbcOperations jdbcOperations, JdbcTemplate jdbcTemplate) {
        this.jdbcOperations = jdbcOperations;
        this.jdbcTemplate = jdbcTemplate;
    }

    public SearchResponse searchAll(Long userId, String input) {
        String patternString = "%" + input + "%";
        List<Userlist> userlist = jdbcOperations.query(getAllUsersQuery, new BeanPropertyRowMapper<Userlist>(Userlist.class), patternString);
        System.out.println("Query : " + getAllUsersQuery);
//        List<Feedlist> newsFeedResult=jdbcOperations.query(getAllNewsFeedQuery,new BeanPropertyRowMapper<Feedlist>(Feedlist.class),patternString);

        for (int i = 0; i < userlist.size(); i++) {
            String email = userlist.get(i).getEmail();
            Integer isFriend = jdbcOperations.queryForObject(isFriendsQuery, Integer.class, userId, userId, email, email);

            if (isFriend == 1)
                userlist.get(i).setFriend(true);
            else
                userlist.get(i).setFriend(false);
        }

        List<Feedlist> newsFeedResult = jdbcOperations.query(getNewsfeedQuery, new Object[]{patternString}, new BeanPropertyRowMapper<Feedlist>(Feedlist.class) {
            public Feedlist mapRow(ResultSet rs, int rownumber) throws SQLException {

                System.out.println("Query : " + getNewsfeedQuery);
                System.out.println("Username :" + rs.getString(5));
                System.out.println("Profile Image URL :" + rs.getString(6));

                Feedlist f = new Feedlist();
                f.setId(rs.getString(1));
                List<Usercomment> uc = jdbcOperations.query(userCommentsQuery, new BeanPropertyRowMapper<Usercomment>(Usercomment.class), rs.getString(1));
                String imageUrlQuery = "select imageUrl from newsfeedimages where id =";
                List<String> imageUrls = (List<String>) jdbcTemplate.queryForList(imageUrlQuery + rs.getString(1), String.class);
                f.setDescription(rs.getString(2));
                f.setNfDateTime(rs.getString(3));
                f.setLikecount(rs.getInt(4));
                f.setUsername(rs.getString(5));
                f.setUsercomments(uc);
                f.setImagesUrls(imageUrls);
                f.setProfileImageUrl(rs.getString(6));
                return f;

            }
        });
        searchResponse = new SearchResponse(newsFeedResult, userlist);//not using Spring, find a better way loosely couple it.
        return searchResponse;
    }
}