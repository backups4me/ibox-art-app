package com.ibox.nft.network.base.api.bean;

import java.io.Serializable;

/* loaded from: RecommendInfoBean.class */
public class RecommendInfoBean implements Serializable {
    private String classifyName;
    private String contentId;
    private int contentType;
    private String id;
    private String pic;
    private int recommendType;
    private int sortNum;
    private String title;
    private String url;

    public RecommendInfoBean() {
    }

    public RecommendInfoBean(String str, String str2, String str3) {
        this.contentId = str;
        this.title = str2;
        this.classifyName = str3;
    }

    public String getClassifyName() {
        return this.classifyName;
    }

    public String getContentId() {
        return this.contentId;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getId() {
        return this.id;
    }

    public String getPic() {
        return this.pic;
    }

    public int getRecommendType() {
        return this.recommendType;
    }

    public int getSortNum() {
        return this.sortNum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setClassifyName(String str) {
        this.classifyName = str;
    }

    public void setContentId(String str) {
        this.contentId = str;
    }

    public void setContentType(int i) {
        this.contentType = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setRecommendType(int i) {
        this.recommendType = i;
    }

    public void setSortNum(int i) {
        this.sortNum = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
