package com.ibox.nft.base.common;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ibox.libs.common.manager.AppManager;
import com.ibox.libs.common.manager.ForegroundDetector;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.PixelTool;
import com.ibox.libs.common.utils.PossiblyResizeTool;
import com.ibox.libs.widgets.dialog.BaseDialogAppCompatFragment;
import com.ibox.nft.base.R;
import com.ibox.nft.base.common.IBoxBaseActivity;
import com.ibox.nft.base.event.EventBusCenter;
import com.ibox.nft.base.mvp.IBoxActivityPresenter;
import com.ibox.nft.base.mvp.IBoxMVPActivity;
import com.ibox.nft.base.mvp.IBoxUI;
import com.ibox.nft.base.utils.IBoxNightHelper;
import com.ibox.nft.base.utils.IBoxUIHandler;
import com.ibox.nft.base.utils.IntentSafeUtils;
import com.ibox.nft.base.widgets.dialog.loading.LoadingDialog;
import com.ibox.nft.base.widgets.dialog.loading.LoadingDialogOld;
import com.stub.StubApp;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import pub.devrel.easypermissions.EasyPermissions;
import qiu.niorgai.StatusBarCompat;
import rx.subjects.BehaviorSubject;

/* loaded from: IBoxBaseActivity.class */
public abstract class IBoxBaseActivity<P extends IBoxActivityPresenter<V>, V extends IBoxUI> extends IBoxMVPActivity<P, V> implements IBoxUI, BaseDialogAppCompatFragment.DialogFragmentListener, ForegroundDetector.Listener, EasyPermissions.PermissionCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public Unbinder f386e;
    public boolean f;
    public LoadingDialog h;
    public LoadingDialogOld i;
    public View j;
    public BehaviorSubject<Integer> g = BehaviorSubject.create();
    public Runnable k = new Runnable(this) { // from class: d.c.d.d.b.m

        /* renamed from: b  reason: collision with root package name */
        public final IBoxBaseActivity f1140b;

        {
            this.f1140b = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1140b.E1();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1 */
    public /* synthetic */ void C1() {
        try {
            LoadingDialog loadingDialog = this.h;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.i == null) {
            IBoxUIHandler.a().g(this.k);
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: F1 */
    public /* synthetic */ void G1(boolean z) {
        try {
            LoadingDialog loadingDialog = this.h;
            if (loadingDialog != null && loadingDialog.isShowing()) {
                this.h.dismiss();
                this.h = null;
            }
            if (this.h == null) {
                this.h = new LoadingDialog(this);
                if (q1()) {
                    Window window = this.h.getWindow();
                    if (window != null) {
                        window.setFlags(131072, 131072);
                    } else {
                        return;
                    }
                }
            }
            this.h.show();
            this.h.setCanceledOnTouchOutside(z);
            this.h.setCancelable(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int v1(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        int i = dimensionPixelSize;
        if (dimensionPixelSize <= 0) {
            i = PixelTool.a(25.0f);
        }
        return i;
    }

    public boolean A1() {
        return false;
    }

    public void C() {
    }

    public void H1() {
        if (r1()) {
            PossiblyResizeTool.a(findViewById(16908290));
        }
    }

    public void I1(int i) {
        View view = this.j;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void J1() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void K0() {
        LogTool.a("###### ----------- 应用推入后台 --------------");
    }

    public boolean K1() {
        return false;
    }

    @Override // com.ibox.nft.base.mvp.IBoxUI
    @UiThread
    public void M0(String str, final boolean z, int i) {
        IBoxUIHandler.a().c(new Runnable(this, z) { // from class: d.c.d.d.b.o

            /* renamed from: b  reason: collision with root package name */
            public final IBoxBaseActivity f1142b;
            public final boolean c;

            {
                this.f1142b = this;
                this.c = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1142b.G1(this.c);
            }
        });
        IBoxUIHandler.a().f(this.k, i);
    }

    public void O0() {
        LogTool.a("###### ----------- 应用回到前台 --------------");
    }

    @Override // com.ibox.nft.base.mvp.IBoxUI
    @UiThread
    /* renamed from: V */
    public void D1() {
        IBoxUIHandler.a().c(new Runnable(this) { // from class: d.c.d.d.b.n

            /* renamed from: b  reason: collision with root package name */
            public final IBoxBaseActivity f1141b;

            {
                this.f1141b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1141b.C1();
            }
        });
    }

    @Override // com.ibox.nft.base.mvp.IBoxUI
    public void a0(int i) {
        M0(null, false, i);
    }

    public void attachBaseContext(Context context) {
        IBoxBaseActivity.super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        IBoxBaseActivity.super.finish();
        overridePendingTransition(R.anim.in_from_left_anim, R.anim.out_to_right_anim);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity
    public void g1() {
        setContentView(t1());
        this.f386e = ButterKnife.bind(this);
        y1();
        o1();
        p1();
    }

    public abstract void o1();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity, com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onCreate(Bundle bundle) {
        x1();
        super.onCreate(bundle);
        ForegroundDetector.b().a(this);
        if (!IntentSafeUtils.a(getIntent())) {
            finish();
        }
        AppManager.b().a(this);
        H1();
        if (A1() && !EventBus.c().j(this)) {
            EventBus.c().p(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity, com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onDestroy() {
        this.g.onNext(5);
        AppManager.b().c(this);
        IBoxUIHandler.a().g(this.k);
        super.onDestroy();
        ForegroundDetector.b().c(this);
        Unbinder unbinder = this.f386e;
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (A1() && EventBus.c().j(this)) {
            EventBus.c().r(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusCenter eventBusCenter) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent intent) {
        IBoxBaseActivity.super.onNewIntent(intent);
        setIntent(intent);
        if (!IntentSafeUtils.a(getIntent())) {
            finish();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity, com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onPause() {
        this.f = false;
        this.g.onNext(3);
        super.onPause();
    }

    public void onPermissionsDenied(int i, @NonNull List<String> list) {
    }

    public void onPermissionsGranted(int i, @NonNull List<String> list) {
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity, com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onResume() {
        super.onResume();
        this.g.onNext(2);
        this.f = true;
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity, com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onStart() {
        super.onStart();
        LogTool.b("ACTION-PAGE", "[ActivityStart]" + getClass().getName());
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPActivity, com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onStop() {
        super.onStop();
        LogTool.b("ACTION-PAGE", "[ActivityStop]" + getClass().getName());
    }

    public void p1() {
    }

    public boolean q1() {
        return false;
    }

    public boolean r1() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s1(boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            return;
        }
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContentView(int i) {
        if (r1()) {
            ViewGroup u1 = u1();
            LayoutInflater.from(this).inflate(i, u1, true);
            IBoxBaseActivity.super.setContentView(u1);
            return;
        }
        IBoxBaseActivity.super.setContentView(i);
    }

    public void setContentView(View view) {
        if (r1()) {
            ViewGroup u1 = u1();
            u1.addView(view, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            IBoxBaseActivity.super.setContentView(u1);
            return;
        }
        IBoxBaseActivity.super.setContentView(view);
    }

    public abstract int t1();

    /* JADX WARN: Multi-variable type inference failed */
    public ViewGroup u1() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        View view = this.j;
        if (view != null) {
            linearLayout.removeView(view);
        }
        this.j = new View(this);
        I1(getResources().getColor(R.color.app_bg));
        linearLayout.addView(this.j, new LinearLayout.LayoutParams(-1, v1(this)));
        return linearLayout;
    }

    public void w1() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x1() {
        if (!r1()) {
            return;
        }
        if (K1()) {
            StatusBarCompat.translucentStatusBar(this, true);
            StatusBarCompat.cancelLightStatusBar(this);
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    getWindow().setAttributes(attributes);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (z1()) {
                StatusBarCompat.cancelLightStatusBar(this);
            } else {
                StatusBarCompat.changeToLightStatusBar(this);
            }
        } else {
            getWindow().addFlags(67108864);
            s1(!z1());
        }
    }

    public void y() {
    }

    public abstract void y1();

    public void z() {
    }

    public boolean z1() {
        return IBoxNightHelper.c().d();
    }
}
