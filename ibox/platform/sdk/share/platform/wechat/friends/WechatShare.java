package com.ibox.platform.sdk.share.platform.wechat.friends;

import androidx.annotation.NonNull;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import com.ibox.platform.sdk.share.SharePlatformOptions;
import com.ibox.platform.sdk.share.utils.PlatformTool;
import com.tencent.mm.opensdk.channel.MMessageActV2;

/* loaded from: WechatShare.class */
public class WechatShare {
    public SharePlatformOptions a;

    /* renamed from: b  reason: collision with root package name */
    public PlatformActionListener f546b;

    public WechatShare(@NonNull SharePlatformOptions sharePlatformOptions, PlatformActionListener platformActionListener) {
        this.a = sharePlatformOptions;
        this.f546b = platformActionListener;
        PlatformTool.a(MMessageActV2.MM_ENTRY_PACKAGE_NAME);
    }

    public void a() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setShareType(9);
        shareParams.setImageUrl(this.a.e());
        shareParams.setImagePath(this.a.d());
        shareParams.setImageData(this.a.c());
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }

    public void b() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(this.a.k());
        shareParams.setText(this.a.j());
        shareParams.setImageUrl(this.a.e());
        shareParams.setImagePath(this.a.d());
        shareParams.setImageData(this.a.c());
        shareParams.setFilePath(this.a.d());
        shareParams.setShareType(8);
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }

    public void c() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(this.a.k());
        shareParams.setText(this.a.j());
        shareParams.setImageUrl(this.a.e());
        shareParams.setImagePath(this.a.d());
        shareParams.setImageData(this.a.c());
        shareParams.setShareType(2);
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }

    public void d() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(this.a.k());
        shareParams.setText(this.a.j());
        shareParams.setUrl(this.a.l());
        shareParams.setImageUrl(this.a.e());
        shareParams.setImagePath(this.a.d());
        shareParams.setImageData(this.a.c());
        shareParams.setShareType(11);
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }

    public void e() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(this.a.k());
        shareParams.setText(this.a.j());
        shareParams.setImageUrl(this.a.e());
        shareParams.setImagePath(this.a.d());
        shareParams.setImageData(this.a.c());
        shareParams.setMusicUrl(this.a.f());
        shareParams.setUrl(this.a.f());
        shareParams.setShareType(5);
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }

    public void f() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(this.a.k());
        shareParams.setText(this.a.j());
        shareParams.setShareType(1);
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }

    public void g() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(this.a.k());
        shareParams.setText(this.a.j());
        shareParams.setUrl(this.a.l());
        shareParams.setImageUrl(this.a.e());
        shareParams.setImagePath(this.a.d());
        shareParams.setImageData(this.a.c());
        shareParams.setShareType(6);
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }

    public void h() {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(this.a.k());
        shareParams.setText(this.a.j());
        shareParams.setUrl(this.a.l());
        shareParams.setImageUrl(this.a.e());
        shareParams.setImagePath(this.a.d());
        shareParams.setImageData(this.a.c());
        shareParams.setShareType(4);
        platform.setPlatformActionListener(this.f546b);
        platform.share(shareParams);
    }
}
