package org.android.agoo.control;

/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17847a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17848b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17849c;

    public e(AgooFactory agooFactory, String str, String str2) {
        this.f17849c = agooFactory;
        this.f17847a = str;
        this.f17848b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17849c.updateMsgStatus(this.f17847a, this.f17848b);
    }
}
