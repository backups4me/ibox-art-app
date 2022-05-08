package com.ibox.nft.network.account.config;

import android.text.TextUtils;
import com.ibox.network.lib.api.IBoxSubscriber;
import com.ibox.network.lib.bean.IBoxResponse;
import com.ibox.network.lib.manager.RestApiParamsTool;
import com.ibox.nft.network.account.bean.BankCardInfoBean;
import com.ibox.nft.network.account.bean.BindBankCardStatusBean;
import com.ibox.nft.network.account.bean.CheckTokenInfoBean;
import com.ibox.nft.network.account.bean.DistributeWalletResultBean;
import com.ibox.nft.network.account.bean.LoginInfoBean;
import com.ibox.nft.network.account.bean.PersonInfoBean;
import com.ibox.nft.network.account.bean.UserInfoBean;
import com.ibox.nft.network.account.bean.WxLoginResult;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;

/* loaded from: AccountApiNetwork.class */
public final class AccountApiNetwork {
    public static AccountApiNetwork a;

    public static AccountApiNetwork i() {
        if (a == null) {
            synchronized (AccountApiNetwork.class) {
                try {
                    if (a == null) {
                        a = new AccountApiNetwork();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void a(String str, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("state", str);
        a2.put("code", str2);
        k().l(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<WxLoginResult>>) iBoxSubscriber);
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("cardId", str);
        a2.put("cardName", str2);
        a2.put("certId", str3);
        a2.put("telNo", str4);
        a2.put("legalLicenceFrontUrl", str5);
        a2.put("legalLicenceBackUrl", str6);
        k().g(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<Object>>) iBoxSubscriber);
    }

    public void c(String str, String str2, String str3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("phoneNumber", str);
        a2.put("captcha", str2);
        a2.put("code", str3);
        k().k(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<LoginInfoBean>>) iBoxSubscriber);
    }

    public void d(String str, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("state", str);
        a2.put("code", str2);
        k().n(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<WxLoginResult>>) iBoxSubscriber);
    }

    public void e(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("token", str);
        k().o(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<CheckTokenInfoBean>>) iBoxSubscriber);
    }

    public void f(IBoxSubscriber iBoxSubscriber) {
        k().j(RestApiParamsTool.a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<DistributeWalletResultBean>>) iBoxSubscriber);
    }

    public void g(IBoxSubscriber iBoxSubscriber) {
        k().h(RestApiParamsTool.a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BankCardInfoBean>>) iBoxSubscriber);
    }

    public void h(IBoxSubscriber iBoxSubscriber) {
        k().m(RestApiParamsTool.a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BindBankCardStatusBean>>) iBoxSubscriber);
    }

    public void j(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        k().f(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<PersonInfoBean>>) iBoxSubscriber);
    }

    public IAccountApiService k() {
        return IAccountApiImpl.d().e();
    }

    public void l(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("phoneNumber", str);
        k().b(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<String>>) iBoxSubscriber);
    }

    public void m(IBoxSubscriber iBoxSubscriber) {
        k().e(RestApiParamsTool.a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<UserInfoBean>>) iBoxSubscriber);
    }

    public void n(String str, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("phoneNumber", str);
        a2.put("code", str2);
        k().c(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<LoginInfoBean>>) iBoxSubscriber);
    }

    public void o(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("cardId", str);
        k().d(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<Object>>) iBoxSubscriber);
    }

    public void p(int i, int i2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("ownAuthority", Integer.valueOf(i));
        a2.put("selloutAuthority", Integer.valueOf(i2));
        k().i(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<Object>>) iBoxSubscriber);
    }

    public void q(String str, String str2, String str3, String str4, IBoxSubscriber iBoxSubscriber) {
        r(str, str2, str3, str4, "", "", iBoxSubscriber);
    }

    public void r(String str, String str2, String str3, String str4, String str5, String str6, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("headImage", str);
        a2.put("userName", str2);
        a2.put("introduction", str3);
        a2.put("socialPlatform", str4);
        if (!TextUtils.isEmpty(str5)) {
            a2.put("mobile", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            a2.put("flag", str6);
        }
        k().a(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse>) iBoxSubscriber);
    }
}
