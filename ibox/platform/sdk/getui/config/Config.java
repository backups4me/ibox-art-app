package com.ibox.platform.sdk.getui.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import com.ibox.platform.sdk.getui.GeTuiSdkOpenManager;
import com.igexin.push.core.c;

/* loaded from: Config.class */
public class Config {
    public static final String a = "Config";

    /* renamed from: b  reason: collision with root package name */
    public static String f517b = GeTuiSdkOpenManager.j;
    public static String c = GeTuiSdkOpenManager.k;

    /* renamed from: d  reason: collision with root package name */
    public static String f518d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f519e = "";
    public static String f;

    public static void a(Context context) {
        b(context);
    }

    public static void b(Context context) {
        f519e = context.getPackageName();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(f519e, 128);
            f518d = applicationInfo.loadLabel(context.getPackageManager()).toString();
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.containsKey(c.f611b)) {
                f517b = applicationInfo.metaData.getString(c.f611b);
            }
        } catch (Exception e2) {
            String str = a;
            Log.i(str, "parse manifest failed = " + e2);
        }
    }
}
