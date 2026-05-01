package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        StringBuilder sb = new StringBuilder();
        sb.append("AMDC");
        atomicInteger = a.f4251a;
        sb.append(atomicInteger.incrementAndGet());
        Thread thread = new Thread(runnable, sb.toString());
        ALog.i(anet.channel.strategy.dispatch.a.TAG, "thread created!", null, "name", thread.getName());
        thread.setPriority(5);
        return thread;
    }
}
