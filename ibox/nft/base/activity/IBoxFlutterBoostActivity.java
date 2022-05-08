package com.ibox.nft.base.activity;

import android.content.Intent;
import android.os.Bundle;
import com.ibox.nft.base.event.EventBusCenter;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.stub.StubApp;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: IBoxFlutterBoostActivity.class */
public class IBoxFlutterBoostActivity extends FlutterBoostActivity {
    static {
        StubApp.interface11(3866);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4097 && i2 == -1) {
            finish();
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.c().j(this)) {
            EventBus.c().r(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusCenter eventBusCenter) {
        if (eventBusCenter != null && eventBusCenter.b() == 10001023) {
            finish();
        }
    }
}
