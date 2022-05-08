package com.ibox.nft.base.enums;

import com.igexin.push.core.c;

/* loaded from: ImageZoomStyleEnum.class */
public enum ImageZoomStyleEnum {
    ST(c.f613e, "style=st"),
    ST_1("1", "style=st1"),
    ST_2("2", "style=st2"),
    ST_3("3", "style=st3"),
    ST_4("4", "style=st4"),
    ST_5("5", "style=st5"),
    ST_6("6", "style=st6");
    
    public String style;
    public String type;

    ImageZoomStyleEnum(String str, String str2) {
        this.type = str;
        this.style = str2;
    }

    public static ImageZoomStyleEnum getType(String str) {
        ImageZoomStyleEnum[] values;
        for (ImageZoomStyleEnum imageZoomStyleEnum : values()) {
            if (imageZoomStyleEnum.type.equals(str)) {
                return imageZoomStyleEnum;
            }
        }
        return ST;
    }
}
