package com.ibox.platform.sdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ibox.platform.sdk.config.PlatformModulesConfig;

/* loaded from: PlatformLogTool.class */
public class PlatformLogTool {
    public static String a = "LogTool";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f548b = PlatformModulesConfig.b();

    public static void a(String str) {
        b(a, str);
    }

    public static void b(String str, String str2) {
        if (f548b) {
            f(str, e(str2));
        }
    }

    public static void c(String str) {
        d(a, str);
    }

    public static void d(String str, String str2) {
        if (f548b) {
            Log.e(str, e(str2));
        }
    }

    public static String e(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    public static void f(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            int length = 2001 - str.length();
            while (str2.length() > length) {
                Log.d(str, str2.substring(0, length));
                str2 = str2.substring(length);
            }
            if (str2.length() > 0) {
                Log.d(str, str2);
            }
        }
    }
}
