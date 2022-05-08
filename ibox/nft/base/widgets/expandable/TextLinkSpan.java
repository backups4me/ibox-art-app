package com.ibox.nft.base.widgets.expandable;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.ibox.libs.common.utils.NavigationTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

/* loaded from: TextLinkSpan.class */
public class TextLinkSpan extends URLSpan {

    /* renamed from: b  reason: collision with root package name */
    public int f491b = 0;
    public OnLinkSpanClickListener c;

    public TextLinkSpan(String str) {
        super(str);
    }

    public void a(View view, String str) {
        if (!TextUtils.isEmpty(str) && view != null) {
            String str2 = str;
            if (!str.toLowerCase().startsWith("http://")) {
                str2 = str;
                if (!str.toLowerCase().startsWith("https://")) {
                    str2 = "http://" + str;
                }
            }
            Context context = view.getContext();
            Bundle bundle = new Bundle();
            bundle.putString("url", str2);
            NavigationTool.e(context, "/ibox_app/activity/commonWebActivity", bundle);
        }
    }

    public void b(int i) {
        this.f491b = i;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    @SensorsDataInstrumented
    public void onClick(View view) {
        OnLinkSpanClickListener onLinkSpanClickListener = this.c;
        if (onLinkSpanClickListener != null) {
            onLinkSpanClickListener.onClick(getURL());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        try {
            a(view, getURL());
        } catch (Exception e2) {
            e2.printStackTrace();
            super.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            int i = this.f491b;
            if (i == 0) {
                i = textPaint.linkColor;
            }
            textPaint.setColor(i);
            textPaint.setUnderlineText(false);
        }
    }
}
