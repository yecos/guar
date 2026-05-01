package anet.channel.util;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;

/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f4279a;

    public e(d dVar) {
        this.f4279a = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r0 = anet.channel.util.c.k();
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String b10;
        int j10;
        f k10;
        try {
            b10 = c.b(NetworkStatusHelper.getStatus());
            if (this.f4279a.f4277a.equals(b10)) {
                ALog.e("awcn.Inet64Util", "startIpStackDetect double check", null, new Object[0]);
                j10 = c.j();
                d dVar = this.f4279a;
                if (dVar.f4278b.ipStackType != j10) {
                    c.f4276e.put(dVar.f4277a, Integer.valueOf(j10));
                    NetTypeStat netTypeStat = this.f4279a.f4278b;
                    netTypeStat.lastIpStackType = netTypeStat.ipStackType;
                    netTypeStat.ipStackType = j10;
                }
                if ((j10 == 2 || j10 == 3) && k10 != null) {
                    c.f4275d.put(this.f4279a.f4277a, k10);
                    this.f4279a.f4278b.nat64Prefix = k10.toString();
                }
                if (GlobalAppRuntimeInfo.isTargetProcess()) {
                    AppMonitor.getInstance().commitStat(this.f4279a.f4278b);
                }
            }
        } catch (Exception unused) {
        }
    }
}
