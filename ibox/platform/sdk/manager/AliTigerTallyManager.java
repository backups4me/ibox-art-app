package com.ibox.platform.sdk.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.aliyun.TigerTally.TigerTallyAPI;
import java.io.UnsupportedEncodingException;

/* loaded from: AliTigerTallyManager.class */
public class AliTigerTallyManager {
    public static Handler a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f536b = true;
    public static AliTigerTallyManager c;

    public AliTigerTallyManager() {
        a = new Handler(Looper.getMainLooper());
    }

    public static AliTigerTallyManager a() {
        if (c == null) {
            synchronized (AliTigerTallyManager.class) {
                try {
                    if (c == null) {
                        c = new AliTigerTallyManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static boolean c() {
        return f536b;
    }

    public void b(Context context, boolean z, boolean z2) {
        if (f536b) {
            TigerTallyAPI.init(context, "EWA40T3eMNVkLmj8Ur9CuQExbcOti8c3yd-I8xDkLhvphNMuRujkY7V6lKbvAtE2qXa4kTWSnXmo0HXfuUXRgyFNXYwhwvvf7yUYQ-DjWjAa34fjA9yJCam4Llddmcu3D8BQKw4gR-nkYzzOx0uGj9OkfgUHoFxF00akZNyeMrs=", z2 ? TigerTallyAPI.CollectType.DEFAULT : TigerTallyAPI.CollectType.NOT_GRANTED);
        }
    }

    public String d(String str) {
        String str2;
        if (!f536b) {
            return "";
        }
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        try {
            str2 = TigerTallyAPI.vmpSign(1, str3.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str2 = "";
        } catch (Exception e3) {
            e3.printStackTrace();
            str2 = "";
        }
        return str2;
    }
}
