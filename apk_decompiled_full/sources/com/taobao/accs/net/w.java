package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* loaded from: classes3.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Message f9245a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f9246b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ v f9247c;

    public w(v vVar, Message message, boolean z10) {
        this.f9247c = vVar;
        this.f9245a = message;
        this.f9246b = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f9247c.f9235u) {
            this.f9247c.a(this.f9245a);
            if (this.f9247c.f9235u.size() == 0) {
                this.f9247c.f9235u.add(this.f9245a);
            } else {
                Message message = (Message) this.f9247c.f9235u.getFirst();
                if (this.f9245a.getType() != 1 && this.f9245a.getType() != 0) {
                    if (this.f9245a.getType() != 2 || message.getType() != 2) {
                        this.f9247c.f9235u.addLast(this.f9245a);
                    } else if (!message.force && this.f9245a.force) {
                        this.f9247c.f9235u.removeFirst();
                        this.f9247c.f9235u.addFirst(this.f9245a);
                    }
                }
                this.f9247c.f9235u.addLast(this.f9245a);
                if (message.getType() == 2) {
                    this.f9247c.f9235u.removeFirst();
                }
            }
            if (this.f9246b || this.f9247c.f9234t == 3) {
                try {
                    this.f9247c.f9235u.notifyAll();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
