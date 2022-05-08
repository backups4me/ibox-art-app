package com.ibox.nft.base.jsbridge.beans;

import java.io.Serializable;
import java.util.List;

/* loaded from: JsSaleResultBean.class */
public class JsSaleResultBean<T> implements Serializable {
    private int code;
    private T data;

    /* loaded from: JsSaleResultBean$BlindBoxDataBean.class */
    public static class BlindBoxDataBean implements Serializable {
        private List<String> gIds;
        private int num;
        private String orderIds;

        public int getNum() {
            return this.num;
        }

        public String getOrderIds() {
            return this.orderIds;
        }

        public List<String> getgIds() {
            return this.gIds;
        }

        public void setNum(int i) {
            this.num = i;
        }

        public void setOrderIds(String str) {
            this.orderIds = str;
        }

        public void setgIds(List<String> list) {
            this.gIds = list;
        }
    }

    /* loaded from: JsSaleResultBean$ProductDataBean.class */
    public static class ProductDataBean implements Serializable {
        private String orderId;

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }
}
