package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9178a;

    public c(a aVar) {
        this.f9178a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9178a.f9161e.c()) {
            ALog.e(this.f9178a.d(), "receive ping time out! ", new Object[0]);
            g.a(this.f9178a.f9160d).c();
            this.f9178a.a("", false, "receive ping timeout");
            this.f9178a.f9161e.a(-12);
        }
    }
}
