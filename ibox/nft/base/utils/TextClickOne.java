package com.ibox.nft.base.utils;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ibox.libs.common.BaseApplication;
import com.ibox.libs.common.utils.ClickTool;
import com.ibox.libs.common.utils.NavigationTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

/* loaded from: TextClickOne.class */
public class TextClickOne extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public String f428b;

    public TextClickOne(String str) {
        this.f428b = str;
    }

    @Override // android.text.style.ClickableSpan
    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!ClickTool.a()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", this.f428b + "");
        NavigationTool.e(BaseApplication.b(), "/ibox_app/activity/commonWebActivity", bundle);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }
}
