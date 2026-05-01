package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c implements IHeartbeat, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Session f3999a = null;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f4000b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f4001c = System.currentTimeMillis();

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f4001c = System.currentTimeMillis() + 45000;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4000b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f4001c - 1000) {
            ThreadPoolExecutorFactory.submitScheduledTask(this, this.f4001c - currentTimeMillis, TimeUnit.MILLISECONDS);
        } else {
            this.f3999a.close(false);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.f3999a = session;
        this.f4001c = System.currentTimeMillis() + 45000;
        ThreadPoolExecutorFactory.submitScheduledTask(this, 45000L, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.f4000b = true;
    }
}
