package com.ibox.nft.base.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.mvp.IBoxLazyLoadFragment;
import com.ibox.nft.base.utils.IBoxUIHandler;

/* loaded from: IBoxLazyLoadFragment.class */
public abstract class IBoxLazyLoadFragment extends IBoxCoreFragment {
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f421d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f422e = false;
    public Runnable f = new Runnable(this) { // from class: d.c.d.d.g.b

        /* renamed from: b  reason: collision with root package name */
        public final IBoxLazyLoadFragment f1154b;

        {
            this.f1154b = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1154b.t1();
        }
    };
    public Runnable g = new Runnable(this) { // from class: d.c.d.d.g.a

        /* renamed from: b  reason: collision with root package name */
        public final IBoxLazyLoadFragment f1153b;

        {
            this.f1153b = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1153b.v1();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s1 */
    public /* synthetic */ void t1() {
        y1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u1 */
    public /* synthetic */ void v1() {
        y1(false);
    }

    public final void A1(boolean z) {
        if (this.f422e != z) {
            this.f422e = z;
            x1(z);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getUserVisibleHint() && !this.f421d) {
            w1();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        A1(!z && getUserVisibleHint());
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onPause() {
        super.onPause();
        if (isAdded()) {
            A1(false);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void onResume() {
        super.onResume();
        if (isAdded()) {
            A1(!z1() && getUserVisibleHint());
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.c && !this.f421d) {
            w1();
        }
        if (this.c && isAdded()) {
            A1(z && !z1());
        }
    }

    public void w1() {
        this.f421d = true;
    }

    public void x1(boolean z) {
        LogTool.a(getClass().getSimpleName() + "------onVisibleChanged_enter------ visible:" + z);
        IBoxUIHandler.a().g(this.f);
        IBoxUIHandler.a().g(this.g);
        if (z) {
            IBoxUIHandler.a().f(this.f, 50);
        } else {
            IBoxUIHandler.a().f(this.g, 50);
        }
    }

    public void y1(boolean z) {
    }

    public boolean z1() {
        if (getParentFragment() == null) {
            return isHidden();
        }
        boolean z = true;
        if (getParentFragment() instanceof IBoxLazyLoadFragment) {
            boolean z2 = true;
            if (!getParentFragment().z1()) {
                z2 = isHidden();
            }
            return z2;
        }
        if (!isHidden() || !getParentFragment().isHidden()) {
            z = false;
        }
        return z;
    }
}
