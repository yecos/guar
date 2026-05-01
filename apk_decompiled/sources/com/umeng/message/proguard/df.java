package com.umeng.message.proguard;

import com.umeng.message.proguard.db;

/* loaded from: classes3.dex */
public final class df implements bx {

    /* renamed from: a, reason: collision with root package name */
    public bw f11878a;

    /* renamed from: b, reason: collision with root package name */
    public bw f11879b;

    /* renamed from: c, reason: collision with root package name */
    public bw f11880c;

    /* renamed from: d, reason: collision with root package name */
    private final by f11881d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11882e;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final df f11883a = new df(0);
    }

    public /* synthetic */ df(byte b10) {
        this();
    }

    public final void a() {
        if (this.f11882e) {
            return;
        }
        this.f11882e = true;
        bz.a().a(dg.b());
    }

    private df() {
        db dbVar;
        this.f11882e = false;
        dbVar = db.a.f11862a;
        this.f11881d = dbVar;
        dx.b();
    }
}
