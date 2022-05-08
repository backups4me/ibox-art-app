package com.ibox.nft.network.art.config;

import android.text.TextUtils;
import com.ibox.network.lib.api.IBoxSubscriber;
import com.ibox.network.lib.bean.IBoxResponse;
import com.ibox.network.lib.manager.RestApiParamsTool;
import com.ibox.nft.network.art.beans.AlbumDetailBean;
import com.ibox.nft.network.art.beans.ArtBrandInfoBean;
import com.ibox.nft.network.art.beans.ArtProductDetailBean;
import com.ibox.nft.network.art.beans.ArtProductInfoBean;
import com.ibox.nft.network.art.beans.ArtProductResultResp;
import com.ibox.nft.network.art.beans.ArtResellPoundageBean;
import com.ibox.nft.network.art.beans.BlindBoxDetailBean;
import com.ibox.nft.network.art.beans.BlindBoxInfoBean;
import com.ibox.nft.network.art.beans.BlindBoxResellResp;
import com.ibox.nft.network.art.beans.BlindBoxResultResp;
import com.ibox.nft.network.art.beans.GroupBlindBoxResultResp;
import com.ibox.nft.network.art.beans.GroupProductResultResp;
import com.ibox.nft.network.art.beans.OpenBlindBoxDynamicBean;
import com.ibox.nft.network.art.beans.OrderDetailInfoBean;
import com.ibox.nft.network.art.beans.OrderListResp;
import com.ibox.nft.network.art.beans.OrderPrePayResp;
import com.ibox.nft.network.art.beans.ResellResultResp;
import com.ibox.nft.network.art.beans.SearchResultResp;
import com.ibox.nft.network.art.beans.SynthesisArtInfoBean;
import com.ibox.nft.network.art.beans.SynthesisArtItemBean;
import com.igexin.push.core.c;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;

/* loaded from: ArtApiNetwork.class */
public final class ArtApiNetwork {
    public static ArtApiNetwork a;

    public static ArtApiNetwork r() {
        if (a == null) {
            synchronized (ArtApiNetwork.class) {
                try {
                    if (a == null) {
                        a = new ArtApiNetwork();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void A(String str, int i, String str2, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", Integer.valueOf(i));
        c.put("onSale", str2);
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().x(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductResultResp>>) iBoxSubscriber);
    }

    public void B(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("gId", str);
        C().g(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtResellPoundageBean>>) iBoxSubscriber);
    }

    public IArtApiService C() {
        return IArtApiImpl.d().e();
    }

    public void D(String str, String str2, int i, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("content", str2);
        c.put("sort", Integer.valueOf(i));
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().G(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BlindBoxResultResp>>) iBoxSubscriber);
    }

    public void E(String str, String str2, int i, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("content", str2);
        c.put("sort", Integer.valueOf(i));
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().k(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductResultResp>>) iBoxSubscriber);
    }

    public void F(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("activityId", str);
        C().w(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<SynthesisArtItemBean>>) iBoxSubscriber);
    }

    public void G(String str, int i, int i2, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put(c.z, str);
        a2.put("type", Integer.valueOf(i));
        a2.put("num", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str2)) {
            a2.put("orderId", str2);
        }
        C().A(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductResultResp>>) iBoxSubscriber);
    }

    public void H(String str, List<String> list, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("activityId", str);
        c.put("ids", list);
        C().q(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<SynthesisArtInfoBean>>) iBoxSubscriber);
    }

    public void I(int i, int i2, String str, String str2, int i3, int i4, int i5, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("type", Integer.valueOf(i));
        c.put("origin", Integer.valueOf(i2));
        c.put("classifyId", str);
        if (i == 1) {
            if (!TextUtils.isEmpty(str2) && !c.f613e.equals(str2)) {
                c.put("blindId", str2);
            }
        } else if (!TextUtils.isEmpty(str2) && !c.f613e.equals(str2)) {
            c.put("brandId", str2);
        }
        c.put("sort", Integer.valueOf(i3));
        c.put("page", Integer.valueOf(i4));
        c.put("pageSize", Integer.valueOf(i5));
        C().D(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ResellResultResp>>) iBoxSubscriber);
    }

    public void J(String str, int i, int i2, int i3, String str2, int i4, String str3, int i5, int i6, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("content", str);
        c.put("type", Integer.valueOf(i));
        c.put("subType", Integer.valueOf(i2));
        c.put("onSale", Integer.valueOf(i3));
        c.put("grade", str2);
        c.put("sort", Integer.valueOf(i4));
        if (!TextUtils.isEmpty(str3)) {
            c.put("classifyId", str3);
        }
        c.put("page", Integer.valueOf(i5));
        c.put("pageSize", Integer.valueOf(i6));
        C().i(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<SearchResultResp>>) iBoxSubscriber);
    }

    public void K(String str, String str2, int i, int i2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("albumId", str);
        a2.put("price", str2);
        a2.put("label", Integer.valueOf(i));
        a2.put("num", Integer.valueOf(i2));
        C().K(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BlindBoxResellResp>>) iBoxSubscriber);
    }

    public void L(String str, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("gId", str);
        a2.put("price", str2);
        C().B(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<String>>) iBoxSubscriber);
    }

    public void M(String str, int i, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("orderId", str);
        c.put("payChannel", Integer.valueOf(i));
        C().E(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<OrderPrePayResp<String>>>) iBoxSubscriber);
    }

    public void a(String str, int i, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("orderId", str);
        c.put("payChannel", Integer.valueOf(i));
        C().f(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<OrderPrePayResp<String>>>) iBoxSubscriber);
    }

    public void b(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("orderId", str);
        C().z(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<Object>>) iBoxSubscriber);
    }

    public void c(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("orderId", str);
        C().F(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<Object>>) iBoxSubscriber);
    }

    public void d(String str, String str2, int i, int i2, String str3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put(c.z, str);
        a2.put("gId", str2);
        a2.put("type", Integer.valueOf(i));
        a2.put("num", String.valueOf(i2));
        a2.put("payChannel", str3);
        C().v(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<OrderPrePayResp<String>>>) iBoxSubscriber);
    }

    public void e(String str, String str2, String str3, String str4, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("albumId", str);
        if (!TextUtils.isEmpty(str2)) {
            a2.put("gId", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            a2.put("gNum", str3);
        }
        a2.put("payChannel", str4);
        C().d(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<OrderPrePayResp<String>>>) iBoxSubscriber);
    }

    public void f(String str, String str2, int i, int i2, String str3, String str4, int i3, String str5, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("albumId", str);
        a2.put("gId", str2);
        a2.put("type", Integer.valueOf(i));
        a2.put("price", str3);
        if (i == 1) {
            a2.put("subType", Integer.valueOf(i2));
            a2.put("num", Integer.valueOf(i3));
        } else {
            a2.put("gNum", str4);
        }
        a2.put("payChannel", str5);
        C().n(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<OrderPrePayResp<String>>>) iBoxSubscriber);
    }

    public void g(String str, int i, int i2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("brandId", str);
        c.put("page", Integer.valueOf(i));
        c.put("pageSize", Integer.valueOf(i2));
        C().r(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductResultResp>>) iBoxSubscriber);
    }

    public void h(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("brandId", str);
        C().b(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<AlbumDetailBean>>) iBoxSubscriber);
    }

    public void i(String str, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put(c.z, str);
        c.put("gId", str2);
        C().o(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BlindBoxDetailBean>>) iBoxSubscriber);
    }

    public void j(String str, String str2, int i, int i2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", 1);
        c.put("albumId", str2);
        c.put("page", Integer.valueOf(i));
        c.put("pageSize", Integer.valueOf(i2));
        C().C(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BlindBoxResultResp>>) iBoxSubscriber);
    }

    public void k(String str, int i, String str2, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", Integer.valueOf(i));
        c.put("onSale", str2);
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().h(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<GroupBlindBoxResultResp>>) iBoxSubscriber);
    }

    public void l(long j, String str, String str2, int i, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("onSaleTime", Long.valueOf(j));
        c.put("direction", str);
        c.put("fromId", str2);
        c.put("size", Integer.valueOf(i));
        C().p(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<BlindBoxInfoBean>>>) iBoxSubscriber);
    }

    @Deprecated
    public void m(String str, int i, String str2, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", Integer.valueOf(i));
        c.put("onSale", str2);
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().m(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BlindBoxResultResp>>) iBoxSubscriber);
    }

    public void n(String str, int i, String str2, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", Integer.valueOf(i));
        c.put("onSale", str2);
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().a(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<BlindBoxResultResp>>) iBoxSubscriber);
    }

    public void o(String str, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> a2 = RestApiParamsTool.a();
        a2.put("albumId", str);
        a2.put("label", str2);
        C().y(a2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtResellPoundageBean>>) iBoxSubscriber);
    }

    public void p(String str, int i, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        if (!TextUtils.isEmpty(str) && !c.f613e.equals(str)) {
            c.put("brandId", str);
        }
        c.put("sort", Integer.valueOf(i));
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().u(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<ArtBrandInfoBean>>>) iBoxSubscriber);
    }

    public void q(IBoxSubscriber iBoxSubscriber) {
        C().j(RestApiParamsTool.c(false)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<ArtProductInfoBean>>>) iBoxSubscriber);
    }

    public void s(String str, int i, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("classifyId", str);
        c.put("order", Integer.valueOf(i));
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().I(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductResultResp>>) iBoxSubscriber);
    }

    public void t(IBoxSubscriber iBoxSubscriber) {
        C().J(RestApiParamsTool.c(false)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<List<OpenBlindBoxDynamicBean>>>) iBoxSubscriber);
    }

    public void u(String str, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("orderId", str);
        C().l(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<OrderDetailInfoBean>>) iBoxSubscriber);
    }

    public void v(int i, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("type", Integer.valueOf(i));
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().H(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<OrderListResp>>) iBoxSubscriber);
    }

    public void w(String str, String str2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("albumId", str);
        c.put("gId", str2);
        C().c(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductDetailBean>>) iBoxSubscriber);
    }

    public void x(String str, String str2, int i, int i2, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", 0);
        c.put("albumId", str2);
        c.put("page", Integer.valueOf(i));
        c.put("pageSize", Integer.valueOf(i2));
        C().e(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductResultResp>>) iBoxSubscriber);
    }

    public void y(String str, int i, String str2, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", Integer.valueOf(i));
        c.put("onSale", str2);
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().t(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<GroupProductResultResp>>) iBoxSubscriber);
    }

    @Deprecated
    public void z(String str, int i, String str2, int i2, int i3, IBoxSubscriber iBoxSubscriber) {
        Map<String, Object> c = RestApiParamsTool.c(false);
        c.put("uid", str);
        c.put("type", Integer.valueOf(i));
        c.put("onSale", str2);
        c.put("page", Integer.valueOf(i2));
        c.put("pageSize", Integer.valueOf(i3));
        C().s(c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer<? super IBoxResponse<ArtProductResultResp>>) iBoxSubscriber);
    }
}
