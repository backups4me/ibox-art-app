package com.ibox.nft.network.account.bean;

import java.io.Serializable;

/* loaded from: CheckTokenInfoBean.class */
public class CheckTokenInfoBean implements Serializable {
    private int res;
    private String uid;

    public int getRes() {
        return this.res;
    }

    public String getUid() {
        return this.uid;
    }

    public void setRes(int i) {
        this.res = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
