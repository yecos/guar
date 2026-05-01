package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

/* loaded from: classes3.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f9194a;

    public j(i iVar) {
        this.f9194a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
