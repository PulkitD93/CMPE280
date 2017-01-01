package com.pulkit.fitnetwork.model.search;

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
        "userlist",
        "feedlist"
})
public class SearchResponse {

    @JsonProperty("userlist")
    private List<Userlist> userlist = new ArrayList<Userlist>();
    @JsonProperty("feedlist")
    private List<Feedlist> feedlist = new ArrayList<Feedlist>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public SearchResponse(){

    }
    public SearchResponse(List<Feedlist> feedlist, List<Userlist> userlist){
        this.userlist=userlist;
        this.feedlist=feedlist;
    }
    /**
     *
     * @return
     *     The userlist
     */
    @JsonProperty("userlist")
    public List<Userlist> getUserlist() {
        return userlist;
    }

    /**
     *
     * @param userlist
     *     The userlist
     */
    @JsonProperty("userlist")
    public void setUserlist(List<Userlist> userlist) {
        this.userlist = userlist;
    }

    /**
     *
     * @return
     *     The feedlist
     */
    @JsonProperty("feedlist")
    public List<Feedlist> getFeedlist() {
        return feedlist;
    }

    /**
     *
     * @param feedlist
     *     The feedlist
     */
    @JsonProperty("feedlist")
    public void setFeedlist(List<Feedlist> feedlist) {
        this.feedlist = feedlist;
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
