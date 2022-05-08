package com.ibox.nft.network.base.api.enums;

import com.igexin.push.core.c;
import com.mob.tools.utils.BVS;

/* loaded from: RecommendTypeEnum.class */
public enum RecommendTypeEnum {
    UNKNOWN(BVS.DEFAULT_VALUE_MINUS_ONE, "未知"),
    HOME_GOLD(c.f613e, "首页-黄金位"),
    MARKET_NEW("1", "市场-首发"),
    MARKET_RESELL("2", "市场-寄售");
    
    public String desc;
    public String type;

    RecommendTypeEnum(String str, String str2) {
        this.type = str;
        this.desc = str2;
    }

    public static RecommendTypeEnum getType(String str) {
        RecommendTypeEnum[] values;
        for (RecommendTypeEnum recommendTypeEnum : values()) {
            if (recommendTypeEnum.type.equals(str)) {
                return recommendTypeEnum;
            }
        }
        return UNKNOWN;
    }
}
