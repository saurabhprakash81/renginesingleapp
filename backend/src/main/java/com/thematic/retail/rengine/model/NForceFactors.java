package com.thematic.retail.rengine.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "recordId",
        "forceId",
        "forceName",
        "forceFactorId",
        "forceFactorName",
        "forceFactorWeight",
        "render"
})
public class NForceFactors {

    @JsonProperty("recordId")
    private Integer recordId;
    @JsonProperty("forceId")
    private Integer forceId;
    @JsonProperty("forceName")
    private String forceName;
    @JsonProperty("forceFactorId")
    private Integer forceFactorId;
    @JsonProperty("forceFactorName")
    private String forceFactorName;
    @JsonProperty("forceFactorWeight")
    private Integer forceFactorWeight;
    @JsonProperty("render")
    private Boolean render;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("recordId")
    public Integer getRecordId() {
        return recordId;
    }

    @JsonProperty("recordId")
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @JsonProperty("forceId")
    public Integer getForceId() {
        return forceId;
    }

    @JsonProperty("forceId")
    public void setForceId(Integer forceId) {
        this.forceId = forceId;
    }

    @JsonProperty("forceName")
    public String getForceName() {
        return forceName;
    }

    @JsonProperty("forceName")
    public void setForceName(String forceName) {
        this.forceName = forceName;
    }

    @JsonProperty("forceFactorId")
    public Integer getForceFactorId() {
        return forceFactorId;
    }

    @JsonProperty("forceFactorId")
    public void setForceFactorId(Integer forceFactorId) {
        this.forceFactorId = forceFactorId;
    }

    @JsonProperty("forceFactorName")
    public String getForceFactorName() {
        return forceFactorName;
    }

    @JsonProperty("forceFactorName")
    public void setForceFactorName(String forceFactorName) {
        this.forceFactorName = forceFactorName;
    }

    @JsonProperty("forceFactorWeight")
    public Integer getForceFactorWeight() {
        return forceFactorWeight;
    }

    @JsonProperty("forceFactorWeight")
    public void setForceFactorWeight(Integer forceFactorWeight) {
        this.forceFactorWeight = forceFactorWeight;
    }

    @JsonProperty("render")
    public Boolean getRender() {
        return render;
    }

    @JsonProperty("render")
    public void setRender(Boolean render) {
        this.render = render;
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
