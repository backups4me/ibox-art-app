package com.ibox.platform.sdk.getui.ui.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.ibox.platform.sdk.getui.GeTuiSdkOpenManager;
import com.ibox.platform.sdk.getui.config.Config;
import com.ibox.platform.sdk.getui.net.RetrofitManager;
import com.ibox.platform.sdk.getui.net.interceptor.NetInterceptor;
import com.ibox.platform.sdk.getui.net.request.AuthRequest;
import com.ibox.platform.sdk.getui.net.response.AuthResp;
import com.ibox.platform.sdk.getui.ui.presenter.AuthInteractor;
import com.igexin.push.core.c;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: AuthInteractor.class */
public class AuthInteractor implements BaseInteractor {
    public static volatile Boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final String f532b = AuthInteractor.class.getSimpleName();
    public CompositeDisposable c = new CompositeDisposable();

    /* renamed from: d  reason: collision with root package name */
    public FutureTask f533d;

    /* loaded from: AuthInteractor$IAuthFinished.class */
    public interface IAuthFinished {
        void a(String str);
    }

    /* loaded from: AuthInteractor$TimeCheckRunnable.class */
    public class TimeCheckRunnable implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public IAuthFinished f535b;
        public final AuthInteractor c;

        public TimeCheckRunnable(AuthInteractor authInteractor, IAuthFinished iAuthFinished) {
            this.c = authInteractor;
            this.f535b = iAuthFinished;
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            try {
                URLConnection openConnection = new URL("http://www.baidu.com").openConnection();
                openConnection.connect();
                AuthInteractor.a = Boolean.valueOf(Math.abs(System.currentTimeMillis() - openConnection.getDate()) < 600000);
                if (!AuthInteractor.a.booleanValue()) {
                    this.f535b.a("请同步本地时间后重启应用");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                AuthInteractor.a = Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append(c.f613e);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static String d(String str) {
        String str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            str2 = a(messageDigest.digest());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str2 = "";
            return str2;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            str2 = "";
            return str2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(IAuthFinished iAuthFinished, AuthResp authResp) throws Exception {
        String str = this.f532b;
        Log.i(str, "isTimeCorrect = " + a);
        if (a != null && !a.booleanValue()) {
            iAuthFinished.a("鉴权失败,请同步本地时间后重启应用");
        } else if (authResp == null) {
            iAuthFinished.a("鉴权失败,请检查签名参数及本地时间");
        } else {
            throw null;
        }
    }

    public void b(IAuthFinished iAuthFinished) {
        this.f533d = new FutureTask(new TimeCheckRunnable(this, iAuthFinished));
        new Thread(this.f533d).start();
    }

    public void c(final IAuthFinished iAuthFinished) {
        FutureTask futureTask;
        if (TextUtils.isEmpty(Config.c) || TextUtils.isEmpty(GeTuiSdkOpenManager.l)) {
            Log.e(this.f532b, "appkey | mastersecret is empty, cancel fetchAuthtoken");
            return;
        }
        if (a == null && (futureTask = this.f533d) != null && futureTask.isDone()) {
            b(iAuthFinished);
        }
        AuthRequest authRequest = new AuthRequest();
        String valueOf = String.valueOf(System.currentTimeMillis());
        authRequest.a(Config.c);
        authRequest.c(valueOf);
        authRequest.b(d(Config.c + valueOf + GeTuiSdkOpenManager.l));
        this.c.add(RetrofitManager.a(authRequest).subscribe(new Consumer(this, iAuthFinished) { // from class: d.c.e.a.a.c.a.a

            /* renamed from: b  reason: collision with root package name */
            public final AuthInteractor f1196b;
            public final AuthInteractor.IAuthFinished c;

            {
                this.f1196b = this;
                this.c = iAuthFinished;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f1196b.f(this.c, (AuthResp) obj);
            }
        }, new Consumer<Throwable>(this, iAuthFinished) { // from class: com.ibox.platform.sdk.getui.ui.presenter.AuthInteractor.1

            /* renamed from: b  reason: collision with root package name */
            public final IAuthFinished f534b;
            public final AuthInteractor c;

            {
                this.c = this;
                this.f534b = iAuthFinished;
            }

            /* renamed from: a */
            public void accept(Throwable th) {
                if (th instanceof NetInterceptor.NoNetException) {
                    this.f534b.a(th.getMessage());
                } else if (AuthInteractor.a == null || AuthInteractor.a.booleanValue()) {
                    this.f534b.a("鉴权失败,请检查签名参数及本地时间");
                } else {
                    this.f534b.a("鉴权失败,请同步本地时间后重启应用");
                }
            }
        }));
    }

    @Override // com.ibox.platform.sdk.getui.ui.presenter.BaseInteractor
    public void onDestroy() {
        this.c.clear();
    }
}
