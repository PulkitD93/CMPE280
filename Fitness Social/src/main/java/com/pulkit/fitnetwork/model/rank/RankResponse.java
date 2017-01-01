package com.pulkit.fitnetwork.model.rank;

/**
 * Created by Pulkit on 11/29/16.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "rankList"
})
public class RankResponse {

    @JsonProperty("rankList")
    private List<RankList> rankList = new ArrayList<RankList>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The rankList
     */
    @JsonProperty("rankList")
    public List<RankList> getRankList() {
        return rankList;
    }

    /**
     *
     * @param rankList
     *     The rankList
     */
    @JsonProperty("rankList")
    public void setRankList(List<RankList> rankList) {
        this.rankList = rankList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}