package com.ibox.nft.network.base.api.bean;

import com.igexin.push.core.c;
import java.io.Serializable;

/* loaded from: IBoxVersionInfo.class */
public class IBoxVersionInfo implements Serializable {
    private String desc;
    private String downUrl;
    private int isEffective;
    private String verCode;
    private String verUpdate;

    public String getDesc() {
        return this.desc;
    }

    public String getDownUrl() {
        return this.downUrl;
    }

    public int getIsEffective() {
        return this.isEffective;
    }

    public String getVerCode() {
        return this.verCode;
    }

    public String getVerUpdate() {
        return this.verUpdate;
    }

    public boolean isForcedUpdate() {
        return c.f613e.equals(this.verUpdate);
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDownUrl(String str) {
        this.downUrl = str;
    }

    public void setIsEffective(int i) {
        this.isEffective = i;
    }

    public void setVerCode(String str) {
        this.verCode = str;
    }

    public void setVerUpdate(String str) {
        this.verUpdate = str;
    }
}
