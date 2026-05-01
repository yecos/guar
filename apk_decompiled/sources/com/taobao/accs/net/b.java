package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9175a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f9176b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f9177c;

    public b(a aVar, String str, boolean z10) {
        this.f9177c = aVar;
        this.f9175a = str;
        this.f9176b = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message a10 = this.f9177c.f9161e.a(this.f9175a);
        if (a10 != null) {
            this.f9177c.f9161e.a(a10, -9);
            this.f9177c.a(this.f9175a, this.f9176b, "receive data time out");
            ALog.e(this.f9177c.d(), this.f9175a + "-> receive data time out!", new Object[0]);
        }
    }
}
