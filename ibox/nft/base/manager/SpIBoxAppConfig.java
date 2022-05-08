package com.ibox.nft.base.manager;

import android.content.Context;
import com.ibox.libs.common.BaseApplication;
import com.ibox.libs.common.config.AppConfig;
import com.ibox.libs.common.hawk.Hawk;

/* loaded from: SpIBoxAppConfig.class */
public final class SpIBoxAppConfig {
    public static SpIBoxAppConfig a;

    /* renamed from: b  reason: collision with root package name */
    public final String f402b;
    public Hawk c;

    public SpIBoxAppConfig() {
        this.f402b = "IBoxAppConfig";
        this.c = null;
    }

    public SpIBoxAppConfig(Context context) {
        this.f402b = "IBoxAppConfig";
        this.c = null;
        this.c = new Hawk(context, "IBoxAppConfig");
    }

    public static SpIBoxAppConfig c() {
        if (a == null) {
            synchronized (SpIBoxAppConfig.class) {
                try {
                    if (a == null) {
                        a = new SpIBoxAppConfig(BaseApplication.c);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public Object a(String str) {
        if (AppConfig.b) {
            Hawk hawk = this.c;
            return hawk.a(str + "_product");
        }
        Hawk hawk2 = this.c;
        return hawk2.a(str + "_test");
    }

    public Object b(String str, Object obj) {
        if (AppConfig.b) {
            Hawk hawk = this.c;
            return hawk.b(str + "_product", obj);
        }
        Hawk hawk2 = this.c;
        return hawk2.b(str + "_test", obj);
    }

    public boolean d(String str, Object obj) {
        if (AppConfig.b) {
            Hawk hawk = this.c;
            return hawk.c(str + "_product", obj);
        }
        Hawk hawk2 = this.c;
        return hawk2.c(str + "_test", obj);
    }
}
