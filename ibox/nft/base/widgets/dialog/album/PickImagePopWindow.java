package com.ibox.nft.base.widgets.dialog.album;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.ibox.libs.common.utils.StringTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.dialog.album.PickImagePopWindow;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

/* loaded from: PickImagePopWindow.class */
public class PickImagePopWindow implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Activity f459b;
    public SelectListener c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f460d;

    /* loaded from: PickImagePopWindow$SelectListener.class */
    public interface SelectListener {
        void a(int i);
    }

    public PickImagePopWindow(Activity activity, SelectListener selectListener) {
        this.f459b = null;
        this.c = null;
        this.f460d = null;
        this.f459b = activity;
        this.c = selectListener;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_pickimage_popwindow, (ViewGroup) null, false);
        int i = R.id.tv_take_photo;
        ((TextView) inflate.findViewById(i)).setText(StringTool.b(R.string.dialog_select_photo_pz));
        ((TextView) inflate.findViewById(i)).setOnClickListener(this);
        int i2 = R.id.tv_select_gallery;
        ((TextView) inflate.findViewById(i2)).setText(StringTool.b(R.string.dialog_select_photo_cxclxz));
        ((TextView) inflate.findViewById(i2)).setOnClickListener(this);
        int i3 = R.id.tv_cancel;
        ((TextView) inflate.findViewById(i3)).setText(StringTool.b(R.string.dialog_select_photo_qx));
        ((TextView) inflate.findViewById(i3)).setOnClickListener(this);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2, true);
        this.f460d = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.f460d.setTouchable(true);
        this.f460d.setAnimationStyle(16973910);
        this.f460d.setOnDismissListener(new PopupWindow.OnDismissListener(this) { // from class: d.c.d.d.i.d.b.a

            /* renamed from: b  reason: collision with root package name */
            public final PickImagePopWindow f1178b;

            {
                this.f1178b = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f1178b.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c() {
        d(this.f459b, 1.0f);
    }

    public static void d(Activity activity, float f) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.alpha = f;
            if (f == 1.0f) {
                activity.getWindow().clearFlags(2);
            } else {
                activity.getWindow().addFlags(2);
            }
            activity.getWindow().setAttributes(attributes);
        }
    }

    public void a() {
        PopupWindow popupWindow = this.f460d;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f460d.dismiss();
            d(this.f459b, 1.0f);
        }
    }

    public void e() {
        if (this.f460d != null) {
            this.f460d.showAtLocation(this.f459b.getWindow().getDecorView().findViewById(16908290), 80, 0, 0);
            d(this.f459b, 0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    @SensorsDataInstrumented
    public void onClick(View view) {
        SelectListener selectListener;
        a();
        if (R.id.tv_take_photo == view.getId()) {
            SelectListener selectListener2 = this.c;
            if (selectListener2 != null) {
                selectListener2.a(0);
            }
        } else if (R.id.tv_select_gallery == view.getId() && (selectListener = this.c) != null) {
            selectListener.a(1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
