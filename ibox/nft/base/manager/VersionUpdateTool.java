package com.ibox.nft.base.manager;

import com.ibox.libs.common.manager.LocalControlTool;
import com.ibox.libs.common.manager.SpBaseManager;
import com.ibox.libs.common.utils.ToastTool;
import com.ibox.nft.base.manager.download.VersionDownloadTool;
import com.ibox.nft.network.base.api.bean.IBoxVersionInfo;
import com.igexin.push.core.c;

/* loaded from: VersionUpdateTool.class */
public final class VersionUpdateTool {
    public static VersionUpdateTool a;

    /* renamed from: b  reason: collision with root package name */
    public IBoxVersionInfo f403b;

    /* loaded from: VersionUpdateTool$CheckCallback.class */
    public interface CheckCallback {
        void a(IBoxVersionInfo iBoxVersionInfo);
    }

    public static VersionUpdateTool b() {
        if (a == null) {
            synchronized (VersionUpdateTool.class) {
                try {
                    if (a == null) {
                        a = new VersionUpdateTool();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static void f() {
        SpBaseManager.f().g("VersionName", "");
        SpBaseManager.f().g("MustUpdate", "");
        SpBaseManager f = SpBaseManager.f();
        Boolean bool = Boolean.FALSE;
        f.g("HasNewVersion", bool);
        SpBaseManager.f().g("UserIsIgnore", bool);
    }

    public final void a(CheckCallback checkCallback) {
        IBoxVersionInfo iBoxVersionInfo = this.f403b;
        if (iBoxVersionInfo != null) {
            boolean z = false;
            if (VersionDownloadTool.a(iBoxVersionInfo.getVerCode(), LocalControlTool.e(false)) == 1) {
                z = true;
            }
            if (z && checkCallback != null) {
                checkCallback.a(this.f403b);
            }
        }
    }

    public String c() {
        return (String) SpBaseManager.f().e("MustUpdate", "");
    }

    public String d() {
        return (String) SpBaseManager.f().e("VersionName", "");
    }

    public final void e(String str) {
        boolean z = false;
        if (VersionDownloadTool.a(str, LocalControlTool.e(false)) == 1) {
            z = true;
        }
        if (z) {
            SpBaseManager.f().g("HasNewVersion", Boolean.TRUE);
        } else {
            SpBaseManager.f().g("HasNewVersion", Boolean.FALSE);
        }
    }

    public void g(IBoxVersionInfo iBoxVersionInfo) {
        if (iBoxVersionInfo != null) {
            this.f403b = iBoxVersionInfo;
            String verCode = iBoxVersionInfo.getVerCode();
            String verUpdate = iBoxVersionInfo.getVerUpdate();
            SpBaseManager.f().g("VersionName", verCode);
            SpBaseManager.f().g("MustUpdate", verUpdate);
            if (c.f613e.equals(verUpdate)) {
                SpBaseManager.f().g("UserIsIgnore", Boolean.FALSE);
            } else if ("1".equals(verUpdate)) {
                e(verCode);
            } else if ("2".equals(verUpdate)) {
                e(verCode);
            } else {
                f();
            }
        }
    }

    public void h(boolean z) {
        SpBaseManager.f().g("UserIsIgnore", Boolean.valueOf(z));
    }

    public void i(CheckCallback checkCallback, boolean z, boolean z2) {
        IBoxVersionInfo iBoxVersionInfo = this.f403b;
        if (iBoxVersionInfo != null) {
            if (checkCallback == null) {
                ToastTool.f("回调不能为空");
                return;
            }
            String verUpdate = iBoxVersionInfo.getVerUpdate();
            if (c.f613e.equals(verUpdate)) {
                SpBaseManager.f().g("UserIsIgnore", Boolean.FALSE);
                a(checkCallback);
            } else if ("1".equals(verUpdate)) {
                if (!z) {
                    a(checkCallback);
                } else if (!((Boolean) SpBaseManager.f().e("UserIsIgnore", Boolean.FALSE)).booleanValue()) {
                    a(checkCallback);
                }
            } else if (!"2".equals(verUpdate)) {
            } else {
                if (z2) {
                    a(checkCallback);
                } else if (!z) {
                    ToastTool.f(LocalControlTool.i("dialog_nyjszxbb"));
                }
            }
        }
    }
}
