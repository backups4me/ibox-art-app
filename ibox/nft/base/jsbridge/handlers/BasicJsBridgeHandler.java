package com.ibox.nft.base.jsbridge.handlers;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.TypeReference;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.JsonTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.NavigationTool;
import com.ibox.libs.widgets.jsbridge.CallBackFunction;
import com.ibox.nft.base.event.EventBusCenter;
import com.ibox.nft.base.flutter.FlutterRoutePage;
import com.ibox.nft.base.jsbridge.BasicJsBridgeDataBean;
import com.ibox.nft.base.jsbridge.JsManager;
import com.ibox.nft.base.jsbridge.actions.BasicJsBridgeActions;
import com.ibox.nft.base.jsbridge.beans.BaseJsDataBean;
import com.ibox.nft.base.jsbridge.beans.JsAlbumBean;
import com.ibox.nft.base.jsbridge.beans.JsSaleResultBean;
import com.ibox.nft.network.account.manager.UserInfoManager;
import com.igexin.push.core.c;
import com.tencent.smtt.sdk.WebView;
import d.c.d.d.e.j.a;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* loaded from: BasicJsBridgeHandler.class */
public class BasicJsBridgeHandler implements BasicJsBridgeHandlerCallback {

    /* renamed from: com.ibox.nft.base.jsbridge.handlers.BasicJsBridgeHandler$4  reason: invalid class name */
    /* loaded from: BasicJsBridgeHandler$4.class */
    public static /* synthetic */ class AnonymousClass4 {
        public static final int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0071 -> B:40:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0075 -> B:36:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0079 -> B:32:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007d -> B:44:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:38:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0085 -> B:34:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0089 -> B:30:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008d -> B:42:0x0064). Please submit an issue!!! */
        static {
            int[] iArr = new int[BasicJsBridgeActions.values().length];
            a = iArr;
            try {
                iArr[BasicJsBridgeActions.ACTION_20210001.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000001.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000002.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000003.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000004.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000005.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000006.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000007.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[BasicJsBridgeActions.ACTION_10000008.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    @Override // com.ibox.nft.base.jsbridge.handlers.BasicJsBridgeHandlerCallback
    public void Q0(Activity activity, String str, WebView webView, CallBackFunction callBackFunction) {
        BaseJsDataBean baseJsDataBean;
        BaseJsDataBean baseJsDataBean2;
        LogTool.a("#### JsBridge  jsonData: " + str);
        BasicJsBridgeDataBean basicJsBridgeDataBean = (BasicJsBridgeDataBean) JsonTool.c(str, BasicJsBridgeDataBean.class);
        if (basicJsBridgeDataBean != null && !TextUtils.isEmpty(basicJsBridgeDataBean.getAction())) {
            BasicJsBridgeActions action = BasicJsBridgeActions.getAction(basicJsBridgeDataBean.getAction());
            LogTool.a("#### JsBridge ------ jsBridgeActions: " + action);
            String str2 = "";
            switch (AnonymousClass4.a[action.ordinal()]) {
                case 2:
                    if (ContextTool.a(activity) && (baseJsDataBean = (BaseJsDataBean) JsonTool.b(str, new TypeReference<BaseJsDataBean<JsSaleResultBean<JsSaleResultBean.ProductDataBean>>>(this) { // from class: com.ibox.nft.base.jsbridge.handlers.BasicJsBridgeHandler.1
                        public final BasicJsBridgeHandler a;

                        {
                            this.a = this;
                        }
                    })) != null && baseJsDataBean.getData() != null && ((JsSaleResultBean) baseJsDataBean.getData()).getData() != null) {
                        JsSaleResultBean.ProductDataBean productDataBean = (JsSaleResultBean.ProductDataBean) ((JsSaleResultBean) baseJsDataBean.getData()).getData();
                        if (!TextUtils.isEmpty(productDataBean.getOrderId())) {
                            Bundle bundle = new Bundle();
                            bundle.putString("orderId", productDataBean.getOrderId());
                            bundle.putBoolean("isRefreshMineInfo", true);
                            NavigationTool.c(activity, "/ibox_app_art/activity/artOrderDetailActivity", bundle);
                        }
                        FlutterRoutePage.a().b("ibox_fm_refreshArtDetail", "ibox_fm_refreshAlbumDetail");
                        activity.finish();
                        return;
                    }
                    return;
                case 3:
                    if (ContextTool.a(activity) && (baseJsDataBean2 = (BaseJsDataBean) JsonTool.b(str, new TypeReference<BaseJsDataBean<JsSaleResultBean<JsSaleResultBean.BlindBoxDataBean>>>(this) { // from class: com.ibox.nft.base.jsbridge.handlers.BasicJsBridgeHandler.2
                        public final BasicJsBridgeHandler a;

                        {
                            this.a = this;
                        }
                    })) != null && baseJsDataBean2.getData() != null && ((JsSaleResultBean) baseJsDataBean2.getData()).getData() != null) {
                        JsSaleResultBean.BlindBoxDataBean blindBoxDataBean = (JsSaleResultBean.BlindBoxDataBean) ((JsSaleResultBean) baseJsDataBean2.getData()).getData();
                        Bundle bundle2 = new Bundle();
                        if (blindBoxDataBean.getNum() > 1) {
                            NavigationTool.b(activity, "/ibox_app_art/activity/artOrderListMainActivity");
                        } else if (!TextUtils.isEmpty(blindBoxDataBean.getOrderIds())) {
                            bundle2.putString("orderId", blindBoxDataBean.getOrderIds());
                            bundle2.putBoolean("isRefreshMineInfo", true);
                            NavigationTool.c(activity, "/ibox_app_art/activity/artOrderDetailActivity", bundle2);
                        }
                        FlutterRoutePage.a().b("ibox_fm_refreshBlindDetail");
                        activity.finish();
                        return;
                    }
                    return;
                case 4:
                default:
                    return;
                case 5:
                    NavigationTool.b(activity, "/ibox_app_account/activity/iBoxLoginActivity");
                    return;
                case 6:
                    BaseJsDataBean baseJsDataBean3 = (BaseJsDataBean) JsonTool.c(str, BaseJsDataBean.class);
                    if (baseJsDataBean3 != null) {
                        str2 = baseJsDataBean3.getCallback();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("token", UserInfoManager.d().g());
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("wallet", 1);
                    hashMap.put(c.ab, hashMap2);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("action", str2);
                    hashMap3.put("code", 200);
                    hashMap3.put("msg", "success");
                    hashMap3.put("data", hashMap);
                    String d2 = JsonTool.d(hashMap3);
                    LogTool.a("####### [WebView] tokenCallbackStr: " + d2);
                    if (webView != null) {
                        webView.evaluateJavascript(JsManager.a(d2), a.a);
                        return;
                    }
                    return;
                case 7:
                    EventBus.c().l(new EventBusCenter(10001023));
                    if (activity != null) {
                        activity.setResult(-1);
                        activity.finish();
                        return;
                    }
                    return;
                case 8:
                    BaseJsDataBean baseJsDataBean4 = (BaseJsDataBean) JsonTool.b(str, new TypeReference<BaseJsDataBean<JsAlbumBean>>(this) { // from class: com.ibox.nft.base.jsbridge.handlers.BasicJsBridgeHandler.3
                        public final BasicJsBridgeHandler a;

                        {
                            this.a = this;
                        }
                    });
                    if (baseJsDataBean4 != null && baseJsDataBean4.getData() != null) {
                        JsAlbumBean jsAlbumBean = (JsAlbumBean) baseJsDataBean4.getData();
                        if (!TextUtils.isEmpty(jsAlbumBean.getAid())) {
                            str2 = jsAlbumBean.getAid();
                        }
                        String gid = TextUtils.isEmpty(jsAlbumBean.getGid()) ? c.f613e : jsAlbumBean.getGid();
                        if (!TextUtils.isEmpty(str2) && !c.f613e.equals(str2)) {
                            FlutterRoutePage.a().c(str2, gid);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
            }
        }
    }
}
