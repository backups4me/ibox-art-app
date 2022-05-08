package com.ibox.nft.network.account.config;

import com.ibox.network.lib.api.AbsBaseRestApi;

/* loaded from: IAccountApiImpl.class */
public final class IAccountApiImpl extends AbsBaseRestApi<IAccountApiService> {

    /* renamed from: b  reason: collision with root package name */
    public static IAccountApiImpl f509b;

    public static IAccountApiImpl d() {
        if (f509b == null) {
            synchronized (IAccountApiImpl.class) {
                try {
                    if (f509b == null) {
                        f509b = new IAccountApiImpl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f509b;
    }

    public Class<IAccountApiService> a() {
        return IAccountApiService.class;
    }

    public IAccountApiService e() {
        return (IAccountApiService) IAccountApiImpl.super.b();
    }
}
