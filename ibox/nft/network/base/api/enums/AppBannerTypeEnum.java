package com.ibox.nft.network.base.api.enums;

import com.igexin.push.core.c;
import com.mob.tools.utils.BVS;

/* loaded from: AppBannerTypeEnum.class */
public enum AppBannerTypeEnum {
    UNKNOWN(BVS.DEFAULT_VALUE_MINUS_ONE, "未知"),
    HOME_TOP(c.f613e, "首页顶部Banner"),
    BLIND_BOX_TOP("1", "盲盒顶部Banner"),
    GOLD_AD("2", "首页黄金广告位");
    
    public String desc;
    public String type;

    AppBannerTypeEnum(String str, String str2) {
        this.type = str;
        this.desc = str2;
    }

    public static AppBannerTypeEnum getType(String str) {
        AppBannerTypeEnum[] values;
        for (AppBannerTypeEnum appBannerTypeEnum : values()) {
            if (appBannerTypeEnum.type.equals(str)) {
                return appBannerTypeEnum;
            }
        }
        return UNKNOWN;
    }
}
