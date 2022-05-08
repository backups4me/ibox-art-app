package com.ibox.nft.base.jsbridge;

import java.io.Serializable;

/* loaded from: BasicJsBridgeDataBean.class */
public class BasicJsBridgeDataBean<T> implements Serializable {
    private String action;
    private String callback;
    private String code;
    private T data;
    private String msg;

    public String getAction() {
        return this.action;
    }

    public String getCallback() {
        return this.callback;
    }

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setCallback(String str) {
        this.callback = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "BasicJsBridgeDataBean{action='" + this.action + "', callback='" + this.callback + "', code='" + this.code + "', msg='" + this.msg + "', data=" + this.data + '}';
    }
}
