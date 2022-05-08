package com.ibox.nft.network.base.api.bean;

import java.io.Serializable;

/* loaded from: IBoxNoticeInfoBean.class */
public class IBoxNoticeInfoBean implements Serializable {
    private String noticeName;
    private String noticeUrl;

    public String getNoticeName() {
        return this.noticeName;
    }

    public String getNoticeUrl() {
        return this.noticeUrl;
    }

    public void setNoticeName(String str) {
        this.noticeName = str;
    }

    public void setNoticeUrl(String str) {
        this.noticeUrl = str;
    }
}
