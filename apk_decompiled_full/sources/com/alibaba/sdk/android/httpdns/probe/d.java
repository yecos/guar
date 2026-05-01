package com.alibaba.sdk.android.httpdns.probe;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static IPProbeService f5943a;

    public static synchronized IPProbeService a(b bVar) {
        IPProbeService iPProbeService;
        synchronized (d.class) {
            if (f5943a == null) {
                e eVar = new e();
                f5943a = eVar;
                eVar.setIPListUpdateCallback(bVar);
            }
            iPProbeService = f5943a;
        }
        return iPProbeService;
    }
}
