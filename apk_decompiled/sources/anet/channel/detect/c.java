package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f3918a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExceptionDetector f3919b;

    public c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.f3919b = exceptionDetector;
        this.f3918a = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            RequestStatistic requestStatistic = this.f3918a;
            if (requestStatistic == null) {
                return;
            }
            if (!TextUtils.isEmpty(requestStatistic.ip) && this.f3918a.ret == 0) {
                if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.f3918a.host)) {
                    this.f3919b.f3903b = this.f3918a.ip;
                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.f3918a.host)) {
                    this.f3919b.f3904c = this.f3918a.ip;
                } else if ("gw.alicdn.com".equalsIgnoreCase(this.f3918a.host)) {
                    this.f3919b.f3905d = this.f3918a.ip;
                }
            }
            if (!TextUtils.isEmpty(this.f3918a.url)) {
                this.f3919b.f3906e.add(Pair.create(this.f3918a.url, Integer.valueOf(this.f3918a.statusCode)));
            }
            if (this.f3919b.c()) {
                this.f3919b.b();
            }
        } catch (Throwable th) {
            ALog.e("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
        }
    }
}
