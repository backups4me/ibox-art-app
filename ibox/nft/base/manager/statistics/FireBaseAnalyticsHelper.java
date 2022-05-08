package com.ibox.nft.base.manager.statistics;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* loaded from: FireBaseAnalyticsHelper.class */
public class FireBaseAnalyticsHelper {
    public static void a(String str) {
        FirebaseCrashlytics.getInstance().setUserId(str);
    }
}
