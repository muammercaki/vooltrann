package com.voltran.model;


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
        "getPageCount",
        "page",
        "pageSize",
        "sortBy",
        "descending"
})
public class AcountUserList {

    @JsonProperty("getPageCount")
    private Boolean getPageCount;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("sortBy")
    private String sortBy;
    @JsonProperty("descending")
    private Boolean descending;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("getPageCount")
    public Boolean getGetPageCount() {
        return getPageCount;
    }

    @JsonProperty("getPageCount")
    public void setGetPageCount(Boolean getPageCount) {
        this.getPageCount = getPageCount;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("pageSize")
    public Integer getPageSize() {
        return pageSize;
    }

    @JsonProperty("pageSize")
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("sortBy")
    public String getSortBy() {
        return sortBy;
    }

    @JsonProperty("sortBy")
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @JsonProperty("descending")
    public Boolean getDescending() {
        return descending;
    }

    @JsonProperty("descending")
    public void setDescending(Boolean descending) {
        this.descending = descending;
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