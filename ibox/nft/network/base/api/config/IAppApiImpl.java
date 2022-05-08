package com.ibox.nft.network.base.api.config;

import com.ibox.network.lib.api.AbsBaseRestApi;

/* loaded from: IAppApiImpl.class */
public final class IAppApiImpl extends AbsBaseRestApi<IAppApiService> {

    /* renamed from: b  reason: collision with root package name */
    public static IAppApiImpl f511b;

    public static IAppApiImpl d() {
        if (f511b == null) {
            synchronized (IAppApiImpl.class) {
                try {
                    if (f511b == null) {
                        f511b = new IAppApiImpl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f511b;
    }

    public Class<IAppApiService> a() {
        return IAppApiService.class;
    }

    public IAppApiService e() {
        return (IAppApiService) IAppApiImpl.super.b();
    }
}
