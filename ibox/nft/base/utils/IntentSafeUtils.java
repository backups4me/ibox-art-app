package com.ibox.nft.base.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: IntentSafeUtils.class */
public class IntentSafeUtils {
    public static final String a = String.valueOf(System.currentTimeMillis());

    public static boolean a(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return true;
        }
        String scheme = data.getScheme();
        return TextUtils.isEmpty(scheme) || "holigeit".equals(scheme) || "scheme".equals(scheme) || a.equals(intent.getStringExtra("extra_time_tag"));
    }
}
