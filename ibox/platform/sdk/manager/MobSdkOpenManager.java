package com.ibox.platform.sdk.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.ibox.platform.sdk.share.SharePlatformManager;
import com.ibox.platform.sdk.share.SharePlatformOptions;
import com.mob.MobSDK;
import com.mob.OperationCallback;

/* loaded from: MobSdkOpenManager.class */
public final class MobSdkOpenManager {
    public static MobSdkOpenManager a;

    public static MobSdkOpenManager a() {
        if (a == null) {
            synchronized (MobSdkOpenManager.class) {
                try {
                    if (a == null) {
                        a = new MobSdkOpenManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void b(Context context) {
        MobSDK.init(context);
    }

    public void c(Activity activity, String str, String str2, String str3, String str4, Bitmap bitmap, PlatformActionListener platformActionListener) {
        e(activity, Wechat.NAME, 2, str, str2, str3, str4, bitmap, "", platformActionListener);
    }

    public void d(Activity activity, String str, String str2, String str3, String str4, Bitmap bitmap, PlatformActionListener platformActionListener) {
        e(activity, WechatMoments.NAME, 2, str, str2, str3, str4, bitmap, "", platformActionListener);
    }

    public final void e(Activity activity, String str, int i, String str2, String str3, String str4, String str5, Bitmap bitmap, String str6, PlatformActionListener platformActionListener) {
        Platform platform = ShareSDK.getPlatform(str);
        Platform platform2 = platform;
        if (platform == null) {
            platform2 = ShareSDK.getPlatform(Wechat.NAME);
        }
        SharePlatformManager.b().f(SharePlatformOptions.a(activity).p(platform2).q(i).s(str2).r(str3).n(str4).o(str5).m(bitmap).t(str6)).e(platformActionListener).l(activity);
    }

    public void f(Activity activity, String str, String str2, String str3, String str4, Bitmap bitmap, String str5, PlatformActionListener platformActionListener) {
        e(activity, Wechat.NAME, 4, str, str2, str3, str4, bitmap, str5, platformActionListener);
    }

    public void g(Activity activity, String str, String str2, String str3, String str4, Bitmap bitmap, String str5, PlatformActionListener platformActionListener) {
        e(activity, WechatMoments.NAME, 4, str, str2, str3, str4, bitmap, str5, platformActionListener);
    }

    public void h(OperationCallback operationCallback) {
        MobSDK.submitPolicyGrantResult(true, operationCallback);
    }
}
