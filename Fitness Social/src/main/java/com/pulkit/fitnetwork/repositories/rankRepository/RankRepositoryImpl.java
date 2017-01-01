package com.pulkit.fitnetwork.repositories.rankRepository;

import com.pulkit.fitnetwork.model.rank.RankList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pulkit on 11/29/16.
 */
@Repository
public class RankRepositoryImpl implements RankRepository {
    private JdbcOperations jdbcOperations;
    private List<RankList> rankResponse;
    private String getRankString="select\n" +
            "      @rownum := @rownum +1 as rank,\n" +
            "      prequery.userId,\n" +
            "      prequery.email,\n" +
            "      prequery.PostCount,\n" +
            "      prequery.name\n" +
            "   from\n" +
            "      ( select @rownum := 0 ) sqlvars,\n" +
            "      ( SELECT newsfeed.userId, user.email, count(newsfeed.id) postCount, concat(user.firstName,\" \", user.lastName) as name\n" +
            "           from newsfeed inner join user\n" +
            "           on newsfeed.userId=user.userId           \n" +
            "           group by newsfeed.userId\n" +
            "           order by count(newsfeed.id) desc ) prequery";
    @Autowired
    public RankRepositoryImpl(JdbcOperations jdbcOperations){ this.jdbcOperations=jdbcOperations;}
    @Override
    public List<RankList> getRank() {
        rankResponse=jdbcOperations.query(getRankString,new BeanPropertyRowMapper<RankList>(RankList.class));
        return rankResponse;
    }
}
