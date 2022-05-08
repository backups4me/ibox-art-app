package com.ibox.nft.base.config;

import android.text.TextUtils;
import com.ibox.libs.common.utils.LogTool;

/* loaded from: OpenDownloadUrlAddress.class */
public final class OpenDownloadUrlAddress {
    public static String a = "";

    public static String a(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (!str.startsWith("http://")) {
                if (str.startsWith("https://")) {
                    str2 = str;
                } else {
                    if (TextUtils.isEmpty(a)) {
                        LogTool.a("[OpenDownloadUrlAddress:2] Download base URL is null！");
                    }
                    str2 = a + str;
                }
            }
        }
        return str2;
    }

    public static void b(String str) {
        a = str;
    }
}
