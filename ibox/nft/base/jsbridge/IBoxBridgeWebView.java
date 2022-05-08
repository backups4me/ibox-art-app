package com.ibox.nft.base.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.tid.a;
import com.alipay.sdk.widget.d;
import com.ibox.libs.common.BaseApplication;
import com.ibox.libs.common.config.AppConfig;
import com.ibox.libs.common.manager.LocalControlTool;
import com.ibox.libs.common.utils.ClickTool;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.NetTool;
import com.ibox.libs.common.utils.PixelTool;
import com.ibox.libs.common.utils.StringTool;
import com.ibox.libs.common.utils.TimeTool;
import com.ibox.libs.common.utils.ToastTool;
import com.ibox.libs.widgets.jsbridge.BridgeHandler;
import com.ibox.libs.widgets.jsbridge.BridgeWebView;
import com.ibox.libs.widgets.jsbridge.BridgeWebViewClient;
import com.ibox.libs.widgets.jsbridge.CallBackFunction;
import com.ibox.nft.base.R;
import com.ibox.nft.base.config.OpenWebUrlAddress;
import com.ibox.nft.base.event.EventBusCenter;
import com.ibox.nft.base.jsbridge.IBoxBridgeWebView;
import com.ibox.nft.base.jsbridge.handlers.BasicJsBridgeHandlerCallback;
import com.ibox.nft.base.manager.WebViewManager;
import com.igexin.push.core.c;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: IBoxBridgeWebView.class */
public class IBoxBridgeWebView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f396b = new FrameLayout.LayoutParams(-1, -1);
    public String C;
    public Bitmap D;
    public OnOperateControlListener E;
    public ValueCallback<Uri[]> F;
    public BasicJsBridgeHandlerCallback G;
    public int Q;
    public String R;
    public String S;
    public View W;
    public Activity c;

    /* renamed from: d  reason: collision with root package name */
    public View f397d;
    public FrameLayout d0;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f398e;
    public IX5WebChromeClient.CustomViewCallback e0;
    public FrameLayout f;
    public View g;
    public View h;
    public BridgeWebView i;
    public ProgressBar j;
    public FrameLayout k;
    public FrameLayout l;
    public ImageView m;
    public View n;
    public ImageView o;
    public ImageView p;
    public TextView q;
    public LinearLayout r;
    public TextView s;
    public View t;
    public String z;
    public String u = "Web-" + TimeTool.b("yyyyMMdd");
    public CountDownTimer v = new CountDownTimer(this, 8000, 1000) { // from class: com.ibox.nft.base.jsbridge.IBoxBridgeWebView.1
        public final IBoxBridgeWebView a;

        {
            this.a = this;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.a.i.reload();
            LogTool.a("webview##  超时重新加载");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    };
    public String w = "";
    public String x = "";
    public String y = "";
    public String A = "";
    public String B = "";
    public boolean H = true;
    public boolean I = true;
    public boolean J = true;
    public boolean K = false;
    public boolean L = true;
    public boolean M = false;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;
    public int T = 0;
    public Handler U = new Handler(new Handler.Callback(this) { // from class: com.ibox.nft.base.jsbridge.IBoxBridgeWebView.2

        /* renamed from: b  reason: collision with root package name */
        public final IBoxBridgeWebView f399b;

        {
            this.f399b = this;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 256) {
                if (this.f399b.i != null) {
                    this.f399b.i.getSettings().setBlockNetworkImage(false);
                }
                if (this.f399b.j != null) {
                    this.f399b.j.setVisibility(8);
                }
                this.f399b.x("handler_fail");
                return true;
            } else if (i != 257) {
                return true;
            } else {
                IBoxBridgeWebView iBoxBridgeWebView = this.f399b;
                iBoxBridgeWebView.e0(iBoxBridgeWebView.y, iBoxBridgeWebView.z);
                return true;
            }
        }
    });
    public Runnable V = new Runnable(this) { // from class: com.ibox.nft.base.jsbridge.IBoxBridgeWebView.3

        /* renamed from: b  reason: collision with root package name */
        public final IBoxBridgeWebView f400b;

        {
            this.f400b = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f400b.i.getSettings().setBlockNetworkImage(false);
            this.f400b.j.setVisibility(8);
            this.f400b.x("finishLoadRunnable");
        }
    };

    /* renamed from: com.ibox.nft.base.jsbridge.IBoxBridgeWebView$5  reason: invalid class name */
    /* loaded from: IBoxBridgeWebView$5.class */
    public class AnonymousClass5 extends WebChromeClient {
        public final IBoxBridgeWebView a;

        public AnonymousClass5(IBoxBridgeWebView iBoxBridgeWebView) {
            this.a = iBoxBridgeWebView;
        }

        public static /* synthetic */ void a(PermissionRequest permissionRequest) {
            try {
                permissionRequest.grant(permissionRequest.getResources());
            } catch (Exception e2) {
                e2.printStackTrace();
                LogTool.e(e2);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(this.a.c);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            this.a.s();
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        @RequiresApi(api = 21)
        public void onPermissionRequest(final PermissionRequest permissionRequest) {
            super.onPermissionRequest(permissionRequest);
            if (ContextTool.a(this.a.c)) {
                this.a.c.runOnUiThread(new Runnable(permissionRequest) { // from class: d.c.d.d.e.a

                    /* renamed from: b  reason: collision with root package name */
                    public final PermissionRequest f1146b;

                    {
                        this.f1146b = permissionRequest;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IBoxBridgeWebView.AnonymousClass5.a(this.f1146b);
                    }
                });
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (ContextTool.a(this.a.c)) {
                if (this.a.j != null) {
                    this.a.j.setProgress(i);
                }
                if (!this.a.O && i == this.a.j.getMax()) {
                    this.a.U.sendEmptyMessageDelayed(256, 5L);
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (ContextTool.a(this.a.c) && this.a.I) {
                if (!TextUtils.isEmpty(str)) {
                    this.a.w = str;
                }
                this.a.s.setText(this.a.w);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            this.a.c0(view, customViewCallback);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (!ContextTool.a(this.a.c)) {
                return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            this.a.F = valueCallback;
            if (this.a.E == null) {
                return true;
            }
            if (this.a.Q == 39321) {
                this.a.E.b(4097);
                return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            this.a.E.a(4097);
            return true;
        }
    }

    /* loaded from: IBoxBridgeWebView$FullscreenHolder.class */
    public static class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: IBoxBridgeWebView$OnOperateControlListener.class */
    public interface OnOperateControlListener {
        void a(int i);

        void b(int i);
    }

    public IBoxBridgeWebView(@NonNull Context context) {
        super(context);
        u(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: B */
    public /* synthetic */ void C(View view) {
        r();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: D */
    public /* synthetic */ void E(View view) {
        this.c.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: F */
    public /* synthetic */ void G(View view) {
        if (!NetTool.b(this.c)) {
            this.t.setVisibility(0);
        } else {
            e0(this.y, this.z);
            this.t.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(int i, int i2, int i3, int i4) {
        this.T = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(String str, CallBackFunction callBackFunction) {
        LogTool.a("## -- 访问bridge_iboxBasicBusinessJSBridge URL: " + this.i.getUrl());
        BasicJsBridgeHandlerCallback basicJsBridgeHandlerCallback = this.G;
        if (basicJsBridgeHandlerCallback != null) {
            basicJsBridgeHandlerCallback.Q0(this.c, str, this.i, callBackFunction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(String str, CallBackFunction callBackFunction) {
        LogTool.a("## -- 访问bridge_hChatBasicBusinessJSBridge URL: " + this.i.getUrl());
        BasicJsBridgeHandlerCallback basicJsBridgeHandlerCallback = this.G;
        if (basicJsBridgeHandlerCallback != null) {
            basicJsBridgeHandlerCallback.Q0(this.c, str, this.i, callBackFunction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(String str, String str2, String str3, String str4, long j) {
        if (str.startsWith("http")) {
            this.c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        this.c.startActivity(intent);
    }

    private void setStatusBarVisibility(boolean z) {
        if (ContextTool.a(this.c) && this.c.getWindow() != null) {
            this.c.getWindow().setFlags(z ? 2048 : 1024, 1024);
        }
    }

    private void setTitlePanelVisibility(int i) {
        this.g.setVisibility(i);
        this.h.setVisibility(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        if (i != 0 || this.N) {
            layoutParams.topMargin = 0;
            this.h.setVisibility(8);
            return;
        }
        layoutParams.topMargin = PixelTool.a(48.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: z */
    public /* synthetic */ void A(View view) {
        this.D = BitmapFactory.decodeResource(getResources(), R.drawable.ic_ibox_app_icon);
        String webTitle = getWebTitle();
        String str = webTitle;
        if (webTitle.startsWith("http")) {
            str = LocalControlTool.i("app_name_ibox_app");
        }
        d0(str, getWebContent(), this.D, q(getWebUrl()), this.S);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void P(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            this.w = bundle.getString(d.v, "");
            this.x = bundle.getString("content", "");
            this.y = bundle.getString("url", "");
            this.z = bundle.getString("html_text", "");
            this.A = bundle.getString("target", "");
            this.B = bundle.getString("descUrl", "");
            this.R = bundle.getString("shareUrl");
            this.S = bundle.getString("shareIcon");
            this.M = bundle.getBoolean("showShareBtn", this.M);
            this.H = bundle.getBoolean("isShowTopTitlePanel", this.H);
            this.P = bundle.getBoolean("isOpenPayPage", false);
            this.Q = bundle.getInt("basicOpenWebActions", 0);
        }
        if (!this.L) {
            t();
        }
        this.O = false;
        LogTool.a("share##   title: " + this.w + ", content: " + this.x + ", target: " + this.A + ", url: " + this.y + ", shareUrl: " + this.R + ", shareIcon: " + this.S);
        if (!StringTool.d(this.y) || !StringTool.d(this.z)) {
            v();
        } else if (ContextTool.a(this.c)) {
            this.c.finish();
        }
    }

    public void Q(Activity activity, int i, int i2, Intent intent) {
    }

    public void R() {
        this.U.removeCallbacks(this.V);
        this.v.cancel();
        o();
        BridgeWebView bridgeWebView = this.i;
        if (bridgeWebView != null) {
            bridgeWebView.E("iBoxBasicBusinessJSBridge");
            this.i.E("iboxWebBridge");
            this.i.destroy();
        }
    }

    public void S(EventBusCenter eventBusCenter) {
        int b2 = eventBusCenter.b();
        if (b2 == 10001001) {
            LogTool.a("#####  Login_Success -------  ");
            if (ClickTool.a()) {
                String q = OpenWebUrlAddress.q("/zh-cn/resell/?");
                String q2 = OpenWebUrlAddress.q("/zh-cn/item/merge/?");
                if (StringTool.d(this.y)) {
                    return;
                }
                if (this.y.contains(q) || this.y.contains(q2)) {
                    e0(this.y, "");
                }
            }
        } else if (b2 == 10001008) {
            String q3 = OpenWebUrlAddress.q("/zh-cn/item/merge/?");
            if (!StringTool.d(this.y) && this.y.contains(q3)) {
                e0(this.y, "");
            }
        }
    }

    public void T() {
        BridgeWebView bridgeWebView = this.i;
        if (bridgeWebView != null) {
            bridgeWebView.onPause();
        }
    }

    public void U(int i, @NonNull List<String> list) {
        if (134 == i) {
            ToastTool.f(this.c == null ? null : StringTool.b(R.string.activity_main_permission_storage));
        }
    }

    public void V(int i, @NonNull List<String> list) {
    }

    public void W(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void X() {
        BridgeWebView bridgeWebView = this.i;
        if (bridgeWebView != null) {
            bridgeWebView.onResume();
        }
    }

    public final void Y(String str) {
        LogTool.a("webview##  网页加载页面htmlText: " + str);
        this.i.getSettings().setDefaultTextEncodingName("utf-8");
        BridgeWebView bridgeWebView = this.i;
        bridgeWebView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        SensorsDataAutoTrackHelper.loadDataWithBaseURL2(bridgeWebView, null, str, "text/html", "utf-8", null);
    }

    public final void Z(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(a.k, String.valueOf(System.currentTimeMillis()));
        hashMap.put("source", c.f613e);
        StringBuilder sb = new StringBuilder(str);
        LogTool.a("webview##  网页加载地址loadUrl: " + sb.toString());
        if (sb.toString().contains("/#/iboxAuth")) {
            this.i.clearCache(false);
        } else {
            this.i.clearCache(true);
        }
        BridgeWebView bridgeWebView = this.i;
        String sb2 = sb.toString();
        bridgeWebView.loadUrl(sb2, hashMap);
        SensorsDataAutoTrackHelper.loadUrl2(bridgeWebView, sb2, hashMap);
        this.C = this.i.getUrl();
    }

    public void a0() {
        this.i.k();
        this.i.D("iBoxBasicBusinessJSBridge", new BridgeHandler(this) { // from class: d.c.d.d.e.c
            public final IBoxBridgeWebView a;

            {
                this.a = this;
            }

            public final void a(String str, CallBackFunction callBackFunction) {
                this.a.K(str, callBackFunction);
            }
        });
        this.i.D("hbcBasicBusinessJSBridge", new BridgeHandler(this) { // from class: d.c.d.d.e.i
            public final IBoxBridgeWebView a;

            {
                this.a = this;
            }

            public final void a(String str, CallBackFunction callBackFunction) {
                this.a.M(str, callBackFunction);
            }
        });
        this.i.setDownloadListener(new DownloadListener(this) { // from class: d.c.d.d.e.f
            public final IBoxBridgeWebView a;

            {
                this.a = this;
            }

            @Override // com.tencent.smtt.sdk.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                this.a.O(str, str2, str3, str4, j);
            }
        });
    }

    public IBoxBridgeWebView b0(boolean z) {
        this.I = z;
        return this;
    }

    public final void c0(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.W != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.c.getWindow().getDecorView();
        FullscreenHolder fullscreenHolder = new FullscreenHolder(this.c);
        this.d0 = fullscreenHolder;
        FrameLayout.LayoutParams layoutParams = f396b;
        fullscreenHolder.addView(view, layoutParams);
        frameLayout.addView(this.d0, layoutParams);
        this.i.setVisibility(8);
        this.W = view;
        setStatusBarVisibility(false);
        this.e0 = customViewCallback;
        this.c.setRequestedOrientation(0);
    }

    public final void d0(String str, String str2, Bitmap bitmap, String str3, String str4) {
    }

    public void e0(String str, String str2) {
        if (!StringTool.d(str) || !StringTool.d(str2)) {
            if (!StringTool.d(str)) {
                Z(str, "");
            } else {
                Y(str2);
            }
        } else if (ContextTool.a(this.c)) {
            this.c.finish();
        }
    }

    public FrameLayout getOperateContainer() {
        return this.l;
    }

    public TextView getTvTitle() {
        return this.s;
    }

    public String getWebContent() {
        return StringTool.d(this.x) ? "" : this.x;
    }

    public String getWebTitle() {
        return StringTool.d(this.w) ? "" : this.w;
    }

    public String getWebUrl() {
        return StringTool.d(this.y) ? "" : this.y;
    }

    public BridgeWebView getWebView() {
        return this.i;
    }

    public final void o() {
        try {
            CookieSyncManager.createInstance(BaseApplication.c);
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
            this.i.setWebChromeClient(null);
            this.i.setWebViewClient(null);
            this.i.getSettings().setJavaScriptEnabled(false);
            this.i.clearCache(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ContextTool.a(this.c) && this.c.getWindow() != null) {
            int i = configuration.orientation;
            if (i == 1) {
                this.c.getWindow().clearFlags(1024);
                this.c.getWindow().addFlags(2048);
            } else if (i == 2) {
                setTitlePanelVisibility(8);
                this.c.getWindow().clearFlags(2048);
                this.c.getWindow().addFlags(1024);
            }
        }
    }

    public void p(int i, String str) {
        if (i == 4097) {
            LogTool.a("###### 录像、拍照、图片选择文件地址imgPath: " + str);
            if (this.F != null) {
                this.F.onReceiveValue(TextUtils.isEmpty(str) ? new Uri[0] : new Uri[]{Uri.fromFile(new File(str))});
            }
        }
    }

    public final String q(String str) {
        if (!StringTool.d(this.R)) {
            return this.R;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    public boolean r() {
        LogTool.a("##### goBackPressed()   ----- 1");
        if (!this.J) {
            return false;
        }
        if (this.K) {
            LogTool.a("##### goBackPressed()   ----- firstPageUrl: " + this.C);
            LogTool.a("##### goBackPressed()   ----- currentPageUrl: " + this.i.getUrl());
            if (!StringTool.d(this.C) && this.C.equals(this.i.getUrl())) {
                return false;
            }
        }
        LogTool.a("##### goBackPressed()   ----- 2");
        if (this.i.canGoBack()) {
            LogTool.a("##### goBackPressed()   ----- 3");
            this.i.goBack();
            return true;
        }
        LogTool.a("##### goBackPressed()   ----- 4");
        return false;
    }

    public final void s() {
        if (this.W != null) {
            setStatusBarVisibility(true);
            ((FrameLayout) this.c.getWindow().getDecorView()).removeView(this.d0);
            this.d0 = null;
            this.W = null;
            this.e0.onCustomViewHidden();
            this.i.setVisibility(0);
            this.c.setRequestedOrientation(1);
        }
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.m.setOnClickListener(onClickListener);
    }

    public void setOnBasicJsBridgeHandlerCallback(BasicJsBridgeHandlerCallback basicJsBridgeHandlerCallback) {
        this.G = basicJsBridgeHandlerCallback;
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        this.o.setOnClickListener(onClickListener);
    }

    public void setOnOperateControlListener(OnOperateControlListener onOperateControlListener) {
        this.E = onOperateControlListener;
    }

    public void t() {
        this.n.setVisibility(8);
        this.o.setVisibility(8);
    }

    public final void u(Context context) {
        if (ContextTool.c(context)) {
            this.c = (Activity) context;
            y(LayoutInflater.from(context).inflate(R.layout.view_jsbridge_webview, (ViewGroup) this, true));
            w();
        }
    }

    public void v() {
        if (!StringTool.d(this.w)) {
            this.s.setText(this.w);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        int i = 8;
        if (this.N) {
            layoutParams.topMargin = 0;
            this.h.setVisibility(8);
            t();
        } else {
            layoutParams.topMargin = PixelTool.a(48.0f);
            this.h.setVisibility(0);
        }
        if (this.M) {
            this.p.setImageResource(R.drawable.ic_share_icon);
            this.p.setVisibility(0);
            this.r.setEnabled(true);
            this.r.setOnClickListener(new View.OnClickListener(this) { // from class: d.c.d.d.e.g

                /* renamed from: b  reason: collision with root package name */
                public final IBoxBridgeWebView f1149b;

                {
                    this.f1149b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1149b.A(view);
                }
            });
        }
        if (this.H) {
            i = 0;
        }
        setTitlePanelVisibility(i);
        ProgressBar progressBar = this.j;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.U.sendEmptyMessageDelayed(InputDeviceCompat.SOURCE_KEYBOARD, 500L);
    }

    public void w() {
        a0();
        if ((AppConfig.a || !AppConfig.b) && Build.VERSION.SDK_INT >= 19 && (this.c.getApplicationInfo().flags & 2) != 0) {
            WebView.setWebContentsDebuggingEnabled(true);
            Log.i("webview", "###  --- ContentsDebugging ---");
        }
        ImageView imageView = this.m;
        Resources resources = getResources();
        int i = R.color.color_333333;
        imageView.setColorFilter(resources.getColor(i));
        this.o.setColorFilter(getResources().getColor(i));
        this.m.setOnClickListener(new View.OnClickListener(this) { // from class: d.c.d.d.e.b

            /* renamed from: b  reason: collision with root package name */
            public final IBoxBridgeWebView f1147b;

            {
                this.f1147b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1147b.C(view);
            }
        });
        this.o.setOnClickListener(new View.OnClickListener(this) { // from class: d.c.d.d.e.h

            /* renamed from: b  reason: collision with root package name */
            public final IBoxBridgeWebView f1150b;

            {
                this.f1150b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1150b.E(view);
            }
        });
        if (!NetTool.b(this.c)) {
            this.t.setVisibility(0);
            this.t.setOnClickListener(new View.OnClickListener(this) { // from class: d.c.d.d.e.e

                /* renamed from: b  reason: collision with root package name */
                public final IBoxBridgeWebView f1148b;

                {
                    this.f1148b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1148b.G(view);
                }
            });
        } else {
            this.t.setVisibility(8);
        }
        WebSettings settings = this.i.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setCacheMode(2);
        settings.setAppCacheEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        String userAgentString = settings.getUserAgentString();
        String str = userAgentString;
        if (TextUtils.isEmpty(userAgentString)) {
            str = "";
        }
        String str2 = str;
        if (!str.contains("iBoxWebView")) {
            str2 = str + " iBoxWebView";
        }
        String str3 = str2;
        if (!str2.contains("iboxVersion=")) {
            str3 = str2 + " iboxVersion=" + LocalControlTool.e(false) + "; ";
        }
        LogTool.a("##  WebView User_Agent: " + str3);
        settings.setUserAgentString(str3);
        this.i.setWebViewClient(new BridgeWebViewClient(this, this.i) { // from class: com.ibox.nft.base.jsbridge.IBoxBridgeWebView.4

            /* renamed from: b  reason: collision with root package name */
            public final IBoxBridgeWebView f401b;

            {
                this.f401b = this;
            }

            public void onPageFinished(WebView webView, String str4) {
                IBoxBridgeWebView.super.onPageFinished(webView, str4);
                this.f401b.v.cancel();
                IBoxBridgeWebView iBoxBridgeWebView = this.f401b;
                iBoxBridgeWebView.U.removeCallbacks(iBoxBridgeWebView.V);
                if (this.f401b.j != null) {
                    this.f401b.j.setVisibility(8);
                }
                if (this.f401b.i != null) {
                    this.f401b.i.getSettings().setBlockNetworkImage(false);
                }
                this.f401b.O = true;
                this.f401b.x("onPageFinished");
            }

            public void onPageStarted(WebView webView, String str4, Bitmap bitmap) {
                IBoxBridgeWebView.super.onPageStarted(webView, str4, bitmap);
                WebViewManager.a().e(this.f401b.c, webView, str4, bitmap);
                this.f401b.v.start();
                this.f401b.j.setVisibility(0);
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }
        });
        this.i.setWebChromeClient(new AnonymousClass5(this));
        this.i.setOnScrollChangedCallback(new BridgeWebView.OnScrollChangedCallback(this) { // from class: d.c.d.d.e.d
            public final IBoxBridgeWebView a;

            {
                this.a = this;
            }

            public final void a(int i2, int i3, int i4, int i5) {
                this.a.I(i2, i3, i4, i5);
            }
        });
    }

    public void x(String str) {
        if (!this.O) {
            LogTool.a("#### initViewAfterWebLoadingFinish  tag: " + str);
        }
    }

    public final void y(View view) {
        this.f397d = view.findViewById(R.id.ll_comn_webview_container);
        this.f398e = (FrameLayout) view.findViewById(R.id.fl_webview_status_bar_container);
        this.f = (FrameLayout) view.findViewById(R.id.fl_title_status_bar_container);
        this.g = view.findViewById(R.id.rl_title_panel);
        this.h = view.findViewById(R.id.v_title_line);
        this.i = view.findViewById(R.id.web_wv);
        this.j = (ProgressBar) view.findViewById(R.id.web_progress);
        this.k = (FrameLayout) view.findViewById(R.id.fl_webview_panel);
        this.l = (FrameLayout) view.findViewById(R.id.fl_oprate_container);
        this.m = (ImageView) view.findViewById(R.id.iv_left_back);
        this.n = view.findViewById(R.id.v_close_line);
        this.o = (ImageView) view.findViewById(R.id.iv_left_close);
        this.p = (ImageView) view.findViewById(R.id.iv_right_icon);
        this.q = (TextView) view.findViewById(R.id.tv_right_text);
        this.r = (LinearLayout) view.findViewById(R.id.ll_right);
        this.s = (TextView) view.findViewById(R.id.tv_title);
        this.t = view.findViewById(R.id.rl_network_error);
    }
}
