package com.pulkit.fitnetwork.model.search;

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
        "id",
        "description",
        "nfDateTime",
        "likecount",
        "usercomments",
        "username",
        "imagesUrls",
        "profileImageUrl"
})
public class Feedlist {

    @JsonProperty("id")
    private String id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("nfDateTime")
    private String nfDateTime;
    @JsonProperty("likecount")
    private int likecount;
    @JsonProperty("usercomments")
    private List<Usercomment> usercomments = new ArrayList<Usercomment>();
    @JsonProperty("username")
    private String username;
    @JsonProperty("imagesUrls")
    private List<String> imagesUrls = new ArrayList<String>();
    @JsonProperty("profileImageUrl")
    private String profileImageUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     *     The nfDateTime
     */
    @JsonProperty("nfDateTime")
    public String getNfDateTime() {
        return nfDateTime;
    }

    /**
     *
     * @param nfDateTime
     *     The nfDateTime
     */
    @JsonProperty("nfDateTime")
    public void setNfDateTime(String nfDateTime) {
        this.nfDateTime = nfDateTime;
    }

    /**
     *
     * @return
     *     The likecount
     */
    @JsonProperty("likecount")
    public int getLikecount() {
        return likecount;
    }

    /**
     *
     * @param likecount
     *     The likecount
     */
    @JsonProperty("likecount")
    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    /**
     *
     * @return
     *     The usercomments
     */
    @JsonProperty("usercomments")
    public List<Usercomment> getUsercomments() {
        return usercomments;
    }

    /**
     *
     * @param usercomments
     *     The usercomments
     */
    @JsonProperty("usercomments")
    public void setUsercomments(List<Usercomment> usercomments) {
        this.usercomments = usercomments;
    }

    /**
     *
     * @return
     *     The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     *     The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     *     The imagesUrls
     */
    @JsonProperty("imagesUrls")
    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    /**
     *
     * @param imagesUrls
     *     The imagesUrls
     */
    @JsonProperty("imagesUrls")
    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
