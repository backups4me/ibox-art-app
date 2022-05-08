package com.ibox.nft.base.flutter;

import com.ibox.libs.common.utils.JsonTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.StringTool;
import java.util.HashMap;

/* loaded from: FlutterRoutePage.class */
public final class FlutterRoutePage {
    public static FlutterRoutePage a;

    public static FlutterRoutePage a() {
        if (a == null) {
            synchronized (FlutterRoutePage.class) {
                try {
                    if (a == null) {
                        a = new FlutterRoutePage();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void b(String... strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                FlutterEngineTool.c().a(str, null);
            }
        }
    }

    public void c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("albumId", Integer.valueOf(StringTool.g(str)));
        hashMap.put("gId", Integer.valueOf(StringTool.g(str2)));
        LogTool.a("##### [FLUTTER_PAGE] artAlbumDetail args: " + JsonTool.d(hashMap));
        FlutterNavigationTool.a("albumDetail", hashMap);
    }

    public void d(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("blindId", Integer.valueOf(StringTool.g(str)));
        hashMap.put("gId", StringTool.a(str2));
        LogTool.a("##### [FLUTTER_PAGE] blindBoxDetail args: " + JsonTool.d(hashMap));
        FlutterNavigationTool.a("blindBoxDetail", hashMap);
    }

    public void e(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("albumId", Integer.valueOf(StringTool.g(str)));
        hashMap.put("gId", Integer.valueOf(StringTool.g(str2)));
        LogTool.a("##### [FLUTTER_PAGE] artProductDetail args: " + JsonTool.d(hashMap));
        FlutterNavigationTool.a("artDetail", hashMap);
    }
}
