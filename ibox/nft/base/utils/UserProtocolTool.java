package com.ibox.nft.base.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.ibox.libs.common.manager.ActivityStackManager;
import com.ibox.libs.common.manager.LocalControlTool;
import com.ibox.nft.base.config.OpenWebUrlAddress;
import com.ibox.nft.base.manager.SpIBoxAppConfig;
import com.ibox.nft.base.utils.UserProtocolTool;
import com.ibox.platform.sdk.manager.MobSdkOpenManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d.c.d.d.h.t;
import d.c.d.d.h.u;

/* loaded from: UserProtocolTool.class */
public final class UserProtocolTool {
    public static SpannableStringBuilder a(int i) {
        String i2 = LocalControlTool.i("protocol_tips_label");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(LocalControlTool.i("protocol_tips_useable_agreement"));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new TextClickOne(OpenWebUrlAddress.r()), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) i2).append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder b(int i) {
        String i2 = LocalControlTool.i("protocol_label_order_complain");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(LocalControlTool.i("protocol_tips_order_complain"));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new TextClickOne(OpenWebUrlAddress.h()), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) i2).append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(int i) {
        String i2 = LocalControlTool.i("protocol_tips_label");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(LocalControlTool.i("protocol_tips_user_agreement"));
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(LocalControlTool.i("protocol_tips_privacy_agreement"));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new TextClickOne(OpenWebUrlAddress.r()), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder3.length(), 33);
        spannableStringBuilder3.setSpan(new TextClickOne(OpenWebUrlAddress.i()), 0, spannableStringBuilder3.length(), 33);
        spannableStringBuilder.append((CharSequence) i2).append((CharSequence) spannableStringBuilder2).append((CharSequence) "、").append((CharSequence) spannableStringBuilder3);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder d(int i) {
        String i2 = LocalControlTool.i("art_order_agree_service_notice");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(LocalControlTool.i("protocol_tips_service_notice"));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new TextClickOne(OpenWebUrlAddress.k()), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) i2).append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public static void e() {
        SpIBoxAppConfig.c().d("IS_HADED_START_APP", Boolean.TRUE);
        SpIBoxAppConfig.c().d("LAST_USER_PROTOCOL_VERSION", 4);
        MobSdkOpenManager.a().h(null);
    }

    public static boolean f() {
        try {
            return ((Boolean) SpIBoxAppConfig.c().b("IS_HADED_START_APP", Boolean.FALSE)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean g(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        return !activity.isFinishing() && !activity.isDestroyed();
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(View view) {
        ActivityStackManager.e().b();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(View view) {
        e();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(Context context, View view) {
        l(context);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(View.OnClickListener onClickListener, View view) {
        e();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void l(Context context) {
        if (g(context)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) LocalControlTool.i("dialog_user_protocol_exit_tips_1")).append((CharSequence) "\n\n").append((CharSequence) LocalControlTool.i("dialog_user_protocol_exit_tips_2"));
            DialogTool.v(context, LocalControlTool.i("dialog_title_wxts"), spannableStringBuilder, false, -1, LocalControlTool.i("dialog_btn_text_tcyy"), LocalControlTool.i("dialog_btn_text_tybjxsy"), u.f1174b, t.f1173b);
        }
    }

    public static void m(final Context context, final View.OnClickListener onClickListener) {
        if (g(context)) {
            int i = 0;
            try {
                i = ((Integer) SpIBoxAppConfig.c().b("LAST_USER_PROTOCOL_VERSION", 0)).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!f() || i < 4) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) LocalControlTool.i("dialog_user_protocol_show_content_1")).append((CharSequence) "\n\n").append((CharSequence) LocalControlTool.i("dialog_user_protocol_show_content_2")).append((CharSequence) "\n\n").append((CharSequence) LocalControlTool.i("dialog_user_protocol_show_content_3_1")).append((CharSequence) c(Color.parseColor("#1A1A1A"))).append((CharSequence) LocalControlTool.i("dialog_user_protocol_show_content_3_2"));
                DialogTool.v(context, LocalControlTool.i("dialog_title_hyldhx"), spannableStringBuilder, false, -1, LocalControlTool.i("dialog_btn_text_bty"), LocalControlTool.i("dialog_btn_text_ty"), new View.OnClickListener(context) { // from class: d.c.d.d.h.v

                    /* renamed from: b  reason: collision with root package name */
                    public final Context f1175b;

                    {
                        this.f1175b = context;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UserProtocolTool.j(this.f1175b, view);
                    }
                }, new View.OnClickListener(onClickListener) { // from class: d.c.d.d.h.w

                    /* renamed from: b  reason: collision with root package name */
                    public final View.OnClickListener f1176b;

                    {
                        this.f1176b = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UserProtocolTool.k(this.f1176b, view);
                    }
                });
            }
        }
    }
}
