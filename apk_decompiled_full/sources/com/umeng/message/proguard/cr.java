package com.umeng.message.proguard;

import com.umeng.message.proguard.cq;

/* loaded from: classes3.dex */
public class cr extends cq {

    /* renamed from: a, reason: collision with root package name */
    private static volatile cr f11780a;

    private cr() {
    }

    public static cq a() {
        if (f11780a == null) {
            synchronized (cr.class) {
                if (f11780a == null) {
                    f11780a = new cr();
                }
            }
        }
        return f11780a;
    }

    @Override // com.umeng.message.proguard.cq
    public final void b(final ck ckVar, final int i10) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.4
            @Override // java.lang.Runnable
            public final void run() {
                cs.a().a(ckVar, i10);
            }
        });
    }

    @Override // com.umeng.message.proguard.cq
    public final void c(final ck ckVar, final int i10) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.6
            @Override // java.lang.Runnable
            public final void run() {
                cs.a().c(ckVar, i10);
            }
        });
    }

    @Override // com.umeng.message.proguard.cq
    public final boolean b(ck ckVar) {
        return cs.a().a(ckVar);
    }

    @Override // com.umeng.message.proguard.cq
    public final void a(final ck ckVar, final cq.a aVar) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.1
            @Override // java.lang.Runnable
            public final void run() {
                cs.a().a(ckVar, aVar);
            }
        });
    }

    @Override // com.umeng.message.proguard.cq
    public final void a(final ck ckVar, final int i10) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.3
            @Override // java.lang.Runnable
            public final void run() {
                cs.a().b(ckVar, i10);
            }
        });
    }

    @Override // com.umeng.message.proguard.cq
    public final void a(final ck ckVar) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.5

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f11794b = 3011;

            @Override // java.lang.Runnable
            public final void run() {
                cs.a().a(ckVar, 9, this.f11794b);
            }
        });
    }

    @Override // com.umeng.message.proguard.cq
    public final void a(ck ckVar, int i10, int i11, String str) {
        cs.a().a(ckVar, i10, i11, str);
    }

    @Override // com.umeng.message.proguard.cq
    public final void a(final boolean z10, final ck ckVar, final boolean z11, final int i10, final int i11, final long j10) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.7
            @Override // java.lang.Runnable
            public final void run() {
                cs.a().a(z10, ckVar, z11, i10, i11, j10);
            }
        });
    }

    @Override // com.umeng.message.proguard.cq
    public final void a(final ck ckVar, final boolean z10, final cq.a aVar) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.8
            @Override // java.lang.Runnable
            public final void run() {
                cs.a().a(ckVar, z10, aVar);
            }
        });
    }

    @Override // com.umeng.message.proguard.cq
    public final void a(final String str, final ck ckVar) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cr.2
            @Override // java.lang.Runnable
            public final void run() {
                cs.a().a(str, ckVar);
            }
        });
    }
}
