package com.ibox.nft.base.manager;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.NavigationTool;
import com.ibox.libs.common.utils.ToastTool;
import com.ibox.nft.base.config.OpenWebUrlAddress;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

/* loaded from: WebViewManager.class */
public class WebViewManager {
    public static volatile WebViewManager a;

    /* renamed from: b  reason: collision with root package name */
    public OnH5PayResultCallback f404b;

    /* renamed from: com.ibox.nft.base.manager.WebViewManager$1  reason: invalid class name */
    /* loaded from: WebViewManager$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        public static final int[] a = new int[WebViewClientType.values().length];
    }

    /* loaded from: WebViewManager$OnH5PayResultCallback.class */
    public interface OnH5PayResultCallback {
        void a(boolean z);
    }

    /* loaded from: WebViewManager$WebViewClientType.class */
    public enum WebViewClientType {
        NORMAL,
        VIDEO,
        SHARE
    }

    public static WebViewManager a() {
        if (a == null) {
            synchronized (WebViewManager.class) {
                try {
                    if (a == null) {
                        a = new WebViewManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public boolean b(String str) {
        return c(str, OpenWebUrlAddress.f390d) || c(str, OpenWebUrlAddress.f391e) || c(str, OpenWebUrlAddress.f);
    }

    public final boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Locale locale = Locale.US;
        return str.toLowerCase(locale).contains(str2.toLowerCase(locale));
    }

    public void d(boolean z) {
        OnH5PayResultCallback onH5PayResultCallback = this.f404b;
        if (onH5PayResultCallback != null) {
            onH5PayResultCallback.a(z);
        }
    }

    public void e(Activity activity, WebView webView, String str, Bitmap bitmap) {
        if (b(str)) {
            d(true);
            if (ContextTool.a(activity)) {
                activity.finish();
            }
        }
    }

    public void f(Context context, String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                LogTool.a(">>>>>>>>> 未找到系统浏览器");
                if (z) {
                    ToastTool.f("链接地址已复制");
                }
            }
        }
    }

    public void g(Activity activity, String str, boolean z, boolean z2) {
        h(activity, str, 0, z, z2);
    }

    public void h(Activity activity, String str, int i, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putBoolean("isShowTopTitlePanel", z);
        bundle.putBoolean("isOpenPayPage", z2);
        i(activity, WebViewClientType.NORMAL, i, bundle);
    }

    public void i(Activity activity, WebViewClientType webViewClientType, int i, Bundle bundle) {
        if (ContextTool.a(activity)) {
            int i2 = AnonymousClass1.a[webViewClientType.ordinal()];
            if (bundle == null || bundle.isEmpty()) {
                NavigationTool.f(activity, "/ibox_app/activity/commonWebActivity", i);
            } else {
                NavigationTool.g(activity, "/ibox_app/activity/commonWebActivity", i, bundle);
            }
        }
    }

    public void j(OnH5PayResultCallback onH5PayResultCallback) {
        this.f404b = onH5PayResultCallback;
    }
}
