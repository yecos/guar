package anet.channel.util;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r4 = this;
            anet.channel.status.NetworkStatusHelper$NetworkStatus r0 = anet.channel.status.NetworkStatusHelper.getStatus()     // Catch: java.lang.Exception -> L6f
            java.lang.String r0 = anet.channel.util.c.a(r0)     // Catch: java.lang.Exception -> L6f
            anet.channel.util.d r1 = r4.f4279a     // Catch: java.lang.Exception -> L6f
            java.lang.String r1 = r1.f4277a     // Catch: java.lang.Exception -> L6f
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L6f
            if (r0 != 0) goto L13
            return
        L13:
            java.lang.String r0 = "awcn.Inet64Util"
            java.lang.String r1 = "startIpStackDetect double check"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6f
            r3 = 0
            anet.channel.util.ALog.e(r0, r1, r3, r2)     // Catch: java.lang.Exception -> L6f
            int r0 = anet.channel.util.c.f()     // Catch: java.lang.Exception -> L6f
            anet.channel.util.d r1 = r4.f4279a     // Catch: java.lang.Exception -> L6f
            anet.channel.statist.NetTypeStat r2 = r1.f4278b     // Catch: java.lang.Exception -> L6f
            int r2 = r2.ipStackType     // Catch: java.lang.Exception -> L6f
            if (r2 == r0) goto L3f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = anet.channel.util.c.f4276e     // Catch: java.lang.Exception -> L6f
            java.lang.String r1 = r1.f4277a     // Catch: java.lang.Exception -> L6f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L6f
            r2.put(r1, r3)     // Catch: java.lang.Exception -> L6f
            anet.channel.util.d r1 = r4.f4279a     // Catch: java.lang.Exception -> L6f
            anet.channel.statist.NetTypeStat r1 = r1.f4278b     // Catch: java.lang.Exception -> L6f
            int r2 = r1.ipStackType     // Catch: java.lang.Exception -> L6f
            r1.lastIpStackType = r2     // Catch: java.lang.Exception -> L6f
            r1.ipStackType = r0     // Catch: java.lang.Exception -> L6f
        L3f:
            r1 = 2
            if (r0 == r1) goto L45
            r1 = 3
            if (r0 != r1) goto L5e
        L45:
            anet.channel.util.f r0 = anet.channel.util.c.g()     // Catch: java.lang.Exception -> L6f
            if (r0 == 0) goto L5e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, anet.channel.util.f> r1 = anet.channel.util.c.f4275d     // Catch: java.lang.Exception -> L6f
            anet.channel.util.d r2 = r4.f4279a     // Catch: java.lang.Exception -> L6f
            java.lang.String r2 = r2.f4277a     // Catch: java.lang.Exception -> L6f
            r1.put(r2, r0)     // Catch: java.lang.Exception -> L6f
            anet.channel.util.d r1 = r4.f4279a     // Catch: java.lang.Exception -> L6f
            anet.channel.statist.NetTypeStat r1 = r1.f4278b     // Catch: java.lang.Exception -> L6f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L6f
            r1.nat64Prefix = r0     // Catch: java.lang.Exception -> L6f
        L5e:
            boolean r0 = anet.channel.GlobalAppRuntimeInfo.isTargetProcess()     // Catch: java.lang.Exception -> L6f
            if (r0 == 0) goto L6f
            anet.channel.appmonitor.IAppMonitor r0 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch: java.lang.Exception -> L6f
            anet.channel.util.d r1 = r4.f4279a     // Catch: java.lang.Exception -> L6f
            anet.channel.statist.NetTypeStat r1 = r1.f4278b     // Catch: java.lang.Exception -> L6f
            r0.commitStat(r1)     // Catch: java.lang.Exception -> L6f
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.e.run():void");
    }
}
