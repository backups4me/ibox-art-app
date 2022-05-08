package com.ibox.nft.base.config;

import android.text.TextUtils;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.StringTool;
import com.ibox.nft.base.manager.AppConfigManager;
import com.igexin.push.core.c;

/* loaded from: OpenWebUrlAddress.class */
public final class OpenWebUrlAddress {
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f389b = "https://hecoinfo.com/address/";
    public static String c = "https://hecoinfo.com/tx/";

    /* renamed from: d  reason: collision with root package name */
    public static String f390d = "/nft-mall-web/url/forward";

    /* renamed from: e  reason: collision with root package name */
    public static String f391e = "/zh-cn/order?orderid=";
    public static String f = "/zh-cn/order/?orderid=";
    public static String g = "https://ibox-art.yuque.com/books/share/ce0a089b-b465-41ff-afc0-ea048519f5ce";

    public static String a() {
        String b2 = AppConfigManager.f().b();
        String str = b2;
        if (TextUtils.isEmpty(b2)) {
            str = "https://www.yuque.com/btree/og41p2/tir3vg";
        }
        return str;
    }

    public static String b(String str, String str2, String str3) {
        return a + "/zh-cn/resell/?type=1&id=" + str + "&gid=" + str2 + "&label=" + str3;
    }

    public static String c() {
        String d2 = AppConfigManager.f().d();
        String str = d2;
        if (TextUtils.isEmpty(d2)) {
            str = "https://docs.qq.com/s/feSqKFAvc5dyJ4fh37kHla";
        }
        return str;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(a)) {
            LogTool.c("### [OpenWebUrl] Base url is null!");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        if (!str.startsWith("http://")) {
            str2 = str;
            if (!str.startsWith("https://")) {
                str2 = a + str;
            }
        }
        return str2;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(c)) {
            LogTool.c("### [OpenWebUrl] Base heco transaction record address is null!");
        }
        return c + str;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(f389b)) {
            LogTool.c("### [OpenWebUrl] Base heco wallet address is null!");
        }
        return f389b + str;
    }

    public static String g() {
        String e2 = AppConfigManager.f().e();
        String str = e2;
        if (TextUtils.isEmpty(e2)) {
            str = g;
        }
        return str;
    }

    public static String h() {
        String g2 = AppConfigManager.f().g();
        String str = g2;
        if (TextUtils.isEmpty(g2)) {
            str = "https://docs.qq.com/s/feSqKFAvc5dyJ4fh37kHla";
        }
        return str;
    }

    public static String i() {
        String i = AppConfigManager.f().i();
        String str = i;
        if (TextUtils.isEmpty(i)) {
            str = "https://www.yuque.com/btree/og41p2/ehyle4";
        }
        return str;
    }

    public static String j(String str, String str2) {
        return a + "/zh-cn/resell/?type=" + c.f613e + "&id=" + str + "&gid=" + str2;
    }

    public static String k() {
        String j = AppConfigManager.f().j();
        String str = j;
        if (TextUtils.isEmpty(j)) {
            str = "https://www.yuque.com/books/share/347d2903-8ba3-4a63-b3f3-d5066f715d7c/ce6zse";
        }
        return str;
    }

    public static String l(String str, String str2, String str3) {
        return "";
    }

    public static String m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("/zh-cn/item/");
        sb.append("?id=");
        sb.append(str);
        sb.append("&gid=");
        sb.append(str2);
        if (!StringTool.d(str3)) {
            sb.append("&resell=");
            sb.append(str3);
        }
        return sb.toString();
    }

    public static String n(String str, String str2, boolean z, String str3, String str4) {
        return a + "/zh-cn/account?type=" + str + "&sub=" + str3 + "&id=" + str4;
    }

    public static String o(String str, String str2, String str3) {
        return a + "/zh-cn/item/merge/?id=" + str + "&aid=" + str2 + "&gid=" + str3;
    }

    public static String p(String str, String str2) {
        return a + "/zh-cn/item/merge/creating/?id=" + str + "&gid=" + str2;
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(a)) {
            LogTool.c("### [OpenWebUrl] Base url is null!");
        }
        return a + str;
    }

    public static String r() {
        String k = AppConfigManager.f().k();
        String str = k;
        if (TextUtils.isEmpty(k)) {
            str = "https://www.yuque.com/btree/og41p2/ro0o56";
        }
        return str;
    }

    public static void s(String str) {
        a = str;
    }
}
