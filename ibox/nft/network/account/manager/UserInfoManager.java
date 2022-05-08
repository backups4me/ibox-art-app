package com.ibox.nft.network.account.manager;

import android.text.TextUtils;
import com.ibox.network.lib.manager.SpNetBaseManager;
import com.ibox.nft.network.account.bean.UserInfoBean;
import com.igexin.push.core.c;

/* loaded from: UserInfoManager.class */
public final class UserInfoManager {
    public static volatile UserInfoManager a;

    public static UserInfoManager d() {
        if (a == null) {
            synchronized (UserInfoManager.class) {
                try {
                    if (a == null) {
                        a = new UserInfoManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void A(int i, int i2) {
        UserInfoBean j = j();
        if (j != null) {
            j.setOwnAuthority(i);
            j.setSelloutAuthority(i2);
            B(j);
        }
    }

    public boolean B(UserInfoBean userInfoBean) {
        UserInfoBean j;
        if (userInfoBean == null || (j = j()) == null) {
            return false;
        }
        if (!TextUtils.isEmpty(j.getUserId()) && j.getUserId().equals(userInfoBean.getUserId())) {
            j.setUserName(userInfoBean.getUserName());
            j.setHeadImage(userInfoBean.getHeadImage());
            j.setIntroduction(userInfoBean.getIntroduction());
            j.setSocialPlatform(userInfoBean.getSocialPlatform());
            j.setWalletAddress(userInfoBean.getWalletAddress());
            j.setWalletType(String.valueOf(userInfoBean.getWalletType()));
            j.setMobile(userInfoBean.getMobile());
            j.setTelNo(userInfoBean.getTelNo());
            j.setWechat(userInfoBean.getWechat());
            j.setCardId(userInfoBean.getCardId());
            j.setOwnAuthority(userInfoBean.getOwnAuthority());
            j.setSelloutAuthority(userInfoBean.getSelloutAuthority());
            j.setYeepayWalletProgress(userInfoBean.getYeepayWalletProgress());
        }
        return w(j);
    }

    public boolean C(String str) {
        UserInfoBean j = j();
        if (j != null && !TextUtils.isEmpty(str)) {
            j.setWalletAddress(str);
        }
        return w(j);
    }

    public boolean D(String str) {
        UserInfoBean j = j();
        if (j != null && !TextUtils.isEmpty(str)) {
            j.setWalletType(str);
        }
        return w(j);
    }

    public void a() {
        SpNetBaseManager.d().a("IBOX_CURRENT_TOKEN_INFO");
        SpNetBaseManager.d().a(b("IBOX_CURRENT_TOKEN_INFO"));
        SpNetBaseManager.d().a(b("IBOX_CURRENT_BIND_MOBILE_INFO"));
        SpNetBaseManager.d().a(b("IBOX_CURRENT_BIND_ADDRESS_INFO"));
        SpNetBaseManager.d().a(b("IBOX_CURRENT_BIND_WECHAT_INFO"));
        SpNetBaseManager.d().a("IBOX_CURRENT_USER_INFO");
        SpNetBaseManager.d().a(b("IBOX_PRIVACY_OWN_SWITCH_STATUS"));
        SpNetBaseManager.d().a(b("IBOX_PRIVACY_SALE_SWITCH_STATUS"));
    }

    public final String b(String str) {
        return str + "_" + i();
    }

    public String c() {
        UserInfoBean j = j();
        return j != null ? j.getCardId() : "";
    }

    public String e() {
        UserInfoBean j = j();
        return j != null ? j.getIntroduction() : "";
    }

    public String f() {
        UserInfoBean j = j();
        return j != null ? j.getSocialPlatform() : "";
    }

    public String g() {
        Object b2 = SpNetBaseManager.d().b(b("IBOX_CURRENT_TOKEN_INFO"));
        String str = (b2 == null || !(b2 instanceof String)) ? "" : (String) b2;
        SpNetBaseManager.d().e("IBOX_CURRENT_TOKEN_INFO", str);
        return str;
    }

    public String h() {
        UserInfoBean j = j();
        return j != null ? j.getHeadImage() : "";
    }

    public String i() {
        UserInfoBean j = j();
        return j != null ? j.getUserId() : c.f613e;
    }

    public UserInfoBean j() {
        Object b2 = SpNetBaseManager.d().b("IBOX_CURRENT_USER_INFO");
        if (b2 == null || !(b2 instanceof UserInfoBean)) {
            return null;
        }
        return (UserInfoBean) b2;
    }

    public String k() {
        UserInfoBean j = j();
        return j != null ? j.getUserName() : "";
    }

    public String l() {
        UserInfoBean j = j();
        return j != null ? j.getWalletAddress() : "";
    }

    public int m() {
        UserInfoBean j = j();
        if (j != null) {
            return j.getYeepayWalletProgress();
        }
        return -1;
    }

    public boolean n() {
        String l = l();
        Object c = SpNetBaseManager.d().c(b("IBOX_CURRENT_BIND_ADDRESS_INFO"), Boolean.FALSE);
        return ((c == null || !(c instanceof Boolean)) ? false : ((Boolean) c).booleanValue()) || !TextUtils.isEmpty(l);
    }

    public boolean o() {
        String str;
        UserInfoBean j = j();
        String str2 = "";
        if (j != null) {
            str2 = j.getOpenId();
            str = j.getWechat();
        } else {
            str = "";
        }
        Object c = SpNetBaseManager.d().c(b("IBOX_CURRENT_BIND_WECHAT_INFO"), Boolean.FALSE);
        return ((c == null || !(c instanceof Boolean)) ? false : ((Boolean) c).booleanValue()) || !TextUtils.isEmpty(str2) || "1".equals(str);
    }

    public boolean p() {
        UserInfoBean j = j();
        return !TextUtils.isEmpty(g()) && j != null && !TextUtils.isEmpty(j.getUserId()) && !c.f613e.equals(j.getUserId());
    }

    public boolean q() {
        UserInfoBean j = j();
        boolean z = false;
        if (j != null) {
            z = false;
            if (j.getOwnAuthority() == 1) {
                z = true;
            }
        }
        return z;
    }

    public boolean r() {
        UserInfoBean j = j();
        boolean z = false;
        if (j != null) {
            z = false;
            if (j.getSelloutAuthority() == 1) {
                z = true;
            }
        }
        return z;
    }

    public boolean s() {
        return m() == 3;
    }

    public void t(String str, boolean z, boolean z2, UserInfoBean userInfoBean) {
        w(userInfoBean);
        u(str);
        v(z);
        x(z2);
    }

    public boolean u(String str) {
        SpNetBaseManager.d().e("IBOX_CURRENT_TOKEN_INFO", str);
        return SpNetBaseManager.d().e(b("IBOX_CURRENT_TOKEN_INFO"), str);
    }

    public boolean v(boolean z) {
        return SpNetBaseManager.d().e(b("IBOX_CURRENT_BIND_MOBILE_INFO"), Boolean.valueOf(z));
    }

    public boolean w(UserInfoBean userInfoBean) {
        return SpNetBaseManager.d().e("IBOX_CURRENT_USER_INFO", userInfoBean);
    }

    public boolean x(boolean z) {
        return SpNetBaseManager.d().e(b("IBOX_CURRENT_BIND_ADDRESS_INFO"), Boolean.valueOf(z));
    }

    public boolean y(boolean z) {
        return SpNetBaseManager.d().e(b("IBOX_CURRENT_BIND_WECHAT_INFO"), Boolean.valueOf(z));
    }

    public void z() {
        Object b2 = SpNetBaseManager.d().b(b("IBOX_CURRENT_TOKEN_INFO"));
        SpNetBaseManager.d().e("IBOX_CURRENT_TOKEN_INFO", (b2 == null || !(b2 instanceof String)) ? "" : (String) b2);
    }
}
