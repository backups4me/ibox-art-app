package com.ibox.nft.base.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.event.EventBusCenter;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import org.greenrobot.eventbus.EventBus;

/* loaded from: NetworkChangeReceiver.class */
public class NetworkChangeReceiver extends BroadcastReceiver {
    public final String a(int i) {
        return i == 0 ? "3G网络数据" : i == 1 ? "WIFI网络" : "";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                Log.e("[NetworkState]", "[NetworkState] Network Disconnect!");
                EventBus.c().l(new EventBusCenter(10001017));
                return;
            }
            NetworkInfo.State state = activeNetworkInfo.getState();
            int type = activeNetworkInfo.getType();
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            String extraInfo = activeNetworkInfo.getExtraInfo();
            StringBuilder sb = new StringBuilder();
            sb.append("[NetworkState] state=");
            sb.append(state);
            sb.append(" typeName=");
            sb.append(typeName);
            String str2 = "";
            if (TextUtils.isEmpty(subtypeName)) {
                str = "";
            } else {
                str = " subtypeName=" + subtypeName;
            }
            sb.append(str);
            if (!TextUtils.isEmpty(extraInfo)) {
                str2 = " extraInfo=" + extraInfo;
            }
            sb.append(str2);
            Log.e("[NetworkState]", sb.toString());
            if (NetworkInfo.State.CONNECTED != activeNetworkInfo.getState() || !activeNetworkInfo.isAvailable()) {
                LogTool.c(a(type) + "断开");
                EventBus.c().l(new EventBusCenter(10001017));
            } else if (type == 1 || type == 0) {
                LogTool.c(a(type) + "连上");
                EventBus.c().l(new EventBusCenter(10001016));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
