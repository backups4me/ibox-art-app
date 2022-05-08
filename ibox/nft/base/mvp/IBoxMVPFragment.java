package com.ibox.nft.base.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ibox.libs.common.utils.Assert;
import com.ibox.libs.common.utils.IBoxViewFinder;
import com.ibox.nft.base.mvp.IBoxFragmentPresenter;
import com.ibox.nft.base.mvp.IBoxUI;
import com.stub.StubApp;

/* loaded from: IBoxMVPFragment.class */
public abstract class IBoxMVPFragment<P extends IBoxFragmentPresenter<V>, V extends IBoxUI> extends IBoxLazyLoadFragment {
    public P h;
    public IBoxViewFinder i;
    public Unbinder j;

    public abstract P B1();

    public P C1() {
        return this.h;
    }

    public abstract V D1();

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        P p = this.h;
        if (p != null) {
            p.p(bundle);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        IBoxMVPFragment.super.onActivityResult(i, i2, intent);
        P p = this.h;
        if (p != null) {
            p.d(i, i2, intent);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.h == null) {
            this.h = B1();
        }
        P p = this.h;
        if (p != null) {
            p.q(context, this);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        P p = this.h;
        if (p != null) {
            p.r(bundle);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onDestroy() {
        super.onDestroy();
        P p = this.h;
        if (p != null) {
            p.e();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onDestroyView() {
        super.onDestroyView();
        P p = this.h;
        if (p != null) {
            p.s();
        }
        Unbinder unbinder = this.j;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onDetach() {
        super.onDetach();
        P p = this.h;
        if (p != null) {
            p.t();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        P p = this.h;
        if (p != null) {
            p.u(z);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onPause() {
        super.onPause();
        P p = this.h;
        if (p != null) {
            p.f();
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        IBoxMVPFragment.super.onRequestPermissionsResult(i, strArr, iArr);
        P p = this.h;
        if (p != null) {
            p.g(i, strArr, iArr);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onResume() {
        super.onResume();
        P p = this.h;
        if (p != null) {
            p.i();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        IBoxMVPFragment.super.onSaveInstanceState(bundle);
        P p = this.h;
        if (p != null) {
            p.j(bundle);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onStart() {
        super.onStart();
        P p = this.h;
        if (p != null) {
            p.k();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onStop() {
        super.onStop();
        P p = this.h;
        if (p != null) {
            p.l();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void p1() {
        Assert.a(getActivity() instanceof IBoxCoreActivity, "请继承BaseCoreActivity");
        P p = this.h;
        if (p != null) {
            p.m((IBoxCoreActivity) getActivity(), D1());
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public /* bridge */ /* synthetic */ View q1() {
        return super.q1();
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void r1(View view) {
        super.r1(view);
        this.i = new IBoxViewFinder(q1());
        ButterKnife.bind(this, q1());
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment, com.ibox.nft.base.mvp.IBoxCoreFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        P p = this.h;
        if (p != null) {
            p.x(z);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment
    public void w1() {
        super.w1();
        P p = this.h;
        if (p != null) {
            p.o();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment
    public void x1(boolean z) {
        super.x1(z);
        P p = this.h;
        if (p != null) {
            p.v(z);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment
    public void y1(boolean z) {
        super.y1(z);
        P p = this.h;
        if (p != null) {
            p.w(z);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxLazyLoadFragment
    public /* bridge */ /* synthetic */ boolean z1() {
        return super.z1();
    }
}
