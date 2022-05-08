package com.ibox.nft.base.flutter;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.activity.IBoxFlutterBoostActivity;
import com.ibox.nft.base.flutter.IBoxFlutterModuleConfig;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import d.d.a.c0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs$BackgroundMode;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashMap;
import java.util.Map;

/* loaded from: IBoxFlutterModuleConfig.class */
public final class IBoxFlutterModuleConfig {
    public static IBoxFlutterModuleConfig a;

    /* renamed from: b  reason: collision with root package name */
    public static FlutterEngine f394b;
    public IFlutterPushEventHandler c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, IFlutterPushEventHandler> f395d = new HashMap();

    public static IBoxFlutterModuleConfig e() {
        if (a == null) {
            synchronized (IBoxFlutterModuleConfig.class) {
                try {
                    if (a == null) {
                        a = new IBoxFlutterModuleConfig();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static /* synthetic */ void g(FlutterBoost.Callback callback, FlutterEngine flutterEngine) {
        LogTool.a("######  [Flutter_Config]  FlutterEngine ------- callback");
        flutterEngine.getPlugins();
        f394b = flutterEngine;
        if (callback != null) {
            callback.a(flutterEngine);
        }
        FlutterEngineTool.c().h(flutterEngine);
    }

    public void c(String str, IFlutterPushEventHandler iFlutterPushEventHandler) {
        this.f395d.put(str, iFlutterPushEventHandler);
    }

    public FlutterEngine d() {
        return f394b;
    }

    public void f(Application application, final FlutterBoost.Callback callback) {
        FlutterBoost.g().l(application, new FlutterBoostDelegate(this) { // from class: com.ibox.nft.base.flutter.IBoxFlutterModuleConfig.1
            public final IBoxFlutterModuleConfig a;

            {
                this.a = this;
            }

            @Override // com.idlefish.flutterboost.FlutterBoostDelegate
            public /* synthetic */ boolean a(FlutterBoostRouteOptions flutterBoostRouteOptions) {
                return c0.a(this, flutterBoostRouteOptions);
            }

            @Override // com.idlefish.flutterboost.FlutterBoostDelegate
            public void b(FlutterBoostRouteOptions flutterBoostRouteOptions) {
                LogTool.a("##### IBoxSystemConfig ------- pushNativeRoute");
                if (flutterBoostRouteOptions != null) {
                    Activity d2 = FlutterBoost.g().d();
                    if (this.a.c != null) {
                        this.a.c.a(d2, flutterBoostRouteOptions.c(), flutterBoostRouteOptions.d(), flutterBoostRouteOptions.e(), flutterBoostRouteOptions.b(), flutterBoostRouteOptions.a());
                    }
                    for (Map.Entry entry : this.a.f395d.entrySet()) {
                        if (entry.getValue() != null) {
                            ((IFlutterPushEventHandler) entry.getValue()).a(d2, flutterBoostRouteOptions.c(), flutterBoostRouteOptions.d(), flutterBoostRouteOptions.e(), flutterBoostRouteOptions.b(), flutterBoostRouteOptions.a());
                        }
                    }
                }
            }

            @Override // com.idlefish.flutterboost.FlutterBoostDelegate
            public void c(FlutterBoostRouteOptions flutterBoostRouteOptions) {
                LogTool.a("##### IBoxSystemConfig ------------- pushFlutterRoute");
                if (flutterBoostRouteOptions != null) {
                    String str = "";
                    String e2 = TextUtils.isEmpty(flutterBoostRouteOptions.e()) ? "" : flutterBoostRouteOptions.e();
                    if (!TextUtils.isEmpty(flutterBoostRouteOptions.c())) {
                        str = flutterBoostRouteOptions.c();
                    }
                    Map<String, Object> a2 = flutterBoostRouteOptions.a();
                    Map<String, Object> map = a2;
                    if (a2 == null) {
                        map = new HashMap<>();
                    }
                    LogTool.a("##### IBoxSystemConfig_pushFlutterRoute uniqueId: " + e2 + ", pageName: " + str + ", urlParams: " + map);
                    Activity d2 = FlutterBoost.g().d();
                    d2.startActivity(new FlutterBoostActivity.CachedEngineIntentBuilder(IBoxFlutterBoostActivity.class).a(FlutterActivityLaunchConfigs$BackgroundMode.opaque).c(false).d(e2).e(str).f(map).b(d2));
                }
            }
        }, new FlutterBoost.Callback(callback) { // from class: d.c.d.d.c.b
            public final FlutterBoost.Callback a;

            {
                this.a = callback;
            }

            @Override // com.idlefish.flutterboost.FlutterBoost.Callback
            public final void a(FlutterEngine flutterEngine) {
                IBoxFlutterModuleConfig.g(this.a, flutterEngine);
            }
        });
    }
}
