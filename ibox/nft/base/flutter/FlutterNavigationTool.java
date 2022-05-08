package com.ibox.nft.base.flutter;

import androidx.annotation.NonNull;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.FlutterBoostUtils;
import java.util.Map;

/* loaded from: FlutterNavigationTool.class */
public final class FlutterNavigationTool {
    public static void a(@NonNull String str, @NonNull Map<String, Object> map) {
        FlutterBoost.g().i(new FlutterBoostRouteOptions.Builder().i(str).k(FlutterBoostUtils.b(str)).f(map).h(true).j(1000).g());
    }
}
