package com.ibox.nft.base.widgets.recycle;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: IBoxViewHandlerFactory.class */
public class IBoxViewHandlerFactory {
    public static final String a = "IBoxViewHandlerFactory";

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, SoftReference<IBoxViewHandler>> f504b = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T extends com.ibox.nft.base.widgets.recycle.IBoxViewHandler> T a(java.lang.String r4) {
        /*
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<com.ibox.nft.base.widgets.recycle.IBoxViewHandler>> r0 = com.ibox.nft.base.widgets.recycle.IBoxViewHandlerFactory.f504b
            r1 = r4
            java.lang.Object r0 = r0.get(r1)
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L16
            r0 = 0
            r5 = r0
            goto L1e
        L16:
            r0 = r5
            java.lang.Object r0 = r0.get()
            com.ibox.nft.base.widgets.recycle.IBoxViewHandler r0 = (com.ibox.nft.base.widgets.recycle.IBoxViewHandler) r0
            r5 = r0
        L1e:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L5d
            r0 = r4
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L50
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Exception -> L50
            com.ibox.nft.base.widgets.recycle.IBoxViewHandler r0 = (com.ibox.nft.base.widgets.recycle.IBoxViewHandler) r0     // Catch: java.lang.Exception -> L50
            r6 = r0
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<com.ibox.nft.base.widgets.recycle.IBoxViewHandler>> r0 = com.ibox.nft.base.widgets.recycle.IBoxViewHandlerFactory.f504b     // Catch: java.lang.Exception -> L4a java.lang.Exception -> L50
            r7 = r0
            java.lang.ref.SoftReference r0 = new java.lang.ref.SoftReference     // Catch: java.lang.Exception -> L4a
            r5 = r0
            r0 = r5
            r1 = r6
            r0.<init>(r1)     // Catch: java.lang.Exception -> L4a
            r0 = r7
            r1 = r4
            r2 = r5
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Exception -> L4a
            r0 = r6
            r5 = r0
            goto L5b
        L4a:
            r7 = move-exception
            r0 = r6
            r5 = r0
            goto L51
        L50:
            r7 = move-exception
        L51:
            java.lang.String r0 = com.ibox.nft.base.widgets.recycle.IBoxViewHandlerFactory.a
            java.lang.String r1 = "Exception!"
            r2 = r7
            int r0 = android.util.Log.e(r0, r1, r2)
        L5b:
            r0 = r5
            r6 = r0
        L5d:
            r0 = r6
            if (r0 == 0) goto L63
            r0 = r6
            return r0
        L63:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "IBoxViewHandler create failed:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibox.nft.base.widgets.recycle.IBoxViewHandlerFactory.a(java.lang.String):com.ibox.nft.base.widgets.recycle.IBoxViewHandler");
    }
}
