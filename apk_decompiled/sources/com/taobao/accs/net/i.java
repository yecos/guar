package com.taobao.accs.net;

import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class i implements HttpDispatcher.IDispatchEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9193a;

    public i(h hVar) {
        this.f9193a = hVar;
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        ThreadPoolExecutorFactory.schedule(new j(this), 2000L, TimeUnit.MILLISECONDS);
    }
}
