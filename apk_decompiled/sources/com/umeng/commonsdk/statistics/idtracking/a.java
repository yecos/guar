package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f11067a = 10;

    /* renamed from: b, reason: collision with root package name */
    private final int f11068b = 100;

    /* renamed from: c, reason: collision with root package name */
    private final String f11069c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f11070d;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.b f11071e;

    public a(String str) {
        this.f11069c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f11071e;
        String b10 = bVar == null ? null : bVar.b();
        int h10 = bVar == null ? 0 : bVar.h();
        String a10 = a(f());
        if (a10 == null || a10.equals(b10)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a10);
        bVar.a(System.currentTimeMillis());
        bVar.a(h10 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f11069c);
        aVar.c(a10);
        aVar.b(b10);
        aVar.a(bVar.e());
        if (this.f11070d == null) {
            this.f11070d = new ArrayList(2);
        }
        this.f11070d.add(aVar);
        if (this.f11070d.size() > 10) {
            this.f11070d.remove(0);
        }
        this.f11071e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f11069c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f11071e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f11071e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f11070d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f11071e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f11070d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f11071e = cVar.c().get(this.f11069c);
        List<com.umeng.commonsdk.statistics.proto.a> h10 = cVar.h();
        if (h10 == null || h10.size() <= 0) {
            return;
        }
        if (this.f11070d == null) {
            this.f11070d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h10) {
            if (this.f11069c.equals(aVar.f11137a)) {
                this.f11070d.add(aVar);
            }
        }
    }
}
