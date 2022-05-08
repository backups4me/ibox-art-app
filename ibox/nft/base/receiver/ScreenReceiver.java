package com.ibox.nft.base.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.ibox.nft.base.event.EventBusCenter;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import org.greenrobot.eventbus.EventBus;

/* loaded from: ScreenReceiver.class */
public class ScreenReceiver extends BroadcastReceiver {
    public static String a = ScreenReceiver.class.getName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            Log.e(a, "screen off");
            EventBus.c().l(new EventBusCenter(10001018));
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            Log.e(a, "screen on");
            EventBus.c().l(new EventBusCenter(10001019));
        }
    }
}
