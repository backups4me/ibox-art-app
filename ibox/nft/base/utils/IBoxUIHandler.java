package com.ibox.nft.base.utils;

import android.os.Handler;
import android.os.Looper;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.utils.IBoxUIHandler;

/* loaded from: IBoxUIHandler.class */
public class IBoxUIHandler {
    public static IBoxUIHandler a = new IBoxUIHandler();

    /* renamed from: b  reason: collision with root package name */
    public Handler f426b = new Handler(Looper.getMainLooper());

    public static IBoxUIHandler a() {
        return a;
    }

    public static /* synthetic */ void d(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            th.printStackTrace();
            LogTool.c("ui ThreadMethod Exception-->" + th.toString());
        }
    }

    public void b() {
        this.f426b = new Handler(Looper.getMainLooper());
    }

    public void c(final Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            e(new Runnable(runnable) { // from class: d.c.d.d.h.q

                /* renamed from: b  reason: collision with root package name */
                public final Runnable f1170b;

                {
                    this.f1170b = runnable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IBoxUIHandler.d(this.f1170b);
                }
            });
        }
    }

    public void e(Runnable runnable) {
        this.f426b.post(runnable);
    }

    public void f(Runnable runnable, int i) {
        this.f426b.postDelayed(runnable, i);
    }

    public void g(Runnable runnable) {
        this.f426b.removeCallbacks(runnable);
    }

    public void h(Object obj) {
        this.f426b.removeCallbacksAndMessages(obj);
    }
}
