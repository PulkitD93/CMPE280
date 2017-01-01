package com.pulkit.fitnetwork.repositories.suggestionRepository;

import com.pulkit.fitnetwork.model.suggestion.FriendSuggestion;
import com.pulkit.fitnetwork.model.suggestion.Suggestlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pulkit on 11/30/16.
 */
@Repository
public class SuggestionResponseRepositoryImpl implements SuggestionResponseRepository {
    private JdbcOperations jdbcOperations;
    private String getSugguestionQuery="Select user.email,concat(user.firstName,' ',user.lastName) as name, user.profileImageUrl from user, friend where user.userId not in (select userId from friend where friendUserId=? union all select frienduserId as userId from friend where userId=?) and user.userId!=? group by user.userId;";

    @Autowired
    public SuggestionResponseRepositoryImpl(JdbcOperations jdbcOperations){ this.jdbcOperations=jdbcOperations;}

    @Override
    public FriendSuggestion getFriendSug(long userid) {
        List<Suggestlist> suggestlist = jdbcOperations.query(getSugguestionQuery,new BeanPropertyRowMapper<>(Suggestlist.class),userid,userid,userid);
        FriendSuggestion friendSuggestion =new FriendSuggestion();
        friendSuggestion.setSuggestlist(suggestlist);
        return friendSuggestion;
    }
}
