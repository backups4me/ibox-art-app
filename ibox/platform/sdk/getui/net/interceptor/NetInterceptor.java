package com.ibox.platform.sdk.getui.net.interceptor;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.ibox.platform.sdk.getui.GeTuiSdkOpenManager;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: NetInterceptor.class */
public final class NetInterceptor implements Interceptor {

    /* loaded from: NetInterceptor$NoNetException.class */
    public static class NoNetException extends IOException {
        public NoNetException() {
            super("请检查网络连接");
        }
    }

    public static boolean a() {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) GeTuiSdkOpenManager.f.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(networkInfo.getType() == 0 ? "mobile" : networkInfo.getType() == 1 ? "wifi" : "none");
                Log.d("NetInterceptor~", sb.toString());
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (a()) {
            return chain.proceed(chain.request());
        }
        throw new NoNetException();
    }
}
