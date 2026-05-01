package org.android.agoo.control;

import android.content.Intent;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f17852a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f17853b;

    public h(g gVar, Intent intent) {
        this.f17853b = gVar;
        this.f17852a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17853b.f17851a.onHandleIntent(this.f17852a);
    }
}
