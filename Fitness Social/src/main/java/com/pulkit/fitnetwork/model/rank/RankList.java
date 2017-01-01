package com.pulkit.fitnetwork.model.rank;

/**
 * Created by Pulkit on 11/29/16.
 */

import java.util.HashMap;
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
        "email",
        "name",
        "profileImageUrl",
        "rank",
        "postCount"
})
public class RankList {

    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("profileImageUrl")
    private String profileImageUrl;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("postCount")
    private Integer postCount;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The profileImageUrl
     */@JsonProperty("postCount")
    public int getPostCount() {
        return postCount;
    }

    /**
     *
     * @param postCount
     *     The postCount
     */
    @JsonProperty("postCount")
    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    /**
     *
     * @return
     *     The profileImageUrl
     */
    @JsonProperty("profileImageUrl")
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     *
     * @param profileImageUrl
     *     The profileImageUrl
     */
    @JsonProperty("profileImageUrl")
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /**
     *
     * @return
     *     The rank
     */
    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    /**
     *
     * @param rank
     *     The rank
     */
    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
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
