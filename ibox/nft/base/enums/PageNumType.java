package com.ibox.nft.base.enums;

import com.mob.tools.utils.BVS;

/* loaded from: PageNumType.class */
public enum PageNumType {
    PAGE_UP(BVS.DEFAULT_VALUE_MINUS_ONE, "上一页"),
    PAGE_DOWN("1", "下一页");
    
    public String desc;
    public String type;

    PageNumType(String str, String str2) {
        this.type = str;
        this.desc = str2;
    }

    public static PageNumType getType(String str) {
        PageNumType[] values;
        for (PageNumType pageNumType : values()) {
            if (pageNumType.type.equals(str)) {
                return pageNumType;
            }
        }
        return PAGE_DOWN;
    }
}
