package com.umeng.message.proguard;

import android.view.View;
import com.umeng.message.proguard.bx;

/* loaded from: classes3.dex */
public final class cf implements bx.d {

    /* renamed from: a, reason: collision with root package name */
    public bx.d f11708a;

    @Override // com.umeng.message.proguard.bx.d
    public final void a() {
        final bx.d dVar = this.f11708a;
        if (dVar == null) {
            return;
        }
        cb.c(new Runnable() { // from class: com.umeng.message.proguard.cf.1
            @Override // java.lang.Runnable
            public final void run() {
                dVar.a();
            }
        });
    }

    @Override // com.umeng.message.proguard.bx.d
    public final void b() {
        final bx.d dVar = this.f11708a;
        if (dVar == null) {
            return;
        }
        cb.c(new Runnable() { // from class: com.umeng.message.proguard.cf.4
            @Override // java.lang.Runnable
            public final void run() {
                dVar.b();
            }
        });
    }

    @Override // com.umeng.message.proguard.bx.d
    public final void a(final View view) {
        final bx.d dVar = this.f11708a;
        if (dVar == null) {
            return;
        }
        cb.c(new Runnable() { // from class: com.umeng.message.proguard.cf.2
            @Override // java.lang.Runnable
            public final void run() {
                dVar.a(view);
            }
        });
    }

    @Override // com.umeng.message.proguard.bx.d
    public final void a(final int i10, final String str) {
        final bx.d dVar = this.f11708a;
        if (dVar == null) {
            return;
        }
        cb.c(new Runnable() { // from class: com.umeng.message.proguard.cf.3
            @Override // java.lang.Runnable
            public final void run() {
                dVar.a(i10, str);
            }
        });
    }
}
