package com.ibox.nft.base.flutter;

import androidx.annotation.NonNull;
import com.ibox.libs.common.utils.CommonUIHandler;
import com.ibox.libs.common.utils.JsonTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.flutter.FlutterEngineTool;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: FlutterEngineTool.class */
public final class FlutterEngineTool {
    public static FlutterEngineTool a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, SoftReference<MethodChannel>> f393b = new HashMap();
    public volatile MethodChannel c;

    public static FlutterEngineTool c() {
        if (a == null) {
            synchronized (FlutterEngineTool.class) {
                try {
                    if (a == null) {
                        a = new FlutterEngineTool();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(FlutterEngine flutterEngine, String str, Object obj, MethodChannel.Result result) {
        try {
            MethodChannel d2 = d(flutterEngine.getDartExecutor().getBinaryMessenger());
            if (d2 != null) {
                d2.invokeMethod(str, obj, result);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, Map<Object, Object> map) {
        FlutterBoost.g().j(str, map);
    }

    public void b() {
        LogTool.a("######  [notify_flutter_global_config]  ----------- clearFlutterUserInfo()");
        i(IBoxFlutterModuleConfig.e().d(), "ibox_fm_cleanUserInfo", null, null);
    }

    public MethodChannel d(BinaryMessenger binaryMessenger) {
        if (this.c == null) {
            synchronized (MethodChannel.class) {
                try {
                    if (this.c == null) {
                        this.c = new MethodChannel(binaryMessenger, "com.ibox.nft/native_call_flutter");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }

    public void g(Map<Object, Object> map) {
        LogTool.a("######  [notify_flutter_global_config]  ----------- notifyFlutterGlobalConfig()");
        i(IBoxFlutterModuleConfig.e().d(), "ibox_fm_globalConfig", map, null);
    }

    public void h(FlutterEngine flutterEngine) {
        MethodChannel d2;
        if (flutterEngine != null && (d2 = d(flutterEngine.getDartExecutor().getBinaryMessenger())) != null) {
            d2.setMethodCallHandler(new IBoxFlutterMethodCallHandler());
        }
    }

    public void i(@NonNull final FlutterEngine flutterEngine, @NonNull final String str, final Object obj, final MethodChannel.Result result) {
        if (flutterEngine != null) {
            LogTool.a("######  [call_flutter_method]  --- sendMessageToFlutter methodName: " + str + ", params: " + JsonTool.d(obj));
            CommonUIHandler.a().d(new Runnable(this, flutterEngine, str, obj, result) { // from class: d.c.d.d.c.a

                /* renamed from: b  reason: collision with root package name */
                public final FlutterEngineTool f1143b;
                public final FlutterEngine c;

                /* renamed from: d  reason: collision with root package name */
                public final String f1144d;

                /* renamed from: e  reason: collision with root package name */
                public final Object f1145e;
                public final MethodChannel.Result f;

                {
                    this.f1143b = this;
                    this.c = flutterEngine;
                    this.f1144d = str;
                    this.f1145e = obj;
                    this.f = result;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1143b.f(this.c, this.f1144d, this.f1145e, this.f);
                }
            });
        }
    }
}
