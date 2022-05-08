package com.ibox.nft.network.art.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.igexin.push.core.c;
import java.io.Serializable;
import java.util.List;

/* loaded from: BlindBoxDetailBean.class */
public class BlindBoxDetailBean implements Serializable {
    @JSONField(name = "animated")
    private boolean animated;
    @JSONField(name = "appDynamicId")
    private String appDynamicId;
    @JSONField(name = "buyBlindCount")
    private int buyBlindCount;
    @JSONField(name = "coverPic")
    private String coverPic;
    @JSONField(name = "detailsPic")
    private String detailsPic;
    @JSONField(name = "drawNum")
    private int drawNum;
    @JSONField(name = "drawPrice")
    private String drawPrice;
    @JSONField(name = "dynamicId")
    private int dynamicId;
    @JSONField(name = "gId")
    private String gId;
    @JSONField(name = c.z)
    private String id;
    @JSONField(name = "isOwner")
    private int isOwner;
    @JSONField(name = "label")
    private int label;
    @JSONField(name = "list")
    private List<?> list;
    @JSONField(name = com.alipay.sdk.cons.c.f218e)
    private String name;
    @JSONField(name = "onSale")
    private int onSale;
    @JSONField(name = "onSaleTime")
    private long onSaleTime;
    @JSONField(name = "onePrice")
    private double onePrice;
    @JSONField(name = "orderPic")
    private String orderPic;
    @JSONField(name = "origin")
    private String origin;
    @JSONField(name = "ownerAvatar")
    private String ownerAvatar;
    @JSONField(name = "ownerName")
    private String ownerName;
    @JSONField(name = "price")
    private String price;
    @JSONField(name = "resell")
    private int resell;
    @JSONField(name = "reserve")
    private int reserve;
    @JSONField(name = "rule")
    private String rule;
    @JSONField(name = "saleWay")
    private int saleWay;
    @JSONField(name = "sellNum")
    private int sellNum;
    @JSONField(name = "soldOutNum")
    private int soldOutNum;
    @JSONField(name = "subOnSale")
    private int subOnSale;
    @JSONField(name = "thumbPic")
    private String thumbPic;
    @JSONField(name = "type")
    private int type;
    @JSONField(name = "unsoldNum")
    private int unsoldNum;

    public boolean canEqual(Object obj) {
        return obj instanceof BlindBoxDetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlindBoxDetailBean)) {
            return false;
        }
        BlindBoxDetailBean blindBoxDetailBean = (BlindBoxDetailBean) obj;
        if (!blindBoxDetailBean.canEqual(this) || getDrawNum() != blindBoxDetailBean.getDrawNum() || getDynamicId() != blindBoxDetailBean.getDynamicId() || getIsOwner() != blindBoxDetailBean.getIsOwner() || getOnSale() != blindBoxDetailBean.getOnSale() || getOnSaleTime() != blindBoxDetailBean.getOnSaleTime() || Double.compare(getOnePrice(), blindBoxDetailBean.getOnePrice()) != 0 || getReserve() != blindBoxDetailBean.getReserve() || getSaleWay() != blindBoxDetailBean.getSaleWay() || getSellNum() != blindBoxDetailBean.getSellNum() || getSoldOutNum() != blindBoxDetailBean.getSoldOutNum() || getSubOnSale() != blindBoxDetailBean.getSubOnSale() || getType() != blindBoxDetailBean.getType() || getUnsoldNum() != blindBoxDetailBean.getUnsoldNum() || getLabel() != blindBoxDetailBean.getLabel() || getBuyBlindCount() != blindBoxDetailBean.getBuyBlindCount() || isAnimated() != blindBoxDetailBean.isAnimated() || getResell() != blindBoxDetailBean.getResell()) {
            return false;
        }
        String coverPic = getCoverPic();
        String coverPic2 = blindBoxDetailBean.getCoverPic();
        if (coverPic == null) {
            if (coverPic2 != null) {
                return false;
            }
        } else if (!coverPic.equals(coverPic2)) {
            return false;
        }
        String detailsPic = getDetailsPic();
        String detailsPic2 = blindBoxDetailBean.getDetailsPic();
        if (detailsPic == null) {
            if (detailsPic2 != null) {
                return false;
            }
        } else if (!detailsPic.equals(detailsPic2)) {
            return false;
        }
        String drawPrice = getDrawPrice();
        String drawPrice2 = blindBoxDetailBean.getDrawPrice();
        if (drawPrice == null) {
            if (drawPrice2 != null) {
                return false;
            }
        } else if (!drawPrice.equals(drawPrice2)) {
            return false;
        }
        String appDynamicId = getAppDynamicId();
        String appDynamicId2 = blindBoxDetailBean.getAppDynamicId();
        if (appDynamicId == null) {
            if (appDynamicId2 != null) {
                return false;
            }
        } else if (!appDynamicId.equals(appDynamicId2)) {
            return false;
        }
        String str = getgId();
        String str2 = blindBoxDetailBean.getgId();
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String id = getId();
        String id2 = blindBoxDetailBean.getId();
        if (id == null) {
            if (id2 != null) {
                return false;
            }
        } else if (!id.equals(id2)) {
            return false;
        }
        List<?> list = getList();
        List<?> list2 = blindBoxDetailBean.getList();
        if (list == null) {
            if (list2 != null) {
                return false;
            }
        } else if (!list.equals(list2)) {
            return false;
        }
        String name = getName();
        String name2 = blindBoxDetailBean.getName();
        if (name == null) {
            if (name2 != null) {
                return false;
            }
        } else if (!name.equals(name2)) {
            return false;
        }
        String orderPic = getOrderPic();
        String orderPic2 = blindBoxDetailBean.getOrderPic();
        if (orderPic == null) {
            if (orderPic2 != null) {
                return false;
            }
        } else if (!orderPic.equals(orderPic2)) {
            return false;
        }
        String ownerAvatar = getOwnerAvatar();
        String ownerAvatar2 = blindBoxDetailBean.getOwnerAvatar();
        if (ownerAvatar == null) {
            if (ownerAvatar2 != null) {
                return false;
            }
        } else if (!ownerAvatar.equals(ownerAvatar2)) {
            return false;
        }
        String ownerName = getOwnerName();
        String ownerName2 = blindBoxDetailBean.getOwnerName();
        if (ownerName == null) {
            if (ownerName2 != null) {
                return false;
            }
        } else if (!ownerName.equals(ownerName2)) {
            return false;
        }
        String price = getPrice();
        String price2 = blindBoxDetailBean.getPrice();
        if (price == null) {
            if (price2 != null) {
                return false;
            }
        } else if (!price.equals(price2)) {
            return false;
        }
        String rule = getRule();
        String rule2 = blindBoxDetailBean.getRule();
        if (rule == null) {
            if (rule2 != null) {
                return false;
            }
        } else if (!rule.equals(rule2)) {
            return false;
        }
        String thumbPic = getThumbPic();
        String thumbPic2 = blindBoxDetailBean.getThumbPic();
        if (thumbPic == null) {
            if (thumbPic2 != null) {
                return false;
            }
        } else if (!thumbPic.equals(thumbPic2)) {
            return false;
        }
        String origin = getOrigin();
        String origin2 = blindBoxDetailBean.getOrigin();
        return origin == null ? origin2 == null : origin.equals(origin2);
    }

    public String getAppDynamicId() {
        return this.appDynamicId;
    }

    public int getBuyBlindCount() {
        return this.buyBlindCount;
    }

    public String getCoverPic() {
        return this.coverPic;
    }

    public String getDetailsPic() {
        return this.detailsPic;
    }

    public int getDrawNum() {
        return this.drawNum;
    }

    public String getDrawPrice() {
        return this.drawPrice;
    }

    public int getDynamicId() {
        return this.dynamicId;
    }

    public String getId() {
        return this.id;
    }

    public int getIsOwner() {
        return this.isOwner;
    }

    public int getLabel() {
        return this.label;
    }

    public List<?> getList() {
        return this.list;
    }

    public String getName() {
        return this.name;
    }

    public int getOnSale() {
        return this.onSale;
    }

    public long getOnSaleTime() {
        return this.onSaleTime;
    }

    public double getOnePrice() {
        return this.onePrice;
    }

    public String getOrderPic() {
        return this.orderPic;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getOwnerAvatar() {
        return this.ownerAvatar;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getPrice() {
        return this.price;
    }

    public int getResell() {
        return this.resell;
    }

    public int getReserve() {
        return this.reserve;
    }

    public String getRule() {
        return this.rule;
    }

    public int getSaleWay() {
        return this.saleWay;
    }

    public int getSellNum() {
        return this.sellNum;
    }

    public int getSoldOutNum() {
        return this.soldOutNum;
    }

    public int getSubOnSale() {
        return this.subOnSale;
    }

    public String getThumbPic() {
        return this.thumbPic;
    }

    public int getType() {
        return this.type;
    }

    public int getUnsoldNum() {
        return this.unsoldNum;
    }

    public String getgId() {
        return this.gId;
    }

    public int hashCode() {
        int drawNum = getDrawNum();
        int dynamicId = getDynamicId();
        int isOwner = getIsOwner();
        int onSale = getOnSale();
        long onSaleTime = getOnSaleTime();
        int i = (int) (onSaleTime ^ (onSaleTime >>> 32));
        long doubleToLongBits = Double.doubleToLongBits(getOnePrice());
        int i2 = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        int reserve = getReserve();
        int saleWay = getSaleWay();
        int sellNum = getSellNum();
        int soldOutNum = getSoldOutNum();
        int subOnSale = getSubOnSale();
        int type = getType();
        int unsoldNum = getUnsoldNum();
        int label = getLabel();
        int buyBlindCount = getBuyBlindCount();
        int i3 = isAnimated() ? 79 : 97;
        int resell = getResell();
        String coverPic = getCoverPic();
        int i4 = 43;
        int hashCode = coverPic == null ? 43 : coverPic.hashCode();
        String detailsPic = getDetailsPic();
        int hashCode2 = detailsPic == null ? 43 : detailsPic.hashCode();
        String drawPrice = getDrawPrice();
        int hashCode3 = drawPrice == null ? 43 : drawPrice.hashCode();
        String appDynamicId = getAppDynamicId();
        int hashCode4 = appDynamicId == null ? 43 : appDynamicId.hashCode();
        String str = getgId();
        int hashCode5 = str == null ? 43 : str.hashCode();
        String id = getId();
        int hashCode6 = id == null ? 43 : id.hashCode();
        List<?> list = getList();
        int hashCode7 = list == null ? 43 : list.hashCode();
        String name = getName();
        int hashCode8 = name == null ? 43 : name.hashCode();
        String orderPic = getOrderPic();
        int hashCode9 = orderPic == null ? 43 : orderPic.hashCode();
        String ownerAvatar = getOwnerAvatar();
        int hashCode10 = ownerAvatar == null ? 43 : ownerAvatar.hashCode();
        String ownerName = getOwnerName();
        int hashCode11 = ownerName == null ? 43 : ownerName.hashCode();
        String price = getPrice();
        int hashCode12 = price == null ? 43 : price.hashCode();
        String rule = getRule();
        int hashCode13 = rule == null ? 43 : rule.hashCode();
        String thumbPic = getThumbPic();
        int hashCode14 = thumbPic == null ? 43 : thumbPic.hashCode();
        String origin = getOrigin();
        if (origin != null) {
            i4 = origin.hashCode();
        }
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((drawNum + 59) * 59) + dynamicId) * 59) + isOwner) * 59) + onSale) * 59) + i) * 59) + i2) * 59) + reserve) * 59) + saleWay) * 59) + sellNum) * 59) + soldOutNum) * 59) + subOnSale) * 59) + type) * 59) + unsoldNum) * 59) + label) * 59) + buyBlindCount) * 59) + i3) * 59) + resell) * 59) + hashCode) * 59) + hashCode2) * 59) + hashCode3) * 59) + hashCode4) * 59) + hashCode5) * 59) + hashCode6) * 59) + hashCode7) * 59) + hashCode8) * 59) + hashCode9) * 59) + hashCode10) * 59) + hashCode11) * 59) + hashCode12) * 59) + hashCode13) * 59) + hashCode14) * 59) + i4;
    }

    public boolean isAnimated() {
        return this.animated;
    }

    public void setAnimated(boolean z) {
        this.animated = z;
    }

    public void setAppDynamicId(String str) {
        this.appDynamicId = str;
    }

    public void setBuyBlindCount(int i) {
        this.buyBlindCount = i;
    }

    public void setCoverPic(String str) {
        this.coverPic = str;
    }

    public void setDetailsPic(String str) {
        this.detailsPic = str;
    }

    public void setDrawNum(int i) {
        this.drawNum = i;
    }

    public void setDrawPrice(String str) {
        this.drawPrice = str;
    }

    public void setDynamicId(int i) {
        this.dynamicId = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIsOwner(int i) {
        this.isOwner = i;
    }

    public void setLabel(int i) {
        this.label = i;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnSale(int i) {
        this.onSale = i;
    }

    public void setOnSaleTime(long j) {
        this.onSaleTime = j;
    }

    public void setOnePrice(double d2) {
        this.onePrice = d2;
    }

    public void setOrderPic(String str) {
        this.orderPic = str;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setOwnerAvatar(String str) {
        this.ownerAvatar = str;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setResell(int i) {
        this.resell = i;
    }

    public void setReserve(int i) {
        this.reserve = i;
    }

    public void setRule(String str) {
        this.rule = str;
    }

    public void setSaleWay(int i) {
        this.saleWay = i;
    }

    public void setSellNum(int i) {
        this.sellNum = i;
    }

    public void setSoldOutNum(int i) {
        this.soldOutNum = i;
    }

    public void setSubOnSale(int i) {
        this.subOnSale = i;
    }

    public void setThumbPic(String str) {
        this.thumbPic = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUnsoldNum(int i) {
        this.unsoldNum = i;
    }

    public void setgId(String str) {
        this.gId = str;
    }

    public String toString() {
        return "BlindBoxDetailBean{coverPic='" + this.coverPic + "', detailsPic=" + this.detailsPic + ", drawNum=" + this.drawNum + ", drawPrice=" + this.drawPrice + ", dynamicId=" + this.dynamicId + ", gId='" + this.gId + "', id=" + this.id + ", isOwner=" + this.isOwner + ", list=" + this.list + ", name='" + this.name + "', onSale=" + this.onSale + ", onSaleTime=" + this.onSaleTime + ", onePrice=" + this.onePrice + ", orderPic='" + this.orderPic + "', ownerAvatar='" + this.ownerAvatar + "', ownerName='" + this.ownerName + "', price='" + this.price + "', reserve=" + this.reserve + ", rule='" + this.rule + "', saleWay=" + this.saleWay + ", sellNum=" + this.sellNum + ", soldOutNum=" + this.soldOutNum + ", subOnSale=" + this.subOnSale + ", thumbPic='" + this.thumbPic + "', type=" + this.type + ", unsoldNum=" + this.unsoldNum + ", animated=" + this.animated + ", buyBlindCount=" + this.buyBlindCount + ", resell=" + this.resell + ", origin=" + this.origin + '}';
    }
}
