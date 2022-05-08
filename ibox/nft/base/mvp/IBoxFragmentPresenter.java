package com.ibox.nft.base.mvp;

import android.content.Context;
import android.os.Bundle;
import com.ibox.nft.base.mvp.IBoxUI;

/* loaded from: IBoxFragmentPresenter.class */
public abstract class IBoxFragmentPresenter<V extends IBoxUI> extends IBoxAbstractPresenter<V> {
    public IBoxMVPFragment c;

    public IBoxMVPFragment n() {
        return this.c;
    }

    public void o() {
    }

    public void p(Bundle bundle) {
    }

    public void q(Context context, IBoxMVPFragment iBoxMVPFragment) {
        this.c = iBoxMVPFragment;
    }

    public void r(Bundle bundle) {
    }

    public void s() {
    }

    public void t() {
    }

    public void u(boolean z) {
    }

    public void v(boolean z) {
    }

    public void w(boolean z) {
    }

    public void x(boolean z) {
    }
}
