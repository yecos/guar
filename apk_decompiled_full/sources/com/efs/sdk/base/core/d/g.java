package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class g extends com.efs.sdk.base.core.d.a {

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f6197b = new ConcurrentHashMap<>(10);

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f6198a;

        /* renamed from: b, reason: collision with root package name */
        String f6199b;

        /* renamed from: c, reason: collision with root package name */
        String f6200c;

        /* renamed from: d, reason: collision with root package name */
        AtomicInteger f6201d = new AtomicInteger(0);

        public a(String str, String str2, String str3) {
            this.f6198a = str;
            this.f6199b = str2;
            this.f6200c = str3;
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2 + "_" + str3.trim();
        if (!this.f6197b.containsKey(str4) || this.f6197b.get(str4) == null) {
            this.f6197b.putIfAbsent(str4, new a(str, str2, str3));
        }
        this.f6197b.get(str4).f6201d.incrementAndGet();
    }

    @Override // com.efs.sdk.base.core.d.a
    public final void a() {
        f fVar;
        try {
            if (this.f6177a != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                Iterator<Map.Entry<String, a>> it = this.f6197b.entrySet().iterator();
                while (it.hasNext()) {
                    a value = it.next().getValue();
                    int i10 = value.f6201d.get();
                    if (i10 > 0) {
                        ControllerCenter controllerCenter = this.f6177a;
                        String str = value.f6198a;
                        String str2 = value.f6199b;
                        String str3 = value.f6200c;
                        fVar = f.a.f6196a;
                        b bVar = new b("efs_core", "req_succ_rate", fVar.f6192a.f6186c);
                        bVar.put("rep_code", str);
                        bVar.put("px_code", str2);
                        bVar.put("path", str3);
                        bVar.put("cnt", Integer.valueOf(i10));
                        controllerCenter.send(bVar);
                        value.f6201d.addAndGet(i10 * (-1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
