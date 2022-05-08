package com.ibox.nft.network.base.api.config;

import com.ibox.network.lib.api.IBoxSubscriber;
import com.ibox.network.lib.bean.IBoxResponse;
import com.ibox.network.lib.manager.RestApiParamsTool;
import com.ibox.nft.network.base.api.bean.AppConfigInfoBean;
import com.ibox.nft.network.base.api.bean.IBoxBannerBean;
import com.ibox.nft.network.base.api.bean.IBoxNoticeInfoBean;
import com.ibox.nft.network.base.api.bean.IBoxVersionInfo;
import com.ibox.nft.network.base.api.bean.RecommendInfoBean;
import com.igexin.push.core.c;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: AppApiNetwork.class */
public class AppApiNetwork {
    public static AppApiNetwork a;

    public static AppApiNetwork d() {
        if (a == null) {
            synchronized (AppApiNetwork.class) {
                try {
                    if (a == null) {
                        a = new AppApiNetwork();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void a(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("version", str);
        a2.put("system", "iBox");
        a2.put("osType", c.f613e);
        g().g(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<IBoxVersionInfo>>) iBoxSubscriber);
    }

    public void b(IBoxSubscriber iBoxSubscriber) {
        g().f(RestApiParamsTool.c(false)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<AppConfigInfoBean>>) iBoxSubscriber);
    }

    public void c(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("type", str);
        g().b(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<IBoxBannerBean>>>) iBoxSubscriber);
    }

    public void e(IBoxSubscriber iBoxSubscriber) {
        g().c(RestApiParamsTool.c(false)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<IBoxNoticeInfoBean>>>) iBoxSubscriber);
    }

    public void f(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("recommendType", str);
        g().e(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<RecommendInfoBean>>>) iBoxSubscriber);
    }

    public IAppApiService g() {
        return IAppApiImpl.d().e();
    }

    public void h(IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("platformType", "android");
        g().h(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<Object>>) iBoxSubscriber);
    }

    public void i(String str, String str2, RequestBody requestBody, IBoxSubscriber iBoxSubscriber) {
        Map<String, RequestBody> d2 = RestApiParamsTool.d();
        d2.put("platform", RequestBody.create(MediaType.parse("text/plain"), "android"));
        d2.put("project", RequestBody.create(MediaType.parse("text/plain"), "nft-mall"));
        d2.put("upType", RequestBody.create(MediaType.parse("text/plain"), "portrait"));
        d2.put("file\"; filename=\"" + str2 + "", requestBody);
        g().d(str, d2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<String>>) iBoxSubscriber);
    }

    public void j(String str, String str2, RequestBody requestBody, IBoxSubscriber iBoxSubscriber) {
        Map<String, RequestBody> d2 = RestApiParamsTool.d();
        d2.put("platform", RequestBody.create(MediaType.parse("text/plain"), "android"));
        d2.put("project", RequestBody.create(MediaType.parse("text/plain"), "nft-mall"));
        d2.put("upType", RequestBody.create(MediaType.parse("text/plain"), "portrait"));
        d2.put("files\"; filename=\"" + str2, requestBody);
        g().a(str, d2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<String>>>) iBoxSubscriber);
    }
}
