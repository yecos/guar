package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Iterator;

/* loaded from: classes3.dex */
class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9222a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f9223b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f9224c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f9225d;

    public s(k kVar, int i10, boolean z10, int i11) {
        this.f9225d = kVar;
        this.f9222a = i10;
        this.f9223b = z10;
        this.f9224c = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message.Id id;
        Message b10;
        int i10 = this.f9222a;
        if (i10 > 0) {
            Message.Id id2 = new Message.Id(i10, "");
            Iterator<Message.Id> it = this.f9225d.f9161e.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    id = null;
                    break;
                } else {
                    id = it.next();
                    if (id.equals(id2)) {
                        break;
                    }
                }
            }
            if (id != null && (b10 = this.f9225d.f9161e.b(id.getDataId())) != null) {
                if (this.f9223b) {
                    if (!this.f9225d.a(b10, 2000)) {
                        this.f9225d.f9161e.a(b10, this.f9224c);
                    }
                    if (b10.getNetPermanceMonitor() != null) {
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.f9225d.f9161e.a(b10, this.f9224c);
                }
            }
        }
        int i11 = this.f9222a;
        if (i11 >= 0 || !this.f9223b) {
            return;
        }
        this.f9225d.b(i11);
    }
}
