package com.pulkit.fitnetwork.model.suggestion;

/**
 * Created by Pulkit on 11/30/16.
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
        "suggestlist"
})
public class FriendSuggestion {

    @JsonProperty("suggestlist")
    private List<Suggestlist> suggestlist = new ArrayList<Suggestlist>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The suggestlist
     */
    @JsonProperty("suggestlist")
    public List<Suggestlist> getSuggestlist() {
        return suggestlist;
    }

    /**
     *
     * @param suggestlist
     *     The suggestlist
     */
    @JsonProperty("suggestlist")
    public void setSuggestlist(List<Suggestlist> suggestlist) {
        this.suggestlist = suggestlist;
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