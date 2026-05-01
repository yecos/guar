package anet.channel.strategy;

/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4198a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder f4199b;

    public e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f4199b = strategyInfoHolder;
        this.f4198a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4199b.a(this.f4198a, true);
    }
}
