package anet.channel;

/* loaded from: classes.dex */
final class j implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            anet.channel.b.a aVar = new anet.channel.b.a();
            aVar.a();
            n1.b.a(aVar, new k(this), 1);
        } catch (Exception unused) {
        }
    }
}
