package com.pulkit.fitnetwork.repositories.searchRepository;

/**
 * Created by Pulkit on 11/29/16.
 */
import com.pulkit.fitnetwork.model.search.SearchResponse;
import org.springframework.stereotype.Repository;

/**
 * Created by Pulkit on 11/27/16.
 */
@Repository
public interface SearchResultRepository {

    public SearchResponse searchAll(Long userId, String input);
}

