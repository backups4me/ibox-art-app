package com.ibox.nft.base.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.event.EventBusCenter;
import com.ibox.nft.base.mvp.IBoxFragmentPresenter;
import com.ibox.nft.base.mvp.IBoxMVPFragment;
import com.ibox.nft.base.mvp.IBoxUI;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import pub.devrel.easypermissions.EasyPermissions;
import rx.subjects.BehaviorSubject;

/* loaded from: IBoxBaseFragment.class */
public abstract class IBoxBaseFragment<P extends IBoxFragmentPresenter<V>, V extends IBoxUI> extends IBoxMVPFragment<P, V> implements IBoxUI, EasyPermissions.PermissionCallbacks {
    public BehaviorSubject<Integer> k = BehaviorSubject.create();
    public boolean l;

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T extends androidx.fragment.app.Fragment> T L1(java.lang.Class r3, android.os.Bundle r4) {
        /*
            r0 = r3
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.IllegalAccessException -> Lb java.lang.InstantiationException -> L13
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch: java.lang.IllegalAccessException -> Lb java.lang.InstantiationException -> L13
            r3 = r0
            goto L1a
        Lb:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
            goto L18
        L13:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
        L18:
            r0 = 0
            r3 = r0
        L1a:
            r0 = r3
            if (r0 == 0) goto L23
            r0 = r3
            r1 = r4
            r0.setArguments(r1)
        L23:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibox.nft.base.common.IBoxBaseFragment.L1(java.lang.Class, android.os.Bundle):androidx.fragment.app.Fragment");
    }

    public void E1() {
    }

    public void F1() {
    }

    public boolean G1() {
        return false;
    }

    public final boolean H1() {
        return ContextTool.a(getActivity()) && (getActivity() instanceof IBoxBaseActivity);
    }

    @LayoutRes
    public abstract int I1();

    public void J1() {
    }

    public boolean K1() {
        return false;
    }

    @Override // com.ibox.nft.base.mvp.IBoxUI
    public void M0(String str, boolean z, int i) {
        if (H1()) {
            getActivity().M0(str, z, i);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxUI
    public void V() {
        if (H1()) {
            getActivity().D1();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxUI
    public void a0(int i) {
        M0(null, false, i);
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public View o1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(I1(), viewGroup, false);
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (K1() && !EventBus.c().j(this)) {
            EventBus.c().p(this);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (G1() && onCreateView != null) {
            onCreateView.setPadding(0, IBoxBaseActivity.v1(onCreateView.getContext()), 0, 0);
        }
        return onCreateView;
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onDestroy() {
        this.k.onNext(5);
        super.onDestroy();
        if (K1() && EventBus.c().j(this)) {
            EventBus.c().r(this);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onDestroyView() {
        this.k.onNext(9);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusCenter eventBusCenter) {
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onPause() {
        this.k.onNext(3);
        super.onPause();
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsDenied(int i, @NonNull List<String> list) {
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsGranted(int i, @NonNull List<String> list) {
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onResume() {
        super.onResume();
        this.k.onNext(2);
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void r1(View view) {
        super.r1(view);
        setHasOptionsMenu(true);
        J1();
        E1();
        F1();
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    @Override // com.ibox.nft.base.mvp.IBoxMVPFragment, com.ibox.nft.base.mvp.IBoxLazyLoadFragment
    public void y1(boolean z) {
        super.y1(z);
        LogTool.b("ACTION-PAGE", "[onVisibleChangedFinal]" + getClass().getName() + " visible状态：" + z);
        this.l = z;
        if (z) {
            setUserVisibleHint(true);
        }
    }
}
