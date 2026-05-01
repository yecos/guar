package com.umeng.message.proguard;

import android.app.Activity;
import com.umeng.message.proguard.bx;

/* loaded from: classes3.dex */
public abstract class da implements bx.a {

    /* renamed from: a, reason: collision with root package name */
    public cf f11861a = new cf();

    public void a(Activity activity) {
    }

    public void b() {
        cf cfVar = this.f11861a;
        if (cfVar != null) {
            cfVar.f11708a = null;
            this.f11861a = null;
        }
    }

    @Override // com.umeng.message.proguard.bx.a
    public final void a() {
        a((Activity) null);
    }

    @Override // com.umeng.message.proguard.bx.a
    public final void a(bx.d dVar) {
        this.f11861a.f11708a = dVar;
    }
}
