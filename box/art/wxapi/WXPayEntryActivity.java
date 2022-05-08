package com.box.art.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.platform.sdk.manager.WXSdkOpenManager;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/* loaded from: WXPayEntryActivity.class */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    static {
        StubApp.interface11(9743);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        setIntent(intent);
        WXSdkOpenManager.b().c(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        LogTool.a("### WXPayEntryActivity_onReq  baseReq: " + baseReq);
        WXSdkOpenManager.b().f(this, baseReq);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        LogTool.a("### WXPayEntryActivity_onResp  baseReq: " + baseResp);
        if (baseResp.getType() == 5) {
            WXSdkOpenManager.b().g(this, baseResp);
        }
        finish();
    }
}
