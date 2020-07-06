
package com.demo.news.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@Entity(tableName = "article")
@Parcel
public class Article   {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("abstract")
    private String mAbstract;
    @SerializedName("byline")
    private String mByline;
    @SerializedName("created_date")
    private String mCreatedDate;
    @SerializedName("des_facet")
    @Ignore
    private List<String> mDesFacet;
    @SerializedName("geo_facet")
    @Ignore
    private List<String> mGeoFacet;
    @SerializedName("item_type")
    private String mItemType;
    @SerializedName("kicker")
    private String mKicker;
    @SerializedName("material_type_facet")
    private String mMaterialTypeFacet;
    @SerializedName("multimedia")
    @Ignore
    private List<Multimedium> mMultimedia;
    private String mImageUrl;
    @SerializedName("org_facet")
    @Ignore
    private List<String> mOrgFacet;
    @SerializedName("per_facet")
    @Ignore
    private List<String> mPerFacet;
    @SerializedName("published_date")
    private String mPublishedDate;
    @SerializedName("section")
    private String mSection;
    @SerializedName("short_url")
    private String mShortUrl;
    @SerializedName("subsection")
    private String mSubsection;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("updated_date")
    private String mUpdatedDate;
    @SerializedName("url")
    private String mUrl;

    public String getAbstract() {
        return mAbstract;
    }

    public void setAbstract(String mAbstract) {
        this.mAbstract = mAbstract;
    }

    public String getByline() {
        return mByline;
    }

    public void setByline(String byline) {
        mByline = byline;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        mCreatedDate = createdDate;
    }

    public List<String> getDesFacet() {
        return mDesFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        mDesFacet = desFacet;
    }

    public List<String> getGeoFacet() {
        return mGeoFacet;
    }

    public void setGeoFacet(List<String> geoFacet) {
        mGeoFacet = geoFacet;
    }

    public String getItemType() {
        return mItemType;
    }

    public void setItemType(String itemType) {
        mItemType = itemType;
    }

    public String getKicker() {
        return mKicker;
    }

    public void setKicker(String kicker) {
        mKicker = kicker;
    }

    public String getMaterialTypeFacet() {
        return mMaterialTypeFacet;
    }

    public void setMaterialTypeFacet(String materialTypeFacet) {
        mMaterialTypeFacet = materialTypeFacet;
    }

    public List<Multimedium> getMultimedia() {
        return mMultimedia;
    }

    public void setMultimedia(List<Multimedium> multimedia) {
        mMultimedia = multimedia;
    }

    public String getImageUrl() {
        if (mMultimedia != null && mMultimedia.size() > 0) {
            Multimedium lastMultimedium = mMultimedia.get(mMultimedia.size() - 1);
            mImageUrl = lastMultimedium.getUrl();
        }
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public List<String> getOrgFacet() {
        return mOrgFacet;
    }

    public void setOrgFacet(List<String> orgFacet) {
        mOrgFacet = orgFacet;
    }

    public List<String> getPerFacet() {
        return mPerFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        mPerFacet = perFacet;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        mPublishedDate = publishedDate;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public String getShortUrl() {
        return mShortUrl;
    }

    public void setShortUrl(String shortUrl) {
        mShortUrl = shortUrl;
    }

    public String getSubsection() {
        return mSubsection;
    }

    public void setSubsection(String subsection) {
        mSubsection = subsection;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUpdatedDate() {
        return mUpdatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        mUpdatedDate = updatedDate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int uid) {
        this.id = uid;
    }
}
