package com.ibox.platform.sdk.manager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.igexin.push.core.c;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth$Req;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/* loaded from: WXSdkOpenManager.class */
public final class WXSdkOpenManager {
    public static WXSdkOpenManager a;

    /* renamed from: b  reason: collision with root package name */
    public IWXAPI f537b;
    public OnWXAuthLoginCallback c;

    /* renamed from: d  reason: collision with root package name */
    public OnWXPayCallback f538d;

    /* loaded from: WXSdkOpenManager$OnWXAuthLoginCallback.class */
    public interface OnWXAuthLoginCallback {
        void a(Activity activity, BaseReq baseReq);

        void b(Activity activity, BaseResp baseResp);
    }

    /* loaded from: WXSdkOpenManager$OnWXPayCallback.class */
    public interface OnWXPayCallback {
        void a(Activity activity, BaseReq baseReq);

        void b(Activity activity, BaseResp baseResp);
    }

    public static WXSdkOpenManager b() {
        if (a == null) {
            synchronized (WXSdkOpenManager.class) {
                try {
                    if (a == null) {
                        a = new WXSdkOpenManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            String str2 = "";
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                String str3 = hexString;
                if (hexString.length() == 1) {
                    str3 = c.f613e + hexString;
                }
                str2 = str2 + str3;
            }
            return str2;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void c(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        IWXAPI iwxapi = this.f537b;
        if (iwxapi != null) {
            iwxapi.handleIntent(intent, iWXAPIEventHandler);
        }
    }

    public void d(Activity activity, BaseReq baseReq) {
        OnWXAuthLoginCallback onWXAuthLoginCallback = this.c;
        if (onWXAuthLoginCallback != null) {
            onWXAuthLoginCallback.a(activity, baseReq);
        }
    }

    public void e(Activity activity, BaseResp baseResp) {
        OnWXAuthLoginCallback onWXAuthLoginCallback = this.c;
        if (onWXAuthLoginCallback != null) {
            onWXAuthLoginCallback.b(activity, baseResp);
        }
    }

    public void f(Activity activity, BaseReq baseReq) {
        OnWXPayCallback onWXPayCallback = this.f538d;
        if (onWXPayCallback != null) {
            onWXPayCallback.a(activity, baseReq);
        }
    }

    public void g(Activity activity, BaseResp baseResp) {
        OnWXPayCallback onWXPayCallback = this.f538d;
        if (onWXPayCallback != null) {
            onWXPayCallback.b(activity, baseResp);
        }
    }

    public void h(Context context) {
        Objects.requireNonNull(context, "##### [WX_PAY_ERROR] Context is null!");
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx1f999b96fcf9c149", true);
        this.f537b = createWXAPI;
        createWXAPI.registerApp("wx1f999b96fcf9c149");
        context.registerReceiver(new BroadcastReceiver(this, "wx1f999b96fcf9c149") { // from class: com.ibox.platform.sdk.manager.WXSdkOpenManager.1
            public final String a;

            /* renamed from: b  reason: collision with root package name */
            public final WXSdkOpenManager f539b;

            {
                this.f539b = this;
                this.a = r5;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                PushAutoTrackHelper.onBroadcastReceiver(this, context2, intent);
                this.f539b.f537b.registerApp(this.a);
            }
        }, new IntentFilter("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
    }

    public void i(String str, OnWXAuthLoginCallback onWXAuthLoginCallback) {
        Objects.requireNonNull(this.f537b, "##### [WX_SDK_INIT_ERROR] WeChat API has not been registered yet!");
        this.c = onWXAuthLoginCallback;
        SendAuth$Req sendAuth$Req = new SendAuth$Req();
        sendAuth$Req.scope = "snsapi_userinfo";
        sendAuth$Req.state = j("ibox:wechat_login:" + str);
        this.f537b.sendReq(sendAuth$Req);
    }

    public void k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, OnWXPayCallback onWXPayCallback) {
        Objects.requireNonNull(this.f537b, "##### [WX_SDK_INIT_ERROR] WeChat API has not been registered yet!");
        this.f538d = onWXPayCallback;
        PayReq payReq = new PayReq();
        payReq.appId = "wx1f999b96fcf9c149";
        payReq.partnerId = str2;
        payReq.prepayId = str3;
        payReq.nonceStr = str4;
        payReq.timeStamp = str5;
        payReq.packageValue = str6;
        payReq.sign = str7;
        payReq.extData = str8;
        this.f537b.sendReq(payReq);
    }
}
