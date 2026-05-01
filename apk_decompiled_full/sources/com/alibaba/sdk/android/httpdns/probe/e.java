package com.alibaba.sdk.android.httpdns.probe;

import com.alibaba.sdk.android.httpdns.i;
import com.alibaba.sdk.android.httpdns.probe.IPProbeService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class e implements IPProbeService {

    /* renamed from: a, reason: collision with other field name */
    private AtomicLong f35a = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f5946c = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private b f5944a = null;

    /* renamed from: b, reason: collision with root package name */
    private f f5945b = new f() { // from class: com.alibaba.sdk.android.httpdns.probe.e.1
        @Override // com.alibaba.sdk.android.httpdns.probe.f
        public void a(long j10, c cVar) {
            if (cVar != null) {
                try {
                    if (e.this.f5946c.containsKey(cVar.getHostName()) && ((Long) e.this.f5946c.get(cVar.getHostName())).longValue() == j10) {
                        if (cVar.getIps() != null && cVar.j() != null && cVar.k() != null && cVar.getHostName() != null) {
                            i.e("defultId:" + cVar.j() + ", selectedIp:" + cVar.k() + ", promote:" + (cVar.c() - cVar.d()));
                            e.this.a(cVar.getHostName(), cVar.j(), cVar.k(), cVar.c(), cVar.d(), cVar.getIps().length);
                            e.this.f5944a.a(cVar.getHostName(), cVar.getIps());
                            e.this.f5946c.remove(cVar.getHostName());
                        }
                    }
                    i.d("corresponding tasknumber not exists, drop the result");
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    };

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public IPProbeService.a getProbeStatus(String str) {
        return this.f5946c.containsKey(str) ? IPProbeService.a.PROBING : IPProbeService.a.NO_PROBING;
    }

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public void launchIPProbeTask(String str, int i10, String[] strArr) {
        if (!com.alibaba.sdk.android.httpdns.a.a.a().f()) {
            i.f("ip probe is forbidden");
        } else {
            if (getProbeStatus(str) != IPProbeService.a.NO_PROBING) {
                i.f("already launch the same task, drop the task");
                return;
            }
            long addAndGet = this.f35a.addAndGet(1L);
            this.f5946c.put(str, Long.valueOf(addAndGet));
            com.alibaba.sdk.android.httpdns.c.a().execute(new a(addAndGet, str, strArr, i10, this.f5945b));
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public void setIPListUpdateCallback(b bVar) {
        this.f5944a = bVar;
    }

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public boolean stopIPProbeTask(String str) {
        if (!this.f5946c.containsKey(str)) {
            return false;
        }
        i.d("stop ip probe task for host:" + str);
        this.f5946c.remove(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, long j10, long j11, int i10) {
        com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
        if (a10 != null) {
            a10.a(str, str2, str3, j10, j11, i10);
        }
    }
}
