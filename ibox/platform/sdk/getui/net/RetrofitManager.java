package com.ibox.platform.sdk.getui.net;

import com.ibox.platform.sdk.getui.GeTuiSdkOpenManager;
import com.ibox.platform.sdk.getui.config.Config;
import com.ibox.platform.sdk.getui.net.interceptor.NetInterceptor;
import com.ibox.platform.sdk.getui.net.request.AuthRequest;
import com.ibox.platform.sdk.getui.net.request.LinkNotificationRequest;
import com.ibox.platform.sdk.getui.net.request.TransmissionRequest;
import com.ibox.platform.sdk.getui.net.response.AuthResp;
import com.ibox.platform.sdk.getui.net.response.NotificationResp;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: RetrofitManager.class */
public class RetrofitManager {
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static NetApi f520b;

    static {
        String str = GeTuiSdkOpenManager.m;
        a = str;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f520b = (NetApi) new Retrofit.Builder().g(builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).addInterceptor(new NetInterceptor()).addInterceptor(httpLoggingInterceptor).build()).c(str).b(GsonConverterFactory.a()).a(RxJava2CallAdapterFactory.d()).e().d(NetApi.class);
    }

    public static Observable<AuthResp> a(AuthRequest authRequest) {
        return f520b.a(Config.f517b, authRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<NotificationResp> b(LinkNotificationRequest linkNotificationRequest) {
        return f520b.c(Config.f, Config.f517b, linkNotificationRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<NotificationResp> c(TransmissionRequest transmissionRequest) {
        return f520b.b(Config.f, Config.f517b, transmissionRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
