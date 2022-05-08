package com.ibox.platform.sdk.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import com.ibox.platform.sdk.R$string;
import java.lang.ref.SoftReference;
import java.util.Objects;

/* loaded from: SharePlatformOptions.class */
public class SharePlatformOptions {
    public SoftReference<Context> a;

    /* renamed from: b  reason: collision with root package name */
    public Platform f542b;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f543d;

    /* renamed from: e  reason: collision with root package name */
    public String f544e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public Bitmap k;

    public SharePlatformOptions(Context context) {
        this.a = new SoftReference<>(context);
    }

    public static SharePlatformOptions a(Context context) {
        return new SharePlatformOptions(context);
    }

    public String b() {
        return this.f543d;
    }

    public Bitmap c() {
        return this.k;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.j;
    }

    public String f() {
        return TextUtils.isEmpty(this.g) ? "" : this.g;
    }

    public Platform g() {
        Platform platform = this.f542b;
        Objects.requireNonNull(platform, "MobShareSDK ------- ShareOption: Platform is null!");
        return platform;
    }

    public int h() {
        return this.c;
    }

    public final String i(int i) {
        return this.a.get() == null ? "" : this.a.get().getString(i);
    }

    public String j() {
        return TextUtils.isEmpty(this.h) ? i(R$string.platform_sdk_share_content) : this.h;
    }

    public String k() {
        return TextUtils.isEmpty(this.f544e) ? i(R$string.platform_sdk_evenote_title) : this.f544e;
    }

    public String l() {
        return TextUtils.isEmpty(this.f) ? "" : this.f;
    }

    public SharePlatformOptions m(Bitmap bitmap) {
        this.k = bitmap;
        return this;
    }

    public SharePlatformOptions n(String str) {
        this.i = str;
        return this;
    }

    public SharePlatformOptions o(String str) {
        this.j = str;
        return this;
    }

    public SharePlatformOptions p(Platform platform) {
        this.f542b = platform;
        return this;
    }

    public SharePlatformOptions q(int i) {
        this.c = i;
        return this;
    }

    public SharePlatformOptions r(String str) {
        this.h = str;
        return this;
    }

    public SharePlatformOptions s(String str) {
        this.f544e = str;
        return this;
    }

    public SharePlatformOptions t(String str) {
        this.f = str;
        return this;
    }
}
