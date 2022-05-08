package com.ibox.nft.base.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.StringTool;
import com.ibox.libs.common.utils.ToastTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.config.OpenWebUrlAddress;
import com.ibox.nft.base.manager.VersionUpdateTool;
import com.ibox.nft.base.manager.download.DownloadApkUtils;
import com.ibox.nft.base.manager.download.VersionDownloadTool;
import com.ibox.nft.base.utils.DialogTool;
import com.ibox.nft.network.base.api.bean.IBoxVersionInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: DialogTool.class */
public final class DialogTool {
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static Dialog f424b;

    /* loaded from: DialogTool$OnUpdateDialogClickListener.class */
    public interface OnUpdateDialogClickListener {
        boolean a(View view);
    }

    @SuppressLint({"ResourceType"})
    public static Dialog A(Context context, CharSequence charSequence, boolean z) {
        return B(context, charSequence, z, null);
    }

    @SuppressLint({"ResourceType"})
    public static Dialog B(Context context, CharSequence charSequence, boolean z, final DialogInterface.OnDismissListener onDismissListener) {
        if (!ContextTool.c(context)) {
            return null;
        }
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(z);
        dialog.setCanceledOnTouchOutside(z);
        View inflate = View.inflate(context, R.layout.dialog_plain_text_view, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_plain_text);
        textView.setText(charSequence);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        dialog.setContentView(inflate);
        try {
            dialog.show();
        } catch (Exception e2) {
            LogTool.c(e2.getMessage());
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener(onDismissListener) { // from class: d.c.d.d.h.n

            /* renamed from: b  reason: collision with root package name */
            public final DialogInterface.OnDismissListener f1167b;

            {
                this.f1167b = onDismissListener;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogTool.l(this.f1167b, dialogInterface);
            }
        });
        return dialog;
    }

    @SuppressLint({"ResourceType"})
    public static Dialog C(Context context, String str, CharSequence charSequence, String str2, @DrawableRes int i, final View.OnClickListener onClickListener) {
        if (!ContextTool.c(context)) {
            return null;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        View inflate = View.inflate(context, R.layout.dialog_single_btn_confirm, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_msg_content);
        if (TextUtils.isEmpty(charSequence)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(charSequence);
        }
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
        ((ImageView) inflate.findViewById(R.id.iv_cancel_icon)).setOnClickListener(new View.OnClickListener(dialog) { // from class: d.c.d.d.h.d

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1158b;

            {
                this.f1158b = dialog;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.m(this.f1158b, view);
            }
        });
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(str2)) {
            textView3.setText(str2);
        }
        if (-1 != i) {
            textView3.setBackgroundResource(i);
        }
        textView3.setOnClickListener(new View.OnClickListener(dialog, onClickListener) { // from class: d.c.d.d.h.l

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1165b;
            public final View.OnClickListener c;

            {
                this.f1165b = dialog;
                this.c = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.n(this.f1165b, this.c, view);
            }
        });
        dialog.setContentView(inflate);
        try {
            dialog.show();
        } catch (Exception e2) {
            LogTool.c(e2.getMessage());
        }
        return dialog;
    }

    public static void D(Activity activity) {
        if (ContextTool.a(activity)) {
            KeyboardTool.a(activity);
            Dialog dialog = new Dialog(activity, R.style.dialog_full_screen_style);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            View inflate = View.inflate(activity, R.layout.dialog_system_maintain, null);
            dialog.setCancelable(false);
            dialog.setContentView(inflate);
            dialog.show();
        }
    }

    public static Dialog E(final Context context, IBoxVersionInfo iBoxVersionInfo, final OnUpdateDialogClickListener onUpdateDialogClickListener, final OnUpdateDialogClickListener onUpdateDialogClickListener2) {
        c();
        if (!ContextTool.c(context) || iBoxVersionInfo == null) {
            return null;
        }
        final Dialog dialog = new Dialog(context, R.style.dialog_full_screen_style);
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        View inflate = View.inflate(context, R.layout.dialog_version_update, null);
        ((TextView) inflate.findViewById(R.id.tv_update_apk_info)).setText("");
        ((TextView) inflate.findViewById(R.id.tv_update_code)).setText(iBoxVersionInfo.getVerCode());
        TextView textView = (TextView) inflate.findViewById(R.id.tv_update_log);
        textView.setText(iBoxVersionInfo.getDesc());
        textView.setVisibility(StringTool.d(iBoxVersionInfo.getDesc()) ^ true ? 0 : 8);
        ((Button) inflate.findViewById(R.id.btn_update)).setOnClickListener(new View.OnClickListener(context, onUpdateDialogClickListener, dialog) { // from class: d.c.d.d.h.j

            /* renamed from: b  reason: collision with root package name */
            public final Context f1163b;
            public final DialogTool.OnUpdateDialogClickListener c;

            /* renamed from: d  reason: collision with root package name */
            public final Dialog f1164d;

            {
                this.f1163b = context;
                this.c = onUpdateDialogClickListener;
                this.f1164d = dialog;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.r(this.f1163b, this.c, this.f1164d, view);
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_cancel_btn);
        imageView.setOnClickListener(new View.OnClickListener(onUpdateDialogClickListener2, dialog) { // from class: d.c.d.d.h.m

            /* renamed from: b  reason: collision with root package name */
            public final DialogTool.OnUpdateDialogClickListener f1166b;
            public final Dialog c;

            {
                this.f1166b = onUpdateDialogClickListener2;
                this.c = dialog;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.s(this.f1166b, this.c, view);
            }
        });
        if (iBoxVersionInfo.isForcedUpdate()) {
            imageView.setVisibility(4);
            imageView.setClickable(false);
        }
        dialog.setCancelable(false);
        dialog.setContentView(inflate);
        dialog.show();
        return dialog;
    }

    public static void F(final Activity activity, IBoxVersionInfo iBoxVersionInfo, boolean z, boolean z2) {
        if (ContextTool.a(activity) && iBoxVersionInfo != null) {
            KeyboardTool.a(activity);
            VersionUpdateTool.b().i(new VersionUpdateTool.CheckCallback(activity) { // from class: d.c.d.d.h.k
                public final Activity a;

                {
                    this.a = activity;
                }

                @Override // com.ibox.nft.base.manager.VersionUpdateTool.CheckCallback
                public final void a(IBoxVersionInfo iBoxVersionInfo2) {
                    DialogTool.f424b = DialogTool.E(r0, iBoxVersionInfo2, new DialogTool.OnUpdateDialogClickListener(iBoxVersionInfo2, this.a) { // from class: d.c.d.d.h.i
                        public final IBoxVersionInfo a;

                        /* renamed from: b  reason: collision with root package name */
                        public final Activity f1162b;

                        {
                            this.a = iBoxVersionInfo2;
                            this.f1162b = r5;
                        }

                        @Override // com.ibox.nft.base.utils.DialogTool.OnUpdateDialogClickListener
                        public final boolean a(View view) {
                            return DialogTool.o(this.a, this.f1162b, view);
                        }
                    }, h.a);
                }
            }, z, z2);
        }
    }

    public static void c() {
        Dialog dialog = f424b;
        if (dialog != null && dialog.isShowing()) {
            f424b.dismiss();
            f424b.cancel();
            f424b = null;
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(Dialog dialog, View.OnClickListener onClickListener, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(Dialog dialog, View.OnClickListener onClickListener, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(Dialog dialog, View.OnClickListener onClickListener, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void g(Dialog dialog, View.OnClickListener onClickListener, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(Dialog dialog, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void i(DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface) {
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(Dialog dialog, View.OnClickListener onClickListener, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(Dialog dialog, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void l(DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface) {
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(Dialog dialog, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void n(Dialog dialog, View.OnClickListener onClickListener, View view) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean o(IBoxVersionInfo iBoxVersionInfo, Activity activity, View view) {
        String downUrl = iBoxVersionInfo.getDownUrl();
        if (TextUtils.isEmpty(downUrl)) {
            return true;
        }
        String d2 = OpenWebUrlAddress.d(downUrl);
        if (!d2.trim().startsWith("http://") && !d2.trim().startsWith("https://")) {
            return true;
        }
        if (!d2.trim().endsWith(".apk")) {
            VersionDownloadTool.d(activity, d2);
            return true;
        }
        a = System.currentTimeMillis();
        VersionDownloadTool.l(activity, "正在下载", null);
        DownloadApkUtils.q().p(activity, d2, new DownloadApkUtils.OnProgressListener(activity) { // from class: com.ibox.nft.base.utils.DialogTool.1
            public final Activity a;

            {
                this.a = activity;
            }

            @Override // com.ibox.nft.base.manager.download.DownloadApkUtils.OnProgressListener
            public void b(String str) {
                long unused = DialogTool.a = 0L;
                VersionDownloadTool.c(this.a);
            }

            @Override // com.ibox.nft.base.manager.download.DownloadApkUtils.OnProgressListener
            public void c(int i, int i2) {
                long unused = DialogTool.a = System.currentTimeMillis();
                VersionDownloadTool.k(i, i2);
            }

            @Override // com.ibox.nft.base.manager.download.DownloadApkUtils.OnProgressListener
            public void d(int i) {
                if (System.currentTimeMillis() - DialogTool.a >= 300000) {
                    if (i == 2) {
                        ToastTool.f(StringTool.b(R.string.download_pause_net));
                        return;
                    }
                    ToastTool.f(StringTool.b(R.string.download_pause));
                    VersionDownloadTool.c(this.a);
                }
            }

            @Override // com.ibox.nft.base.manager.download.DownloadApkUtils.OnProgressListener
            public void onError() {
                long unused = DialogTool.a = 0L;
                ToastTool.f("下载出错");
                VersionDownloadTool.c(this.a);
            }
        });
        return true;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void r(Context context, OnUpdateDialogClickListener onUpdateDialogClickListener, Dialog dialog, View view) {
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (!EasyPermissions.hasPermissions(context, strArr)) {
            EasyPermissions.requestPermissions((Activity) context, StringTool.b(R.string.activity_main_permission_storage), 100, strArr);
        } else if (onUpdateDialogClickListener != null && onUpdateDialogClickListener.a(view) && dialog.isShowing()) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void s(OnUpdateDialogClickListener onUpdateDialogClickListener, Dialog dialog, View view) {
        if (onUpdateDialogClickListener != null && onUpdateDialogClickListener.a(view) && dialog.isShowing()) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SuppressLint({"ResourceType"})
    public static Dialog t(Context context, CharSequence charSequence, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        return w(context, "", charSequence, false, StringTool.b(R.string.p_sdk_cancel), StringTool.b(R.string.p_sdk_confirm), onClickListener, onClickListener2);
    }

    @SuppressLint({"ResourceType"})
    public static Dialog u(Context context, String str, SpannableStringBuilder spannableStringBuilder, boolean z, @DrawableRes int i, @DrawableRes int i2, String str2, String str3, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        if (!ContextTool.c(context)) {
            return null;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(z);
        View inflate = View.inflate(context, R.layout.dialog_confirm_tips, null);
        if (i2 > 0) {
            inflate.findViewById(R.id.rl_dialog_root_view).setBackgroundResource(i2);
        }
        if (i > 0) {
            ((ImageView) inflate.findViewById(R.id.iv_icon)).setImageResource(i);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_msg_content);
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(spannableStringBuilder);
        }
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_confirm);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_cancel);
        if (!TextUtils.isEmpty(str2)) {
            textView4.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            textView3.setText(str3);
        }
        textView4.setOnClickListener(new View.OnClickListener(dialog, onClickListener) { // from class: d.c.d.d.h.f

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1160b;
            public final View.OnClickListener c;

            {
                this.f1160b = dialog;
                this.c = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.f(this.f1160b, this.c, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(dialog, onClickListener2) { // from class: d.c.d.d.h.c

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1157b;
            public final View.OnClickListener c;

            {
                this.f1157b = dialog;
                this.c = onClickListener2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.g(this.f1157b, this.c, view);
            }
        });
        dialog.setContentView(inflate);
        try {
            dialog.show();
        } catch (Exception e2) {
            LogTool.c(e2.getMessage());
        }
        return dialog;
    }

    @SuppressLint({"ResourceType"})
    public static Dialog v(Context context, String str, SpannableStringBuilder spannableStringBuilder, boolean z, @DrawableRes int i, String str2, String str3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        return u(context, str, spannableStringBuilder, z, i, 0, str2, str3, onClickListener, onClickListener2);
    }

    @SuppressLint({"ResourceType"})
    public static Dialog w(Context context, String str, CharSequence charSequence, boolean z, String str2, String str3, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        if (!ContextTool.c(context)) {
            return null;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(z);
        View inflate = View.inflate(context, R.layout.dialog_confirm_simple, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_msg_content);
        if (TextUtils.isEmpty(charSequence)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(charSequence);
        }
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_confirm);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_cancel);
        if (!TextUtils.isEmpty(str2)) {
            textView4.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            textView3.setText(str3);
        }
        textView4.setOnClickListener(new View.OnClickListener(dialog, onClickListener) { // from class: d.c.d.d.h.o

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1168b;
            public final View.OnClickListener c;

            {
                this.f1168b = dialog;
                this.c = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.d(this.f1168b, this.c, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(dialog, onClickListener2) { // from class: d.c.d.d.h.b

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1156b;
            public final View.OnClickListener c;

            {
                this.f1156b = dialog;
                this.c = onClickListener2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.e(this.f1156b, this.c, view);
            }
        });
        dialog.setContentView(inflate);
        try {
            dialog.show();
        } catch (Exception e2) {
            LogTool.c(e2.getMessage());
        }
        return dialog;
    }

    @SuppressLint({"ResourceType"})
    public static Dialog x(Context context, int i, CharSequence charSequence, CharSequence charSequence2, boolean z, final DialogInterface.OnDismissListener onDismissListener) {
        if (!ContextTool.c(context)) {
            return null;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(z);
        dialog.setCanceledOnTouchOutside(z);
        View inflate = View.inflate(context, R.layout.dialog_icon_tips_view, null);
        inflate.findViewById(R.id.cl_dialog_root_view).setOnClickListener(new View.OnClickListener(dialog) { // from class: d.c.d.d.h.a

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1155b;

            {
                this.f1155b = dialog;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.h(this.f1155b, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.iv_dialog_icon)).setImageResource(i);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_dialog_title);
        textView.setText(charSequence);
        int i2 = 8;
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_dialog_subtitle);
        textView2.setText(charSequence2);
        if (!TextUtils.isEmpty(charSequence2)) {
            i2 = 0;
        }
        textView2.setVisibility(i2);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(true);
        try {
            dialog.show();
        } catch (Exception e2) {
            LogTool.c(e2.getMessage());
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener(onDismissListener) { // from class: d.c.d.d.h.p

            /* renamed from: b  reason: collision with root package name */
            public final DialogInterface.OnDismissListener f1169b;

            {
                this.f1169b = onDismissListener;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogTool.i(this.f1169b, dialogInterface);
            }
        });
        return dialog;
    }

    @SuppressLint({"ResourceType"})
    public static Dialog y(Context context, int i, CharSequence charSequence, String str, boolean z) {
        return x(context, i, charSequence, str, z, null);
    }

    @SuppressLint({"ResourceType"})
    public static Dialog z(Context context, String str, final View.OnClickListener onClickListener) throws Exception {
        if (!ContextTool.c(context)) {
            return null;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        View inflate = View.inflate(context, R.layout.dialog_confirm_pay, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_amount);
        if (TextUtils.isEmpty(str)) {
            ToastTool.f("金额错误!");
            return dialog;
        }
        textView2.setText(str);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_pay);
        ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener(dialog) { // from class: d.c.d.d.h.e

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1159b;

            {
                this.f1159b = dialog;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.k(this.f1159b, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(dialog, onClickListener) { // from class: d.c.d.d.h.g

            /* renamed from: b  reason: collision with root package name */
            public final Dialog f1161b;
            public final View.OnClickListener c;

            {
                this.f1161b = dialog;
                this.c = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogTool.j(this.f1161b, this.c, view);
            }
        });
        try {
            dialog.setContentView(inflate);
            dialog.show();
            return dialog;
        } catch (Exception e2) {
            LogTool.c(e2.getMessage());
            throw new Exception("Payment confirmation pop-up window is abnormal");
        }
    }
}
