package com.ibox.nft.network.base.api.bean;

import java.io.Serializable;

/* loaded from: CustomTabItemBean.class */
public class CustomTabItemBean implements Serializable {
    private int tabId;
    private String tabName;

    public CustomTabItemBean(int i, String str) {
        this.tabId = i;
        this.tabName = str;
    }

    public int getTabId() {
        return this.tabId;
    }

    public String getTabName() {
        return this.tabName;
    }

    public void setTabId(int i) {
        this.tabId = i;
    }

    public void setTabName(String str) {
        this.tabName = str;
    }
}
