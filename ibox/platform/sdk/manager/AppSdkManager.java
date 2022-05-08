package com.ibox.platform.sdk.manager;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;

/* loaded from: AppSdkManager.class */
public class AppSdkManager {
    public static AppSdkManager a;

    public static AppSdkManager a() {
        if (a == null) {
            synchronized (AppSdkManager.class) {
                try {
                    if (a == null) {
                        a = new AppSdkManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void b(Context context) {
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.TRUE;
        hashMap.put("use_speedy_classloader", bool);
        hashMap.put("use_dexloader_service", bool);
        QbSdk.initTbsSettings(hashMap);
        QbSdk.setDownloadWithoutWifi(true);
        QbSdk.initX5Environment(context, new QbSdk.PreInitCallback(this) { // from class: com.ibox.platform.sdk.manager.AppSdkManager.1
            public final AppSdkManager a;

            {
                this.a = this;
            }

            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onCoreInitFinished() {
            }

            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onViewInitFinished(boolean z) {
            }
        });
    }
}
