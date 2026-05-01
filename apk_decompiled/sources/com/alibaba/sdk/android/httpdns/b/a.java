package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import java.util.List;

/* loaded from: classes.dex */
class a implements f {

    /* renamed from: a, reason: collision with root package name */
    private final d f5845a;

    public a(Context context) {
        this.f5845a = new d(context);
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public List<e> a() {
        return this.f5845a.b();
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public void b(e eVar) {
        this.f5845a.b(eVar.f5852m, eVar.host);
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public void a(e eVar) {
        this.f5845a.m4a(eVar);
    }
}
