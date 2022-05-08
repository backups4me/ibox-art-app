package com.ibox.platform.sdk.getui;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.ibox.platform.sdk.R$string;
import com.ibox.platform.sdk.getui.config.Config;
import com.ibox.platform.sdk.getui.interfaces.OnGeTuiNotifyCallback;
import com.ibox.platform.sdk.getui.interfaces.OnGeTuiReceiverMsgCallback;
import com.ibox.platform.sdk.getui.ui.activity.GetuiSdkDemoActivity;
import com.ibox.platform.sdk.getui.ui.presenter.AuthInteractor;
import com.ibox.platform.sdk.utils.PlatformLogTool;
import com.igexin.sdk.PushManager;
import d.c.e.a.a.a;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/* loaded from: GeTuiSdkOpenManager.class */
public final class GeTuiSdkOpenManager implements AuthInteractor.IAuthFinished {
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile GeTuiSdkOpenManager f513b;
    public static WeakReference<GetuiSdkDemoActivity> c;

    /* renamed from: d  reason: collision with root package name */
    public static String f514d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f515e = "";
    public static Context f;
    public static SoftReference<Context> g;
    public static boolean h = false;
    public static boolean i = false;
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static StringBuilder n = new StringBuilder();
    public static volatile GeTuiReceiverMsgHandler o;
    public static SoftReference<GeTuiReceiverMsgHandler> p;
    public static OnGeTuiReceiverMsgCallback q;

    /* loaded from: GeTuiSdkOpenManager$GeTuiReceiverMsgHandler.class */
    public static class GeTuiReceiverMsgHandler extends Handler {
        public OnGeTuiNotifyCallback a;

        /* renamed from: b  reason: collision with root package name */
        public SoftReference<OnGeTuiNotifyCallback> f516b;

        public void a(Message message, OnGeTuiNotifyCallback onGeTuiNotifyCallback) {
            super.sendMessage(message);
            SoftReference<OnGeTuiNotifyCallback> softReference = new SoftReference<>(onGeTuiNotifyCallback);
            this.f516b = softReference;
            this.a = softReference.get();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<GetuiSdkDemoActivity> weakReference;
            WeakReference<GetuiSdkDemoActivity> weakReference2;
            Context context;
            if (GeTuiSdkOpenManager.q != null) {
                GeTuiSdkOpenManager.q.a(GeTuiSdkOpenManager.f, message, this.a);
            }
            boolean z = GeTuiSdkOpenManager.i;
            Object obj = message.obj;
            if (obj != null) {
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        if (obj instanceof String) {
                            GeTuiSdkOpenManager.f515e = (String) obj;
                        }
                        if ((GeTuiSdkOpenManager.a || z) && (weakReference = GeTuiSdkOpenManager.c) != null && weakReference.get() != null && GeTuiSdkOpenManager.c.get().f != null && GeTuiSdkOpenManager.c.get().f.c != null) {
                            GeTuiSdkOpenManager.c.get().f.c.setText((String) message.obj);
                        }
                    } else if (i == 2) {
                        if (obj instanceof String) {
                            GeTuiSdkOpenManager.f514d = (String) obj;
                        }
                        if ((GeTuiSdkOpenManager.a || z) && (weakReference2 = GeTuiSdkOpenManager.c) != null && weakReference2.get() != null && GeTuiSdkOpenManager.c.get().f != null && GeTuiSdkOpenManager.c.get().f.f531e != null) {
                            GeTuiSdkOpenManager.c.get().f.f531e.setText(message.obj.equals("true") ? GeTuiSdkOpenManager.c.get().getResources().getString(R$string.p_sdk_online) : GeTuiSdkOpenManager.c.get().getResources().getString(R$string.p_sdk_offline));
                        }
                    } else if (i == 3 && (context = GeTuiSdkOpenManager.f) != null && obj != null && (obj instanceof String)) {
                        Toast.makeText(context, (String) obj, 0).show();
                    }
                } else if (GeTuiSdkOpenManager.a || z) {
                    GeTuiSdkOpenManager.n.append((String) message.obj);
                    GeTuiSdkOpenManager.n.append("\n");
                    WeakReference<GetuiSdkDemoActivity> weakReference3 = GeTuiSdkOpenManager.c;
                    if (weakReference3 != null && weakReference3.get() != null && GeTuiSdkOpenManager.c.get().f != null && GeTuiSdkOpenManager.c.get().f.f530d != null) {
                        TextView textView = GeTuiSdkOpenManager.c.get().f.f530d;
                        textView.append(message.obj + "\n");
                    }
                }
            }
        }
    }

    public static GeTuiSdkOpenManager d() {
        if (f513b == null) {
            synchronized (GeTuiSdkOpenManager.class) {
                try {
                    if (f513b == null) {
                        f513b = new GeTuiSdkOpenManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f513b;
    }

    @Override // com.ibox.platform.sdk.getui.ui.presenter.AuthInteractor.IAuthFinished
    public void a(String str) {
        if (str.equals("sign_error")) {
            PlatformLogTool.a("###### GeTuiSDK ------ 鉴权失败,请检查签名参数");
            h = true;
        }
        PlatformLogTool.a("###### GeTuiSDK ------ onAuthFailed = " + str);
    }

    public void e(Application application, String str, String str2, String str3, String str4) {
        SoftReference<Context> softReference = new SoftReference<>(application);
        g = softReference;
        f = softReference.get();
        PlatformLogTool.a("###### GeTuiSDK ------------------------------------------------------- init_start");
        PlatformLogTool.a("###### GeTuiSDK id: " + str + ", key: " + str2 + ", master: " + str3 + ", url: " + str4);
        j = str;
        k = str2;
        l = str3;
        m = str4;
        Config.f517b = str;
        Config.c = str2;
        Config.a(application);
        f();
        j();
        g(application);
    }

    public final void f() {
        if (o == null) {
            SoftReference<GeTuiReceiverMsgHandler> softReference = new SoftReference<>(new GeTuiReceiverMsgHandler());
            p = softReference;
            o = softReference.get();
        }
    }

    public final void g(Application application) {
        PlatformLogTool.a("###### GeTuiSDK ------ initializing sdk...");
        PushManager.getInstance().initialize(application);
        if (a) {
            PushManager.getInstance().setDebugLogger(application, a.a);
        }
    }

    public void i(Message message, OnGeTuiNotifyCallback onGeTuiNotifyCallback) {
        o = p.get();
        if (o == null) {
            return;
        }
        if (onGeTuiNotifyCallback == null) {
            o.sendMessage(message);
        } else {
            o.a(message, onGeTuiNotifyCallback);
        }
    }

    public final void j() {
        AuthInteractor authInteractor = new AuthInteractor();
        authInteractor.b(this);
        authInteractor.c(this);
    }
}
