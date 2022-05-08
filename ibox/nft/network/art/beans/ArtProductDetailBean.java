package com.ibox.nft.network.art.beans;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

/* loaded from: ArtProductDetailBean.class */
public class ArtProductDetailBean implements Serializable {
    @JSONField(name = "albumId")
    private String albumId;
    @JSONField(name = "albumName")
    private String albumName;
    @JSONField(name = "authorHeadImage")
    private String authorHeadImage;
    @JSONField(name = "authorId")
    private String authorId;
    @JSONField(name = "authorName")
    private String authorName;
    @JSONField(name = "authorSocialInfo")
    private String authorSocialInfo;
    @JSONField(name = "authorWalletInfo")
    private String authorWalletInfo;
    @JSONField(name = "brandDesc")
    private String brandDesc;
    @JSONField(name = "brandId")
    private String brandId;
    @JSONField(name = "brandName")
    private String brandName;
    @JSONField(name = "contractAddress")
    private String contractAddress;
    @JSONField(name = "gDesc")
    private String gDesc;
    @JSONField(name = "gFeatures")
    private List<?> gFeatures;
    @JSONField(name = "gId")
    private String gId;
    @JSONField(name = "gName")
    private String gName;
    @JSONField(name = "gNum")
    private String gNum;
    @JSONField(name = "gUrls")
    private List<GUrlsDTO> gUrls;
    @JSONField(name = "isBuy")
    private int isBuy;
    @JSONField(name = "onSale")
    private int onSale;
    @JSONField(name = "onSaleTime")
    private long onSaleTime;
    @JSONField(name = "orderId")
    private String orderId;
    @JSONField(name = "orderStatus")
    private String orderStatus;
    @JSONField(name = "origin")
    private String origin;
    @JSONField(name = "ownerAvatar")
    private String ownerAvatar;
    @JSONField(name = "ownerId")
    private int ownerId;
    @JSONField(name = "ownerName")
    private String ownerName;
    @JSONField(name = "ownerSocialInfo")
    private String ownerSocialInfo;
    @JSONField(name = "ownerWalletInfo")
    private String ownerWalletInfo;
    @JSONField(name = "price")
    @Deprecated
    private String price;
    @JSONField(name = "priceCny")
    private String priceCny;
    @JSONField(name = "priceUnit")
    private String priceUnit;
    @JSONField(name = "resell")
    private int resell;
    @JSONField(name = "sellLimit")
    private int sellLimit;
    @JSONField(name = "sellType")
    private int sellType;
    @JSONField(name = "thumbPic")
    private String thumbPic;
    @JSONField(name = "thumbPic2")
    private String thumbPic2;
    @JSONField(name = "tokenAddress")
    private String tokenAddress;
    @JSONField(name = "tokenId")
    private String tokenId;
    @JSONField(name = "vFlag")
    private int vFlag;

    /* loaded from: ArtProductDetailBean$GUrlsDTO.class */
    public static class GUrlsDTO implements Serializable {
        @JSONField(name = "height")
        private int height;
        @JSONField(name = "size")
        private int size;
        @JSONField(name = "type")
        private String type;
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "width")
        private int width;

        public int getHeight() {
            return this.height;
        }

        public int getSize() {
            return this.size;
        }

        public String getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public void setSize(int i) {
            this.size = i;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWidth(int i) {
            this.width = i;
        }

        public String toString() {
            return "GUrlsDTO{height=" + this.height + ", size=" + this.size + ", type='" + this.type + "', url='" + this.url + "', width=" + this.width + '}';
        }
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public String getAuthorHeadImage() {
        return this.authorHeadImage;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getAuthorSocialInfo() {
        return this.authorSocialInfo;
    }

    public String getAuthorWalletInfo() {
        return this.authorWalletInfo;
    }

    public String getBrandDesc() {
        return this.brandDesc;
    }

    public String getBrandId() {
        return this.brandId;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getContractAddress() {
        return this.contractAddress;
    }

    public int getIsBuy() {
        return this.isBuy;
    }

    public int getOnSale() {
        return this.onSale;
    }

    public long getOnSaleTime() {
        return this.onSaleTime;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getOwnerAvatar() {
        return this.ownerAvatar;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getOwnerSocialInfo() {
        return this.ownerSocialInfo;
    }

    public String getOwnerWalletInfo() {
        return this.ownerWalletInfo;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPriceCny() {
        return this.priceCny;
    }

    public String getPriceUnit() {
        return this.priceUnit;
    }

    public int getResell() {
        return this.resell;
    }

    public int getSellLimit() {
        return this.sellLimit;
    }

    public int getSellType() {
        return this.sellType;
    }

    public String getThumbPic() {
        return this.thumbPic;
    }

    public String getThumbPic2() {
        return this.thumbPic2;
    }

    public String getTokenAddress() {
        return this.tokenAddress;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public String getgDesc() {
        return this.gDesc;
    }

    public List<?> getgFeatures() {
        return this.gFeatures;
    }

    public String getgId() {
        return this.gId;
    }

    public String getgName() {
        return this.gName;
    }

    public String getgNum() {
        return this.gNum;
    }

    public List<GUrlsDTO> getgUrls() {
        return this.gUrls;
    }

    public int getvFlag() {
        return this.vFlag;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setAuthorHeadImage(String str) {
        this.authorHeadImage = str;
    }

    public void setAuthorId(String str) {
        this.authorId = str;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setAuthorSocialInfo(String str) {
        this.authorSocialInfo = str;
    }

    public void setAuthorWalletInfo(String str) {
        this.authorWalletInfo = str;
    }

    public void setBrandDesc(String str) {
        this.brandDesc = str;
    }

    public void setBrandId(String str) {
        this.brandId = str;
    }

    public void setBrandName(String str) {
        this.brandName = str;
    }

    public void setContractAddress(String str) {
        this.contractAddress = str;
    }

    public void setIsBuy(int i) {
        this.isBuy = i;
    }

    public void setOnSale(int i) {
        this.onSale = i;
    }

    public void setOnSaleTime(long j) {
        this.onSaleTime = j;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setOwnerAvatar(String str) {
        this.ownerAvatar = str;
    }

    public void setOwnerId(int i) {
        this.ownerId = i;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public void setOwnerSocialInfo(String str) {
        this.ownerSocialInfo = str;
    }

    public void setOwnerWalletInfo(String str) {
        this.ownerWalletInfo = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPriceCny(String str) {
        this.priceCny = str;
    }

    public void setPriceUnit(String str) {
        this.priceUnit = str;
    }

    public void setResell(int i) {
        this.resell = i;
    }

    public void setSellLimit(int i) {
        this.sellLimit = i;
    }

    public void setSellType(int i) {
        this.sellType = i;
    }

    public void setThumbPic(String str) {
        this.thumbPic = str;
    }

    public void setThumbPic2(String str) {
        this.thumbPic2 = str;
    }

    public void setTokenAddress(String str) {
        this.tokenAddress = str;
    }

    public void setTokenId(String str) {
        this.tokenId = str;
    }

    public void setgDesc(String str) {
        this.gDesc = str;
    }

    public void setgFeatures(List<?> list) {
        this.gFeatures = list;
    }

    public void setgId(String str) {
        this.gId = str;
    }

    public void setgName(String str) {
        this.gName = str;
    }

    public void setgNum(String str) {
        this.gNum = str;
    }

    public void setgUrls(List<GUrlsDTO> list) {
        this.gUrls = list;
    }

    public void setvFlag(int i) {
        this.vFlag = i;
    }

    public String toString() {
        return "ArtProductDetailBean{albumId=" + this.albumId + ", albumName='" + this.albumName + "', authorHeadImage='" + this.authorHeadImage + "', authorId=" + this.authorId + ", authorName='" + this.authorName + "', authorSocialInfo='" + this.authorSocialInfo + "', authorWalletInfo='" + this.authorWalletInfo + "', brandDesc='" + this.brandDesc + "', brandId=" + this.brandId + ", brandName='" + this.brandName + "', contractAddress='" + this.contractAddress + "', gDesc='" + this.gDesc + "', gFeatures=" + this.gFeatures + ", gId=" + this.gId + ", gName='" + this.gName + "', gNum='" + this.gNum + "', gUrls=" + this.gUrls + ", isBuy=" + this.isBuy + ", onSale=" + this.onSale + ", onSaleTime=" + this.onSaleTime + ", orderId='" + this.orderId + "', orderStatus='" + this.orderStatus + "', ownerAvatar='" + this.ownerAvatar + "', ownerId=" + this.ownerId + ", ownerName='" + this.ownerName + "', ownerSocialInfo='" + this.ownerSocialInfo + "', ownerWalletInfo='" + this.ownerWalletInfo + "', price='" + this.price + "', priceCny='" + this.priceCny + "', priceUnit='" + this.priceUnit + "', resell=" + this.resell + ", sellLimit=" + this.sellLimit + ", sellType=" + this.sellType + ", thumbPic='" + this.thumbPic + "', thumbPic2='" + this.thumbPic2 + "', tokenAddress='" + this.tokenAddress + "', tokenId='" + this.tokenId + "', vFlag=" + this.vFlag + ", origin=" + this.origin + '}';
    }
}
