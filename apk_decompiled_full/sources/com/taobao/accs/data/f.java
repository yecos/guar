package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* loaded from: classes3.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f9121a;

    public f(d dVar) {
        this.f9121a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f9121a.f9105c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a();
        }
    }
}
