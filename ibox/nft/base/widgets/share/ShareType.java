package com.ibox.nft.base.widgets.share;

import androidx.core.view.InputDeviceCompat;
import java.io.Serializable;

/* loaded from: ShareType.class */
public enum ShareType implements Serializable {
    URL(InputDeviceCompat.SOURCE_KEYBOARD),
    IMAGE(258),
    TEXT(259);
    
    public int type;

    ShareType(int i) {
        this.type = i;
    }

    public static ShareType getType(int i) {
        ShareType[] values;
        for (ShareType shareType : values()) {
            if (shareType.type == i) {
                return shareType;
            }
        }
        return URL;
    }
}
