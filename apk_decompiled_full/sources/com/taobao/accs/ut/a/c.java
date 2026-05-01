package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f9264a;

    /* renamed from: b, reason: collision with root package name */
    public int f9265b;

    /* renamed from: f, reason: collision with root package name */
    public String f9269f;

    /* renamed from: g, reason: collision with root package name */
    public String f9270g;

    /* renamed from: h, reason: collision with root package name */
    public long f9271h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9272i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9273j;

    /* renamed from: k, reason: collision with root package name */
    private long f9274k = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9266c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f9267d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f9268e = 0;

    public void a() {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog()) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (currentTimeMillis - this.f9274k) + " interval1:" + (currentTimeMillis - this.f9271h), new Object[0]);
        }
        if (currentTimeMillis - this.f9274k <= 1200000 || currentTimeMillis - this.f9271h <= 60000) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str3 = null;
        try {
            String valueOf = String.valueOf(this.f9267d);
            try {
                str2 = String.valueOf(this.f9268e);
                try {
                    str = String.valueOf(Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put("connStatus", String.valueOf(this.f9264a));
                        hashMap.put("connType", String.valueOf(this.f9265b));
                        hashMap.put("tcpConnected", String.valueOf(this.f9266c));
                        hashMap.put("proxy", String.valueOf(this.f9269f));
                        hashMap.put("startServiceTime", String.valueOf(this.f9271h));
                        hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                        hashMap.put("networkAvailable", String.valueOf(this.f9272i));
                        hashMap.put("threadIsalive", String.valueOf(this.f9273j));
                        hashMap.put("url", this.f9270g);
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            try {
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, valueOf, str2, str, hashMap), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str3 = valueOf;
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str2, str, hashMap) + " " + th.toString(), new Object[0]);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = null;
                }
                try {
                    UTMini.getInstance().commitEvent(66001, "MONITOR", valueOf, str2, str, hashMap);
                    this.f9274k = currentTimeMillis;
                } catch (Throwable th4) {
                    th = th4;
                    str3 = valueOf;
                    str = str;
                    str2 = str2;
                    ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str2, str, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th5) {
                th = th5;
                str = null;
                str2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            str = null;
            str2 = null;
        }
    }
}
