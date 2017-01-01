package com.pulkit.fitnetwork.repositories.rankRepository;

/**
 * Created by Pulkit on 11/29/16.
 */
import com.pulkit.fitnetwork.model.rank.RankList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pulkit on 11/27/16.
 */
@Repository
public interface RankRepository {

    public List<RankList> getRank();
}