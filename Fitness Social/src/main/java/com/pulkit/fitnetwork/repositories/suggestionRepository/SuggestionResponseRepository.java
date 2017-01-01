package com.pulkit.fitnetwork.repositories.suggestionRepository;

import com.pulkit.fitnetwork.model.suggestion.FriendSuggestion;
import org.springframework.stereotype.Repository;

/**
 * Created by Pulkit on 11/30/16.
 */
@Repository
public interface SuggestionResponseRepository {
    FriendSuggestion getFriendSug(long userid);
}
