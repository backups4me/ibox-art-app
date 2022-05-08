package com.ibox.platform.sdk.getui.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.ibox.platform.sdk.R;
import com.ibox.platform.sdk.R$string;
import com.ibox.platform.sdk.getui.GeTuiSdkOpenManager;
import com.ibox.platform.sdk.getui.receiver.AlarmReceiver;
import com.ibox.platform.sdk.getui.ui.fragment.AdvancedFunctionFragment;
import com.ibox.platform.sdk.getui.ui.fragment.AppInfoFragment;
import com.ibox.platform.sdk.getui.ui.fragment.HomeFragment;
import com.igexin.sdk.PushConsts;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: GetuiSdkDemoActivity.class */
public class GetuiSdkDemoActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final String f526b = GeTuiSdkOpenManager.l;
    public HomeFragment f;
    public FrameLayout g;
    public FrameLayout h;
    public FrameLayout i;
    public Fragment j;
    public TextView k;
    public ImageView l;
    public final String c = "home";

    /* renamed from: d  reason: collision with root package name */
    public final String f527d = "advanced_function";

    /* renamed from: e  reason: collision with root package name */
    public final String f528e = "app_info";
    public AlarmReceiver m = new AlarmReceiver();

    static {
        StubApp.interface11(4091);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RequiresApi(api = 19)
    public final void V0() {
        boolean g1 = g1(this);
        Log.i("GetuiSdkDemo", "is notification enabled: " + g1);
        if (!g1) {
            Z0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0() {
        File file = new File(getApplicationInfo().nativeLibraryDir + File.separator + "libgetuiext3.so");
        StringBuilder sb = new StringBuilder();
        sb.append("libgetuiext3.so exist = ");
        sb.append(file.exists());
        Log.e("GetuiSdkDemo", sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_go_setting, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setCancelable(false);
        create.show();
        create.getWindow().setContentView(inflate);
        create.findViewById(R.id.tv_go_set).setOnClickListener(new 1(this, create));
        create.findViewById(R.id.tv_cancel).setOnClickListener(new 2(this, create));
    }

    public final void d1() {
        this.g.findViewById(R.id.iv_home).setSelected(false);
        ((TextView) this.g.findViewById(R.id.tv_home)).setTextColor(getResources().getColor(17170444));
        this.h.findViewById(R.id.iv_advanced_function).setSelected(false);
        ((TextView) this.h.findViewById(R.id.tv_advanced_function)).setTextColor(getResources().getColor(17170444));
        this.i.findViewById(R.id.iv_app_info).setSelected(false);
        ((TextView) this.i.findViewById(R.id.tv_app_info)).setTextColor(getResources().getColor(17170444));
    }

    @RequiresApi(api = 19)
    public boolean g1(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public final void init() {
        GeTuiSdkOpenManager.c = new WeakReference<>(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.home_frame);
        this.g = frameLayout;
        frameLayout.setOnClickListener(this);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.advanced_function_frame);
        this.h = frameLayout2;
        frameLayout2.setOnClickListener(this);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.app_info_frame);
        this.i = frameLayout3;
        frameLayout3.setOnClickListener(this);
        this.k = (TextView) findViewById(R.id.tv_title_bar);
        this.l = (ImageView) findViewById(R.id.iv_logo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o1() {
        IntentFilter intentFilter = new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction("com.action.auth");
        registerReceiver(this.m, intentFilter);
    }

    @Override // android.view.View.OnClickListener
    @SensorsDataInstrumented
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.home_frame) {
            q1("home");
            this.k.setText(getResources().getString(R$string.p_sdk_app_title));
            this.l.setVisibility(0);
        } else if (id == R.id.advanced_function_frame) {
            q1("advanced_function");
            this.k.setText(getResources().getString(R$string.p_sdk_tab_two));
            this.l.setVisibility(8);
        } else if (id == R.id.app_info_frame) {
            q1("app_info");
            this.k.setText(getResources().getString(R$string.p_sdk_tab_three));
            this.l.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public native void onCreate(Bundle bundle);

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        GetuiSdkDemoActivity.super.onDestroy();
        AlarmReceiver alarmReceiver = this.m;
        if (alarmReceiver != null) {
            unregisterReceiver(alarmReceiver);
        }
    }

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    /* JADX WARN: Multi-variable type inference failed */
    public final void p1() {
        PackageManager packageManager = getPackageManager();
        boolean z = true;
        boolean z2 = packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", getPackageName()) == 0;
        if (packageManager.checkPermission("android.permission.READ_PHONE_STATE", getPackageName()) != 0) {
            z = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (!z2 || !z) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"}, 0);
        }
    }

    public final void q1(String str) {
        r1(str);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = this.j;
        if (fragment != null) {
            beginTransaction.hide(fragment);
        }
        if (getSupportFragmentManager().findFragmentByTag(str) == null) {
            if (str.equals("home")) {
                HomeFragment q1 = HomeFragment.q1();
                this.f = q1;
                this.j = q1;
            } else if (str.equals("advanced_function")) {
                this.j = AdvancedFunctionFragment.p1();
            } else if (str.equals("app_info")) {
                this.j = AppInfoFragment.p1();
            }
            Log.d("GetuiSdkDemo", "currentFragment: " + this.j.getClass().getSimpleName());
            beginTransaction.add(R.id.fragment_container, this.j, str);
            beginTransaction.show(this.j);
            beginTransaction.commit();
            return;
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
        this.j = findFragmentByTag;
        beginTransaction.show(findFragmentByTag);
        beginTransaction.commit();
    }

    public final void r1(String str) {
        d1();
        if (str.equals("home")) {
            this.g.findViewById(R.id.iv_home).setSelected(true);
            ((TextView) this.g.findViewById(R.id.tv_home)).setTextColor(getResources().getColor(17170451));
        } else if (str.equals("advanced_function")) {
            this.h.findViewById(R.id.iv_advanced_function).setSelected(true);
            ((TextView) this.h.findViewById(R.id.tv_advanced_function)).setTextColor(getResources().getColor(17170451));
        } else if (str.equals("app_info")) {
            this.i.findViewById(R.id.iv_app_info).setSelected(true);
            ((TextView) this.i.findViewById(R.id.tv_app_info)).setTextColor(getResources().getColor(17170451));
        }
    }
}
