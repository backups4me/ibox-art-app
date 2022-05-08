package com.ibox.nft.network.base.api.bean;

import java.io.Serializable;

/* loaded from: IBoxBannerBean.class */
public class IBoxBannerBean implements Serializable {
    private int bannerType;
    private String contentId;
    private int contentType;
    private String pic;
    private String sortNum;
    private String subtitle;
    private String title;
    private String url;

    public int getBannerType() {
        return this.bannerType;
    }

    public String getContentId() {
        return this.contentId;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getPic() {
        return this.pic;
    }

    public String getSortNum() {
        return this.sortNum;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBannerType(int i) {
        this.bannerType = i;
    }

    public void setContentId(String str) {
        this.contentId = str;
    }

    public void setContentType(int i) {
        this.contentType = i;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setSortNum(String str) {
        this.sortNum = str;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
