package com.ibox.nft.base.jsbridge.actions;

import android.text.TextUtils;

/* loaded from: BasicJsBridgeActions.class */
public enum BasicJsBridgeActions {
    ACTION_UNKNOWN("", ""),
    ACTION_20210001("20210001", ""),
    ACTION_10000001("10000001", ""),
    ACTION_10000002("10000002", ""),
    ACTION_10000003("10000003", ""),
    ACTION_10000004("10000004", ""),
    ACTION_10000005("10000005", ""),
    ACTION_10000006("10000006", ""),
    ACTION_10000007("10000007", ""),
    ACTION_10000008("10000008", "");
    
    public String action;
    public String handlerName;

    BasicJsBridgeActions(String str, String str2) {
        this.action = str;
        this.handlerName = str2;
    }

    public static BasicJsBridgeActions getAction(String str) {
        BasicJsBridgeActions[] values;
        if (TextUtils.isEmpty(str)) {
            return ACTION_UNKNOWN;
        }
        for (BasicJsBridgeActions basicJsBridgeActions : values()) {
            if (basicJsBridgeActions.action.equals(str)) {
                return basicJsBridgeActions;
            }
        }
        return ACTION_UNKNOWN;
    }
}
