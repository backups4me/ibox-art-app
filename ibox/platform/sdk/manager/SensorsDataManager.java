package com.ibox.platform.sdk.manager;

import android.content.Context;
import com.ibox.libs.common.utils.ChannelTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.platform.sdk.utils.PlatformLogTool;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import org.json.JSONObject;

/* loaded from: SensorsDataManager.class */
public class SensorsDataManager {
    public static String a = "";

    public static void a(Context context, boolean z) {
        PlatformLogTool.a("####### initSensorsDataSDK  isProductModel: " + z);
        a = ChannelTool.a(context);
        try {
            SAConfigOptions sAConfigOptions = new SAConfigOptions(z ? "https://api-data.ibox.art/sa?project=production" : "https://api-data.ibox.art/sa?project=default");
            sAConfigOptions.setAutoTrackEventType(3).enableLog(b(context));
            SensorsDataAPI.startWithConfigOptions(context, sAConfigOptions);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform_type", "Android");
            jSONObject.put("channel", a);
            SensorsDataAPI.sharedInstance().registerSuperProperties(jSONObject);
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean b(Context context) {
        boolean z = false;
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DownloadChannel", a);
            SensorsDataAPI.sharedInstance().trackAppInstall(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(String str) {
        LogTool.a("### -----  神策绑定用户ID ---------");
        SensorsDataAPI.sharedInstance().login(str);
    }
}
