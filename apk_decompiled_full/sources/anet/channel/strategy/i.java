package anet.channel.strategy;

/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4208a;

    public i(g gVar) {
        this.f4208a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a10;
        a10 = this.f4208a.a();
        if (a10) {
            return;
        }
        this.f4208a.f4203b.c();
    }
}
