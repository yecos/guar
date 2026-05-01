package com.mobile.brasiltv.utils;

import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public final class k0 implements v9.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8728a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8729b;

    public k0(String str, long j10) {
        this.f8728a = str;
        this.f8729b = j10;
    }

    @Override // v9.a
    public /* bridge */ /* synthetic */ void a(Object obj, z9.g gVar, Object obj2) {
        d((c) obj, gVar, ((Number) obj2).longValue());
    }

    @Override // v9.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long b(c cVar, z9.g gVar) {
        t9.i.g(cVar, "thisRef");
        t9.i.g(gVar, "property");
        SharedPreferences e10 = cVar.e();
        String str = this.f8728a;
        if (str == null) {
            str = gVar.getName();
        }
        return Long.valueOf(e10.getLong(str, this.f8729b));
    }

    public void d(c cVar, z9.g gVar, long j10) {
        t9.i.g(cVar, "thisRef");
        t9.i.g(gVar, "property");
        SharedPreferences.Editor edit = cVar.e().edit();
        String str = this.f8728a;
        if (str == null) {
            str = gVar.getName();
        }
        edit.putLong(str, j10).apply();
    }
}
