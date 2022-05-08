package com.ibox.nft.base.utils;

import android.net.Uri;
import com.ibox.libs.common.utils.StringTool;

/* loaded from: ConfigPreferences.class */
public class ConfigPreferences {
    public static String a(String str, String str2, String str3) {
        String a = SP.a(str, str2, str3);
        String str4 = a;
        if (!a.equals(str3)) {
            str4 = Uri.decode(a);
        }
        return str4;
    }

    public static int b(String str, String str2, int i) {
        return StringTool.g(a(str, str2, i + ""));
    }

    public static boolean c(String str, String str2, String str3) {
        SP.c(str, str2, str3);
        return true;
    }
}
