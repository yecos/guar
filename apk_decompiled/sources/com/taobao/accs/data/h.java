package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9124a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f9125b;

    public h(Context context, Intent intent) {
        this.f9124a = context;
        this.f9125b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        g.a().b(this.f9124a, this.f9125b);
    }
}
