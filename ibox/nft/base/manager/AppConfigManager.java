package com.ibox.nft.base.manager;

import android.text.TextUtils;
import com.ibox.nft.network.base.api.bean.AppConfigInfoBean;
import com.igexin.push.core.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: AppConfigManager.class */
public final class AppConfigManager {
    public static AppConfigManager a;

    public static AppConfigManager f() {
        if (a == null) {
            synchronized (AppConfigManager.class) {
                try {
                    if (a == null) {
                        a = new AppConfigManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void a() {
        AppConfigInfoBean c = c();
        if (c != null) {
            c.setMaintainFlag(0);
            c.setMarketFlag(0);
            n(c);
        }
    }

    public String b() {
        AppConfigInfoBean c = c();
        String aboutUsUrl = "";
        aboutUsUrl = c == null ? "" : c.getAboutUsUrl();
        if (TextUtils.isEmpty(aboutUsUrl)) {
        }
        return aboutUsUrl;
    }

    public AppConfigInfoBean c() {
        Object a2 = SpIBoxAppConfig.c().a("APP_CONFIG_INFO");
        if (a2 == null || !(a2 instanceof AppConfigInfoBean)) {
            return null;
        }
        return (AppConfigInfoBean) a2;
    }

    public String d() {
        AppConfigInfoBean c = c();
        String customerAddress = "";
        customerAddress = c == null ? "" : c.getCustomerAddress();
        if (TextUtils.isEmpty(customerAddress)) {
        }
        return customerAddress;
    }

    public String e() {
        AppConfigInfoBean c = c();
        String helpCenterUrl = "";
        helpCenterUrl = c == null ? "" : c.getHelpCenterUrl();
        if (TextUtils.isEmpty(helpCenterUrl)) {
        }
        return helpCenterUrl;
    }

    public String g() {
        AppConfigInfoBean c = c();
        String orderComplainUrl = "";
        orderComplainUrl = c == null ? "" : c.getOrderComplainUrl();
        if (TextUtils.isEmpty(orderComplainUrl)) {
        }
        return orderComplainUrl;
    }

    public List<String> h() {
        ArrayList arrayList;
        AppConfigInfoBean c = c();
        String payType = c == null ? "" : c.getPayType();
        if (!TextUtils.isEmpty(payType)) {
            arrayList = new ArrayList(Arrays.asList(!payType.contains(c.ao) ? new String[]{payType} : payType.split(c.ao)));
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public String i() {
        AppConfigInfoBean c = c();
        String privacyAgreementUrl = "";
        privacyAgreementUrl = c == null ? "" : c.getPrivacyAgreementUrl();
        if (TextUtils.isEmpty(privacyAgreementUrl)) {
        }
        return privacyAgreementUrl;
    }

    public String j() {
        AppConfigInfoBean c = c();
        String serviceNoticeUrl = "";
        serviceNoticeUrl = c == null ? "" : c.getServiceNoticeUrl();
        if (TextUtils.isEmpty(serviceNoticeUrl)) {
        }
        return serviceNoticeUrl;
    }

    public String k() {
        AppConfigInfoBean c = c();
        String userAgreementUrl = "";
        userAgreementUrl = c == null ? "" : c.getUserAgreementUrl();
        if (TextUtils.isEmpty(userAgreementUrl)) {
        }
        return userAgreementUrl;
    }

    public String l() {
        AppConfigInfoBean c = c();
        String yeeWalletTip = "";
        yeeWalletTip = c == null ? "" : c.getYeeWalletTip();
        if (TextUtils.isEmpty(yeeWalletTip)) {
        }
        return yeeWalletTip;
    }

    public boolean m() {
        AppConfigInfoBean c = c();
        return c != null && c.getMarketFlag() == 1;
    }

    public void n(AppConfigInfoBean appConfigInfoBean) {
        SpIBoxAppConfig.c().d("APP_CONFIG_INFO", appConfigInfoBean);
    }
}
