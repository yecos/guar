package com.taobao.accs.net;

/* loaded from: classes3.dex */
class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9249a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f9250b;

    public y(v vVar, String str) {
        this.f9250b = vVar;
        this.f9249a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2 = this.f9249a;
        if (str2 != null) {
            str = this.f9250b.O;
            if (str2.equals(str) && this.f9250b.f9234t == 2) {
                this.f9250b.K = false;
                this.f9250b.M = true;
                this.f9250b.o();
                this.f9250b.I.setCloseReason("conn timeout");
            }
        }
    }
}
