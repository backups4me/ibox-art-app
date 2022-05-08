package com.ibox.nft.network.art.config;

import com.ibox.network.lib.api.AbsBaseRestApi;

/* loaded from: IArtApiImpl.class */
public final class IArtApiImpl extends AbsBaseRestApi<IArtApiService> {

    /* renamed from: b  reason: collision with root package name */
    public static IArtApiImpl f510b;

    public static IArtApiImpl d() {
        if (f510b == null) {
            synchronized (IArtApiImpl.class) {
                try {
                    if (f510b == null) {
                        f510b = new IArtApiImpl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f510b;
    }

    public Class<IArtApiService> a() {
        return IArtApiService.class;
    }

    public IArtApiService e() {
        return (IArtApiService) IArtApiImpl.super.b();
    }
}
