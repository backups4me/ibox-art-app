package com.ibox.platform.sdk.share.utils;

import android.annotation.SuppressLint;
import com.mob.MobSDK;

/* loaded from: PlatformTool.class */
public class PlatformTool {
    @SuppressLint({"WrongConstant"})
    public static boolean a(String str) {
        try {
            MobSDK.getContext().getPackageManager().getPackageInfo(str, 64);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
