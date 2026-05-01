package com.efs.sdk.net.a;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f6370c;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, c> f6371a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, d> f6372b;

    private a() {
        b();
    }

    public static a a() {
        if (f6370c == null) {
            f6370c = new a();
        }
        return f6370c;
    }

    private void b() {
        if (this.f6371a == null) {
            this.f6371a = new HashMap<>();
        }
        this.f6371a.clear();
    }

    public final d c(String str) {
        if (this.f6372b == null) {
            this.f6372b = new HashMap<>();
        }
        if (this.f6372b.containsKey(str)) {
            return this.f6372b.get(str);
        }
        d dVar = new d();
        dVar.A = str;
        dVar.D = System.currentTimeMillis();
        this.f6372b.put(str, dVar);
        return dVar;
    }

    public final void d(String str) {
        HashMap<String, d> hashMap = this.f6372b;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.f6372b.remove(str);
    }

    public final c a(String str) {
        if (this.f6371a == null) {
            b();
        }
        c cVar = this.f6371a.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.f6394a = str;
        cVar2.f6395b = System.currentTimeMillis();
        this.f6371a.put(str, cVar2);
        return cVar2;
    }

    public final void b(String str) {
        HashMap<String, c> hashMap = this.f6371a;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.f6371a.remove(str);
    }
}
