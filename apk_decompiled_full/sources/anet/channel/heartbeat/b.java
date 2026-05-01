package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.umeng.analytics.pro.bt;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class b implements IHeartbeat, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Session f3995a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f3996b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f3997c = false;

    /* renamed from: d, reason: collision with root package name */
    private long f3998d = 0;

    private void a(long j10) {
        try {
            this.f3996b = System.currentTimeMillis() + j10;
            ThreadPoolExecutorFactory.submitScheduledTask(this, j10 + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            ALog.e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task failed.", this.f3995a.f3827p, e10, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f3996b = System.currentTimeMillis() + this.f3998d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3997c) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f3996b - 1000) {
            a(this.f3996b - currentTimeMillis);
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            Session session = this.f3995a;
            ALog.e("awcn.DefaultHeartbeatImpl", "close session in background", session.f3827p, "session", session);
            this.f3995a.close(false);
        } else {
            if (ALog.isPrintLog(1)) {
                Session session2 = this.f3995a;
                ALog.d("awcn.DefaultHeartbeatImpl", "heartbeat", session2.f3827p, "session", session2);
            }
            this.f3995a.ping(true);
            a(this.f3998d);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.f3995a = session;
        long heartbeat = session.getConnStrategy().getHeartbeat();
        this.f3998d = heartbeat;
        if (heartbeat <= 0) {
            this.f3998d = 45000L;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat start", session.f3827p, "session", session, bt.f10040ba, Long.valueOf(this.f3998d));
        a(this.f3998d);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session = this.f3995a;
        if (session == null) {
            return;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat stop", session.f3827p, "session", session);
        this.f3997c = true;
    }
}
