package com.ibox.platform.sdk.getui.ui.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.ibox.platform.sdk.R;
import com.ibox.platform.sdk.R$string;
import com.ibox.platform.sdk.getui.GeTuiSdkOpenManager;
import com.ibox.platform.sdk.getui.receiver.AlarmUtils;
import com.ibox.platform.sdk.getui.ui.presenter.AuthInteractor;
import com.ibox.platform.sdk.getui.ui.presenter.HomePresenter;
import com.ibox.platform.sdk.getui.ui.presenter.HomePresenter$HomeView;
import com.igexin.sdk.PushManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

/* loaded from: HomeFragment.class */
public class HomeFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, HomePresenter$HomeView {

    /* renamed from: b  reason: collision with root package name */
    public static final String f529b = HomeFragment.class.getSimpleName();
    public TextView c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f530d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f531e;
    public SharedPreferences f;
    public Toast g;
    public CheckBox h;
    public HomePresenter i;
    public AlarmManager j = (AlarmManager) GeTuiSdkOpenManager.f.getSystemService(NotificationCompat.CATEGORY_ALARM);

    public static HomeFragment q1() {
        return new HomeFragment();
    }

    @Override // com.ibox.platform.sdk.getui.ui.presenter.HomePresenter$HomeView
    public void Q0(String str) {
        r1(str);
        String str2 = f529b;
        Log.i(str2, "onNotificationSendFailed = " + str);
        if (!str.equals("not_auth")) {
            return;
        }
        if (AuthInteractor.a == null || AuthInteractor.a.booleanValue()) {
            r1("鉴权失败,请检查签名参数及本地时间");
            AlarmUtils.a(this.j, false, 5);
            return;
        }
        r1("鉴权失败，请同步本地时间后重启应用");
    }

    @Override // com.ibox.platform.sdk.getui.ui.presenter.HomePresenter$HomeView
    public void Y0(String str) {
        r1(str);
    }

    public final void o1() {
        String charSequence = this.c.getText().toString();
        if (TextUtils.isEmpty(charSequence) || charSequence.equals(getString(R$string.p_sdk_no_client_id))) {
            r1(getString(R$string.p_sdk_cid_empty));
            return;
        }
        ClipboardManager clipboardManager = getActivity() == null ? null : (ClipboardManager) getActivity().getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Label", charSequence));
            r1(getString(R$string.p_sdk_copy_successed));
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    @SensorsDataInstrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            PushManager.getInstance().turnOnPush(getActivity());
            r1(getString(R$string.p_sdk_start));
        } else {
            PushManager.getInstance().turnOffPush(getActivity());
            r1(getString(R$string.p_sdk_stop));
        }
        this.f.edit().putBoolean("isServiceOn", z).apply();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @Override // android.view.View.OnClickListener
    @SensorsDataInstrumented
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_notification) {
            this.i.d();
        } else if (id == R.id.btn_transmission) {
            this.i.e();
        } else if (id == R.id.btn_copy_cid) {
            o1();
        } else if (id == R.id.iv_clear_log) {
            this.f530d.setText("");
            StringBuilder sb = GeTuiSdkOpenManager.n;
            sb.delete(0, sb.length());
            r1(getString(R$string.p_sdk_log_cleared));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, viewGroup, false);
        p1(inflate);
        StringBuilder sb = GeTuiSdkOpenManager.n;
        if (sb != null) {
            this.f530d.append(sb);
        }
        if (!TextUtils.isEmpty(GeTuiSdkOpenManager.f514d)) {
            this.f531e.setText(getString(GeTuiSdkOpenManager.f514d.equals("true") ? R$string.p_sdk_online : R$string.p_sdk_offline));
        }
        if (!TextUtils.isEmpty(GeTuiSdkOpenManager.f515e)) {
            this.c.setText(GeTuiSdkOpenManager.f515e);
        }
        GeTuiSdkOpenManager.i = true;
        return inflate;
    }

    public void onDestroy() {
        HomeFragment.super.onDestroy();
        GeTuiSdkOpenManager.i = false;
        HomePresenter homePresenter = this.i;
        if (homePresenter != null) {
            homePresenter.c();
        }
        Intent intent = new Intent("com.action.auth");
        Context context = GeTuiSdkOpenManager.f;
        PushAutoTrackHelper.hookIntentGetBroadcast(context, 0, intent, 536870912);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 536870912);
        PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, 0, intent, 536870912);
        if (broadcast != null) {
            this.j.cancel(broadcast);
        }
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        HomeFragment.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @SensorsDataInstrumented
    public void onPause() {
        HomeFragment.super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        HomeFragment.super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStop() {
        HomeFragment.super.onStop();
        GeTuiSdkOpenManager.i = false;
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        HomeFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public final void p1(View view) {
        this.i = new HomePresenter(this);
        TextView textView = (TextView) view.findViewById(R.id.tvLog);
        this.f530d = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.c = (TextView) view.findViewById(R.id.tv_clientid);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_sdk_server);
        this.h = checkBox;
        checkBox.setClickable(true);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", 0);
        this.f = sharedPreferences;
        this.h.setChecked(sharedPreferences.getBoolean("isServiceOn", true));
        this.h.setOnCheckedChangeListener(this);
        this.f531e = (TextView) view.findViewById(R.id.tv_cid_state);
        ((Button) view.findViewById(R.id.btn_notification)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.btn_transmission)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.btn_copy_cid)).setOnClickListener(this);
        ((ImageView) view.findViewById(R.id.iv_clear_log)).setOnClickListener(this);
    }

    public final void r1(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (Build.VERSION.SDK_INT >= 28) {
                Toast.makeText(GeTuiSdkOpenManager.f, str, 0).show();
                return;
            }
            Toast toast = this.g;
            if (toast != null) {
                toast.setText(str);
                this.g.setDuration(0);
            } else {
                this.g = Toast.makeText(GeTuiSdkOpenManager.f, str, 0);
            }
            this.g.show();
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        HomeFragment.super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
