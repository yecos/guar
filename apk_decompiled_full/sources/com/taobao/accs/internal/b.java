package com.taobao.accs.internal;

/* loaded from: classes3.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.taobao.accs.c f9148a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f9149b;

    public b(ACCSManagerImpl aCCSManagerImpl, com.taobao.accs.c cVar) {
        this.f9149b = aCCSManagerImpl;
        this.f9148a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.taobao.accs.c cVar = this.f9148a;
        if (cVar != null) {
            cVar.a(true, false);
        }
    }
}
