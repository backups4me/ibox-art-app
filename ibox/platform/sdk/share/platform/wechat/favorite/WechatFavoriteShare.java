package com.ibox.platform.sdk.share.platform.wechat.favorite;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.favorite.WechatFavorite;
import com.ibox.platform.sdk.share.SharePlatformOptions;
import com.ibox.platform.sdk.share.platform.wechat.favorite.WechatFavoriteShare;
import com.ibox.platform.sdk.share.utils.PlatformTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.mm.opensdk.channel.MMessageActV2;

/* loaded from: WechatFavoriteShare.class */
public class WechatFavoriteShare {
    public SharePlatformOptions a;

    /* renamed from: b  reason: collision with root package name */
    public PlatformActionListener f545b;

    public WechatFavoriteShare(@NonNull SharePlatformOptions sharePlatformOptions, PlatformActionListener platformActionListener) {
        this.a = sharePlatformOptions;
        this.f545b = platformActionListener;
        PlatformTool.a(MMessageActV2.MM_ENTRY_PACKAGE_NAME);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void a(Activity activity, int i, DialogInterface dialogInterface, int i2) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        intent.setFlags(524288);
        activity.startActivityForResult(intent, i);
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i2);
    }

    public final void b(final Activity activity, final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("请选择图片").setPositiveButton("图片", new DialogInterface.OnClickListener(activity, i) { // from class: d.c.e.a.c.a.a.a.a

            /* renamed from: b  reason: collision with root package name */
            public final Activity f1197b;
            public final int c;

            {
                this.f1197b = activity;
                this.c = i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                WechatFavoriteShare.a(this.f1197b, this.c, dialogInterface, i2);
            }
        });
        builder.create().show();
    }

    public void c(Activity activity) {
        b(activity, 145);
    }

    public void d() {
        Platform platform = ShareSDK.getPlatform(WechatFavorite.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(this.a.j());
        if (this.a.d() == null) {
            shareParams.setImageUrl(this.a.e());
        } else {
            shareParams.setImagePath(this.a.d());
        }
        shareParams.setShareType(2);
        platform.setPlatformActionListener(this.f545b);
        platform.share(shareParams);
    }

    public void e() {
        Platform platform = ShareSDK.getPlatform(WechatFavorite.NAME);
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
        platform.setPlatformActionListener(this.f545b);
        platform.share(shareParams);
    }

    public void f() {
        Platform platform = ShareSDK.getPlatform(WechatFavorite.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(this.a.j());
        shareParams.setTitle(this.a.k());
        shareParams.setShareType(1);
        platform.setPlatformActionListener(this.f545b);
        platform.share(shareParams);
    }

    public void g() {
        Platform platform = ShareSDK.getPlatform(WechatFavorite.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(this.a.j());
        shareParams.setTitle(this.a.k());
        shareParams.setUrl(this.a.l());
        if (this.a.d() == null) {
            shareParams.setImageUrl(this.a.e());
        } else {
            shareParams.setImagePath(this.a.d());
        }
        shareParams.setShareType(6);
        platform.setPlatformActionListener(this.f545b);
        platform.share(shareParams);
    }

    public void h() {
        Platform platform = ShareSDK.getPlatform(WechatFavorite.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setFilePath(this.a.b());
        shareParams.setText(this.a.j());
        shareParams.setTitle(this.a.k());
        shareParams.setUrl(this.a.l());
        shareParams.setImageData(this.a.c());
        shareParams.setImagePath(this.a.d());
        shareParams.setShareType(4);
        platform.setPlatformActionListener(this.f545b);
        platform.share(shareParams);
    }
}
