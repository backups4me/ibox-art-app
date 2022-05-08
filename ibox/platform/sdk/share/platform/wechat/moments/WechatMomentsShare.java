package com.ibox.platform.sdk.share.platform.wechat.moments;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.ibox.platform.sdk.share.SharePlatformOptions;
import com.ibox.platform.sdk.share.utils.PlatformTool;
import com.tencent.mm.opensdk.channel.MMessageActV2;

/* loaded from: WechatMomentsShare.class */
public class WechatMomentsShare {
    public SharePlatformOptions a;

    /* renamed from: b  reason: collision with root package name */
    public PlatformActionListener f547b;

    public WechatMomentsShare(SharePlatformOptions sharePlatformOptions, PlatformActionListener platformActionListener) {
        this.a = sharePlatformOptions;
        this.f547b = platformActionListener;
        PlatformTool.a(MMessageActV2.MM_ENTRY_PACKAGE_NAME);
    }

    public void a() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(this.a.j());
        if (this.a.d() == null) {
            shareParams.setImageUrl(this.a.e());
        } else {
            shareParams.setImagePath(this.a.d());
        }
        shareParams.setShareType(2);
        platform.setPlatformActionListener(this.f547b);
        platform.share(shareParams);
    }

    public void b() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(this.a.j());
        shareParams.setTitle(this.a.k());
        if (this.a.d() == null) {
            shareParams.setImageUrl(this.a.e());
        } else {
            shareParams.setImagePath(this.a.d());
        }
        shareParams.setUrl(this.a.l());
        shareParams.setMusicUrl(this.a.f());
        shareParams.setShareType(5);
        platform.setPlatformActionListener(this.f547b);
        platform.share(shareParams);
    }

    public void c() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(this.a.j());
        shareParams.setTitle(this.a.k());
        shareParams.setShareType(1);
        platform.setPlatformActionListener(this.f547b);
        platform.share(shareParams);
    }

    public void d() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(this.a.j());
        shareParams.setTitle(this.a.k());
        shareParams.setUrl(this.a.l());
        if (this.a.d() == null) {
            shareParams.setImageUrl(this.a.e());
        } else {
            shareParams.setImagePath(this.a.d());
        }
        shareParams.setImagePath(this.a.d());
        shareParams.setShareType(6);
        platform.setPlatformActionListener(this.f547b);
        platform.share(shareParams);
    }

    public void e() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setFilePath(this.a.b());
        shareParams.setText(this.a.j());
        shareParams.setTitle(this.a.k());
        shareParams.setUrl(this.a.l());
        shareParams.setImageData(this.a.c());
        shareParams.setImagePath(this.a.d());
        shareParams.setShareType(4);
        platform.setPlatformActionListener(this.f547b);
        platform.share(shareParams);
    }
}
