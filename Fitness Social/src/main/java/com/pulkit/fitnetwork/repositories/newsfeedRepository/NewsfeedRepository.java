package com.pulkit.fitnetwork.repositories.newsfeedRepository;


import com.pulkit.fitnetwork.model.Newsfeed.NewsfeedList;
import com.pulkit.fitnetwork.model.request.FriendResponse;
import com.pulkit.fitnetwork.model.suggestion.Suggestlist;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sid on 26-Nov-2016.
 */

@Repository
public interface NewsfeedRepository {

    NewsfeedList getNewsfeed(List<Suggestlist> friends, int pagenumber);

    NewsfeedList getNewsfeedByUser(List<FriendResponse> friends);

}
