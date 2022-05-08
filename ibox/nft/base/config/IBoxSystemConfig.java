package com.ibox.nft.base.config;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Build;
import com.ibox.libs.common.BaseApplication;
import com.ibox.libs.common.config.AppConfig;
import com.ibox.nft.base.receiver.NetworkChangeReceiver;
import com.ibox.nft.base.receiver.ScreenReceiver;
import com.ibox.nft.base.utils.IBoxNightHelper;
import com.igexin.sdk.PushConsts;
import com.tencent.smtt.sdk.WebView;

/* loaded from: IBoxSystemConfig.class */
public class IBoxSystemConfig {
    public static IBoxSystemConfig a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f387b = AppConfig.a;

    public static IBoxSystemConfig a() {
        if (a == null) {
            synchronized (IBoxSystemConfig.class) {
                try {
                    if (a == null) {
                        a = new IBoxSystemConfig();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void b(Application application) {
        e();
        d();
        f();
        h();
        IBoxNightHelper.c();
        g();
        c();
        i();
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g() {
        if ((f387b || !AppConfig.b) && Build.VERSION.SDK_INT >= 19 && (BaseApplication.b().getApplicationInfo().flags & 2) != 0) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public final void h() {
    }

    public final void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        BaseApplication.b().registerReceiver(new ScreenReceiver(), intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter2.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter2.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        BaseApplication.b().registerReceiver(new NetworkChangeReceiver(), intentFilter2);
    }
}
