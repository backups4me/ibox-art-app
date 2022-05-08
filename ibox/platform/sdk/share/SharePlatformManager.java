package com.ibox.platform.sdk.share;

import android.app.Activity;
import androidx.annotation.NonNull;
import cn.sharesdk.framework.PlatformActionListener;
import com.ibox.platform.sdk.share.platform.wechat.friends.WechatShare;
import java.lang.ref.SoftReference;
import java.util.Objects;

/* loaded from: SharePlatformManager.class */
public class SharePlatformManager {
    public static SharePlatformManager a;

    /* renamed from: b  reason: collision with root package name */
    public SoftReference<PlatformActionListener> f540b;
    public SoftReference<SharePlatformOptions> c;

    public static SharePlatformManager b() {
        synchronized (SharePlatformManager.class) {
            try {
                if (a == null) {
                    synchronized (SharePlatformManager.class) {
                        if (a == null) {
                            a = new SharePlatformManager();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }

    public final void a() {
        Objects.requireNonNull(d(), "MobShareSDK ------- SharePlatformOptions is null!");
    }

    public final PlatformActionListener c() {
        SoftReference<PlatformActionListener> softReference = this.f540b;
        return softReference == null ? null : softReference.get();
    }

    public final SharePlatformOptions d() {
        SoftReference<SharePlatformOptions> softReference = this.c;
        return softReference == null ? null : softReference.get();
    }

    public SharePlatformManager e(PlatformActionListener platformActionListener) {
        this.f540b = new SoftReference<>(platformActionListener);
        return this;
    }

    public SharePlatformManager f(@NonNull SharePlatformOptions sharePlatformOptions) {
        this.c = new SoftReference<>(sharePlatformOptions);
        return this;
    }

    public void g(@NonNull SharePlatformOptions sharePlatformOptions) {
        new WechatShare(sharePlatformOptions, c()).a();
    }

    public void h(Activity activity, @NonNull SharePlatformOptions sharePlatformOptions) {
        SharePlatformOperate sharePlatformOperate = new SharePlatformOperate(sharePlatformOptions);
        sharePlatformOperate.a(c());
        sharePlatformOperate.b(sharePlatformOptions.g().getName(), activity);
    }

    public void i(Activity activity, @NonNull SharePlatformOptions sharePlatformOptions) {
        SharePlatformOperate sharePlatformOperate = new SharePlatformOperate(sharePlatformOptions);
        sharePlatformOperate.a(c());
        sharePlatformOperate.c(sharePlatformOptions.g().getName(), activity);
    }

    public void j(@NonNull SharePlatformOptions sharePlatformOptions) {
        new WechatShare(sharePlatformOptions, c()).d();
    }

    public void k(@NonNull SharePlatformOptions sharePlatformOptions) {
        SharePlatformOperate sharePlatformOperate = new SharePlatformOperate(sharePlatformOptions);
        sharePlatformOperate.a(c());
        sharePlatformOperate.d(sharePlatformOptions.g().getName());
    }

    public void l(Activity activity) {
        a();
        SharePlatformOptions d2 = d();
        int h = d2.h();
        if (h == 1) {
            m(d2);
        } else if (h == 2) {
            i(activity, d2);
        } else if (h == 4) {
            o(activity, d2);
        } else if (h == 5) {
            k(d2);
        } else if (h == 6) {
            n(activity, d2);
        } else if (h == 8) {
            h(activity, d2);
        } else if (h == 9) {
            g(d2);
        } else if (h == 11) {
            j(d2);
        }
    }

    public void m(@NonNull SharePlatformOptions sharePlatformOptions) {
        SharePlatformOperate sharePlatformOperate = new SharePlatformOperate(sharePlatformOptions);
        sharePlatformOperate.a(c());
        sharePlatformOperate.e(sharePlatformOptions.g().getName());
    }

    public void n(Activity activity, @NonNull SharePlatformOptions sharePlatformOptions) {
        SharePlatformOperate sharePlatformOperate = new SharePlatformOperate(sharePlatformOptions);
        sharePlatformOperate.a(c());
        sharePlatformOperate.f(sharePlatformOptions.g().getName(), activity);
    }

    public void o(Activity activity, @NonNull SharePlatformOptions sharePlatformOptions) {
        SharePlatformOperate sharePlatformOperate = new SharePlatformOperate(sharePlatformOptions);
        sharePlatformOperate.a(c());
        sharePlatformOperate.g(sharePlatformOptions.g().getName(), activity);
    }
}
