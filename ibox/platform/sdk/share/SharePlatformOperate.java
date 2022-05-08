package com.ibox.platform.sdk.share;

import android.app.Activity;
import androidx.annotation.NonNull;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.favorite.WechatFavorite;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.ibox.platform.sdk.share.platform.wechat.favorite.WechatFavoriteShare;
import com.ibox.platform.sdk.share.platform.wechat.friends.WechatShare;
import com.ibox.platform.sdk.share.platform.wechat.moments.WechatMomentsShare;

/* loaded from: SharePlatformOperate.class */
public class SharePlatformOperate {
    public SharePlatformOptions a;

    /* renamed from: b  reason: collision with root package name */
    public PlatformActionListener f541b;

    public SharePlatformOperate(@NonNull SharePlatformOptions sharePlatformOptions) {
        this.a = sharePlatformOptions;
    }

    public SharePlatformOperate a(PlatformActionListener platformActionListener) {
        this.f541b = platformActionListener;
        return this;
    }

    public void b(String str, Activity activity) {
        if (str.equals(Wechat.NAME)) {
            new WechatShare(this.a, this.f541b).b();
        } else if (str.equals(WechatFavorite.NAME)) {
            new WechatFavoriteShare(this.a, this.f541b).c(activity);
        } else {
            Platform platform = ShareSDK.getPlatform(str);
            Platform.ShareParams shareParams = new Platform.ShareParams();
            shareParams.setText(this.a.j());
            shareParams.setTitle(this.a.k());
            shareParams.setFilePath(this.a.b());
            shareParams.setShareType(8);
            platform.setPlatformActionListener(this.f541b);
            platform.share(shareParams);
        }
    }

    public void c(String str, Activity activity) {
        if (str.equals(Wechat.NAME)) {
            new WechatShare(this.a, this.f541b).c();
        } else if (str.equals(WechatFavorite.NAME)) {
            new WechatFavoriteShare(this.a, this.f541b).d();
        } else if (str.equals(WechatMoments.NAME)) {
            new WechatMomentsShare(this.a, this.f541b).a();
        } else {
            Platform platform = ShareSDK.getPlatform(str);
            Platform.ShareParams shareParams = new Platform.ShareParams();
            shareParams.setText(this.a.j());
            shareParams.setTitle(this.a.k());
            shareParams.setImageUrl(this.a.e());
            shareParams.setImagePath(this.a.d());
            shareParams.setImageData(this.a.c());
            shareParams.setShareType(2);
            platform.setPlatformActionListener(this.f541b);
            platform.share(shareParams);
        }
    }

    public void d(String str) {
        if (str.equals(Wechat.NAME)) {
            new WechatShare(this.a, this.f541b).e();
        } else if (str.equals(WechatFavorite.NAME)) {
            new WechatFavoriteShare(this.a, this.f541b).e();
        } else if (str.equals(WechatMoments.NAME)) {
            new WechatMomentsShare(this.a, this.f541b).b();
        } else {
            Platform platform = ShareSDK.getPlatform(str);
            Platform.ShareParams shareParams = new Platform.ShareParams();
            shareParams.setText(this.a.j());
            shareParams.setTitle(this.a.k());
            shareParams.setImageUrl(this.a.e());
            shareParams.setImagePath(this.a.d());
            shareParams.setImageData(this.a.c());
            shareParams.setMusicUrl(this.a.f());
            shareParams.setShareType(5);
            platform.setPlatformActionListener(this.f541b);
            platform.share(shareParams);
        }
    }

    public void e(String str) {
        if (str.equals(Wechat.NAME)) {
            new WechatShare(this.a, this.f541b).f();
        } else if (str.equals(WechatFavorite.NAME)) {
            new WechatFavoriteShare(this.a, this.f541b).f();
        } else if (str.equals(WechatMoments.NAME)) {
            new WechatMomentsShare(this.a, this.f541b).c();
        } else {
            Platform platform = ShareSDK.getPlatform(str);
            Platform.ShareParams shareParams = new Platform.ShareParams();
            shareParams.setText(this.a.j());
            shareParams.setTitle(this.a.k());
            shareParams.setShareType(1);
            platform.setPlatformActionListener(this.f541b);
            platform.share(shareParams);
        }
    }

    public void f(String str, Activity activity) {
        if (str.equals(Wechat.NAME)) {
            new WechatShare(this.a, this.f541b).g();
        } else if (str.equals(WechatFavorite.NAME)) {
            new WechatFavoriteShare(this.a, this.f541b).g();
        } else if (str.equals(WechatMoments.NAME)) {
            new WechatMomentsShare(this.a, this.f541b).d();
        } else {
            Platform platform = ShareSDK.getPlatform(str);
            Platform.ShareParams shareParams = new Platform.ShareParams();
            shareParams.setText(this.a.j());
            shareParams.setTitle(this.a.k());
            shareParams.setFilePath(this.a.b());
            shareParams.setShareType(6);
            platform.setPlatformActionListener(this.f541b);
            platform.share(shareParams);
        }
    }

    public void g(String str, Activity activity) {
        if (str.equals(Wechat.NAME)) {
            new WechatShare(this.a, this.f541b).h();
        } else if (str.equals(WechatMoments.NAME)) {
            new WechatMomentsShare(this.a, this.f541b).e();
        } else if (str.equals(WechatFavorite.NAME)) {
            new WechatFavoriteShare(this.a, this.f541b).h();
        } else {
            Platform platform = ShareSDK.getPlatform(str);
            Platform.ShareParams shareParams = new Platform.ShareParams();
            shareParams.setText(this.a.j());
            shareParams.setTitle(this.a.k());
            shareParams.setImageUrl(this.a.e());
            shareParams.setUrl(this.a.l());
            shareParams.setShareType(4);
            platform.setPlatformActionListener(this.f541b);
            platform.share(shareParams);
        }
    }
}
