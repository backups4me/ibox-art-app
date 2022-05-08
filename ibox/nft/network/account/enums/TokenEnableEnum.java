package com.ibox.nft.network.account.enums;

/* loaded from: TokenEnableEnum.class */
public enum TokenEnableEnum {
    UNKNOWN(-1, "未知"),
    INVALID(0, "Token无效"),
    EFFICIENT(1, "Token有效");
    
    public String desc;
    public int status;

    TokenEnableEnum(int i, String str) {
        this.status = i;
        this.desc = str;
    }

    public static TokenEnableEnum getStatus(int i) {
        TokenEnableEnum[] values;
        for (TokenEnableEnum tokenEnableEnum : values()) {
            if (tokenEnableEnum.status == i) {
                return tokenEnableEnum;
            }
        }
        return UNKNOWN;
    }
}
