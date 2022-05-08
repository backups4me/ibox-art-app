package com.ibox.nft.base.widgets.expandable;

import com.igexin.push.core.d.c;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.UUID;

/* loaded from: UUIDUtils.class */
public class UUIDUtils {
    public static String[] a = {"a", "b", c.a, "d", "e", "f", "g", "h", c.f614b, "j", "k", "l", "m", "n", "o", c.c, "q", "r", c.f615d, "t", "u", "v", "w", "x", "y", "z", com.igexin.push.core.c.f613e, "1", "2", "3", "4", "5", "6", "7", "8", DbParams.GZIP_DATA_ENCRYPT, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String a(int i) {
        StringBuilder sb = new StringBuilder(UUID.randomUUID().toString());
        while (sb.length() < i) {
            sb.append(UUID.randomUUID().toString());
        }
        return sb.substring(0, i);
    }
}
