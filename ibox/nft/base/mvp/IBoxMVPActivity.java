package com.ibox.nft.base.mvp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.ibox.libs.common.utils.IBoxViewFinder;
import com.ibox.nft.base.mvp.IBoxActivityPresenter;
import com.ibox.nft.base.mvp.IBoxBaseUI;
import com.stub.StubApp;

/* loaded from: IBoxMVPActivity.class */
public abstract class IBoxMVPActivity<P extends IBoxActivityPresenter<V>, V extends IBoxBaseUI> extends IBoxCoreActivity {
    public P c;

    /* renamed from: d  reason: collision with root package name */
    public IBoxViewFinder f423d;

    public abstract P Y0();

    public P Z0() {
        return this.c;
    }

    public abstract V d1();

    public abstract void g1();

    public void onActivityResult(int i, int i2, Intent intent) {
        IBoxMVPActivity.super.onActivityResult(i, i2, intent);
        P p = this.c;
        if (p != null) {
            p.d(i, i2, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f423d = new IBoxViewFinder(this);
        g1();
        P Y0 = Y0();
        this.c = Y0;
        if (Y0 != null) {
            Y0.m(this, d1());
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onDestroy() {
        super.onDestroy();
        P p = this.c;
        if (p != null) {
            p.e();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onPause() {
        super.onPause();
        P p = this.c;
        if (p != null) {
            p.f();
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        IBoxMVPActivity.super.onRequestPermissionsResult(i, strArr, iArr);
        P p = this.c;
        if (p != null) {
            p.g(i, strArr, iArr);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        P p = this.c;
        if (p != null) {
            p.h(bundle);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onResume() {
        super.onResume();
        P p = this.c;
        if (p != null) {
            p.i();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        P p = this.c;
        if (p != null) {
            p.j(bundle);
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onStart() {
        super.onStart();
        P p = this.c;
        if (p != null) {
            p.k();
        }
    }

    @Override // com.ibox.nft.base.mvp.IBoxCoreActivity
    public void onStop() {
        super.onStop();
        P p = this.c;
        if (p != null) {
            p.l();
        }
    }
}
