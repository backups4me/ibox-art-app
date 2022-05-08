package com.ibox.nft.base.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import com.ibox.libs.common.BaseApplication;
import java.util.HashMap;
import java.util.Map;

/* loaded from: SP.class */
public class SP {
    public static Map<String, SharedPreferences> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, SharedPreferences.Editor> f427b = new HashMap();

    public static String a(String str, String str2, String str3) {
        b(str);
        return a.get(str).getString(str2, str3);
    }

    public static void b(@NonNull String str) {
        synchronized (SP.class) {
            try {
                if (f427b.get(str) == null) {
                    if (str.equals("_default_")) {
                        a.put(str, PreferenceManager.getDefaultSharedPreferences(BaseApplication.b()));
                    } else {
                        a.put(str, BaseApplication.b().getSharedPreferences(str, 0));
                    }
                    f427b.put(str, a.get(str).edit());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        b(str);
        f427b.get(str).putString(str2, str3).apply();
    }
}
