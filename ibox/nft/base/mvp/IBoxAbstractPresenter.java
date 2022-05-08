package com.ibox.nft.base.mvp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.ibox.nft.base.mvp.IBoxBaseUI;
import java.lang.ref.WeakReference;

/* loaded from: IBoxAbstractPresenter.class */
public class IBoxAbstractPresenter<V extends IBoxBaseUI> {
    public IBoxCoreActivity a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<V> f418b;

    public IBoxCoreActivity a() {
        return this.a;
    }

    public Resources b() {
        return this.a.getResources();
    }

    public V c() {
        WeakReference<V> weakReference = this.f418b;
        return weakReference == null ? null : weakReference.get();
    }

    public void d(int i, int i2, Intent intent) {
    }

    public void e() {
    }

    public void f() {
    }

    public void g(int i, String[] strArr, int[] iArr) {
    }

    public void h(Bundle bundle) {
    }

    public void i() {
    }

    public void j(Bundle bundle) {
    }

    public void k() {
    }

    public void l() {
    }

    public void m(IBoxCoreActivity iBoxCoreActivity, V v) {
        this.a = iBoxCoreActivity;
        this.f418b = new WeakReference<>(v);
    }
}
