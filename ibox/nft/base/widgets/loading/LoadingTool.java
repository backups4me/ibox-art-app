package com.ibox.nft.base.widgets.loading;

import android.content.Context;
import android.view.Window;
import androidx.annotation.UiThread;
import com.ibox.nft.base.utils.IBoxUIHandler;
import com.ibox.nft.base.widgets.dialog.loading.LoadingDialog;
import com.ibox.nft.base.widgets.loading.LoadingTool;
import d.c.d.d.i.f.b;
import d.c.d.d.i.f.c;

/* loaded from: LoadingTool.class */
public final class LoadingTool {
    public static LoadingDialog a;

    /* renamed from: b  reason: collision with root package name */
    public static Runnable f492b = b.f1189b;

    public static boolean a() {
        return false;
    }

    @UiThread
    public static void b() {
        IBoxUIHandler.a().c(c.f1190b);
    }

    public static /* synthetic */ void c() {
        try {
            LoadingDialog loadingDialog = a;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        IBoxUIHandler.a().g(f492b);
    }

    public static /* synthetic */ void d(Context context, boolean z) {
        if (context != null) {
            try {
                if (a == null) {
                    a = new LoadingDialog(context);
                    if (a()) {
                        Window window = a.getWindow();
                        if (window != null) {
                            window.setFlags(131072, 131072);
                        } else {
                            return;
                        }
                    }
                }
                a.show();
                a.setCanceledOnTouchOutside(z);
                a.setCancelable(z);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void f(Context context, int i) {
        g(context, null, false, i);
    }

    @UiThread
    public static void g(final Context context, String str, final boolean z, int i) {
        IBoxUIHandler.a().c(new Runnable(context, z) { // from class: d.c.d.d.i.f.a

            /* renamed from: b  reason: collision with root package name */
            public final Context f1188b;
            public final boolean c;

            {
                this.f1188b = context;
                this.c = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LoadingTool.d(this.f1188b, this.c);
            }
        });
        IBoxUIHandler.a().f(f492b, i);
    }
}
