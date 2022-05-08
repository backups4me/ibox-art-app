package com.ibox.nft.network.account.bean;

import java.io.Serializable;

/* loaded from: PersonInfoBean.class */
public class PersonInfoBean implements Serializable {
    private String buyNum;
    private String creatorlNum;
    private String headImage;
    private String introduction;
    private String sellNum;
    private String socialPlatform;
    private String uid;
    private String userName;
    private String walletAddress;
    private int walletType;

    public String getBuyNum() {
        return this.buyNum;
    }

    public String getCreatorlNum() {
        return this.creatorlNum;
    }

    public String getHeadImage() {
        return this.headImage;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public String getSellNum() {
        return this.sellNum;
    }

    public String getSocialPlatform() {
        return this.socialPlatform;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWalletAddress() {
        return this.walletAddress;
    }

    public int getWalletType() {
        return this.walletType;
    }

    public void setBuyNum(String str) {
        this.buyNum = str;
    }

    public void setCreatorlNum(String str) {
        this.creatorlNum = str;
    }

    public void setHeadImage(String str) {
        this.headImage = str;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setSellNum(String str) {
        this.sellNum = str;
    }

    public void setSocialPlatform(String str) {
        this.socialPlatform = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setWalletAddress(String str) {
        this.walletAddress = str;
    }

    public void setWalletType(int i) {
        this.walletType = i;
    }
}
