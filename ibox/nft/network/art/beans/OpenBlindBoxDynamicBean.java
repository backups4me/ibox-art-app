package com.ibox.nft.network.art.beans;

import java.io.Serializable;

/* loaded from: OpenBlindBoxDynamicBean.class */
public class OpenBlindBoxDynamicBean implements Serializable {
    private String albumId;
    private String url;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
