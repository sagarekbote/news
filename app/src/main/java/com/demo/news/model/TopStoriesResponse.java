
package com.demo.news.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

/**
* TopStoriesResponse model
 */
@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TopStoriesResponse {

    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("last_updated")
    private String mLastUpdated;
    @SerializedName("num_results")
    private Long mNumResults;
    @SerializedName("results")
    private List<Article> mArticles;
    @SerializedName("section")
    private String mSection;
    @SerializedName("status")
    private String mStatus;

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public Long getNumResults() {
        return mNumResults;
    }

    public void setNumResults(Long numResults) {
        mNumResults = numResults;
    }

    public List<Article> getResults() {
        return mArticles;
    }

    public void setResults(List<Article> articles) {
        mArticles = articles;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
