package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* loaded from: classes3.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TrafficsMonitor.a f9119a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f9120b;

    public e(d dVar, TrafficsMonitor.a aVar) {
        this.f9120b = dVar;
        this.f9119a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f9120b.f9105c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a(this.f9119a);
        }
    }
}
