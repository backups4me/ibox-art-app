package com.ibox.platform.sdk.config;

import android.content.Context;

/* loaded from: PlatformModulesConfig.class */
public class PlatformModulesConfig {
    public static Context a;

    /* renamed from: b  reason: collision with root package name */
    public static String f512b = "product";
    public static boolean c;

    public static void a(Context context, boolean z, String str) {
        a = context;
        c = z;
        f512b = str;
    }

    public static boolean b() {
        return c;
    }
}
