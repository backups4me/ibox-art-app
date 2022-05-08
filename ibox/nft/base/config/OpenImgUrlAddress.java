package com.ibox.nft.base.config;

import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.ibox.libs.common.utils.StringTool;
import com.ibox.nft.base.enums.ImageZoomStyleEnum;

/* loaded from: OpenImgUrlAddress.class */
public final class OpenImgUrlAddress {
    public static ImageZoomStyleEnum a = ImageZoomStyleEnum.ST_6;

    /* renamed from: b  reason: collision with root package name */
    public static String f388b = "";

    public static String a(String str) {
        return c(str, a);
    }

    public static String b(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (!str.startsWith("http://")) {
                if (str.startsWith("https://")) {
                    str2 = str;
                } else {
                    str2 = f388b + str;
                }
            }
        }
        return str2;
    }

    public static String c(String str, ImageZoomStyleEnum imageZoomStyleEnum) {
        String str2 = str;
        if (!StringTool.d(str)) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                str2 = str;
                if (!str.contains("?style=st")) {
                    if (str.contains("&style=st")) {
                        str2 = str;
                    } else if (!str.contains("?")) {
                        return str + "?" + imageZoomStyleEnum.style;
                    } else {
                        str2 = str + a.k + imageZoomStyleEnum.style;
                    }
                }
            } else {
                str2 = str;
            }
        }
        return str2;
    }

    public static void d(String str) {
        f388b = str;
    }
}
