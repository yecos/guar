package com.taobao.accs.net;

/* loaded from: classes3.dex */
class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f9248a;

    public x(v vVar) {
        this.f9248a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9248a.o();
        if (this.f9248a.I != null) {
            this.f9248a.I.setCloseReason("shut down");
        }
        synchronized (this.f9248a.f9235u) {
            try {
                this.f9248a.f9235u.notifyAll();
            } catch (Exception unused) {
            }
        }
    }
}
