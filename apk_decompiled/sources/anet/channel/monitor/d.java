package anet.channel.monitor;

import anet.channel.util.ALog;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f4026a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f4027b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f4028c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f4029d;

    public d(b bVar, long j10, long j11, long j12) {
        this.f4029d = bVar;
        this.f4026a = j10;
        this.f4027b = j11;
        this.f4028c = j12;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        int i10;
        e eVar2;
        b.f4010a++;
        b.f4014e += this.f4026a;
        if (b.f4010a == 1) {
            b.f4013d = this.f4027b - this.f4028c;
        }
        int i11 = b.f4010a;
        if (i11 >= 2 && i11 <= 3) {
            long j10 = this.f4028c;
            long j11 = b.f4012c;
            if (j10 >= j11) {
                b.f4013d += this.f4027b - j10;
            } else if (j10 < j11) {
                long j12 = this.f4027b;
                if (j12 >= j11) {
                    long j13 = b.f4013d + (j12 - j10);
                    b.f4013d = j13;
                    b.f4013d = j13 - (b.f4012c - j10);
                }
            }
        }
        b.f4011b = this.f4028c;
        b.f4012c = this.f4027b;
        if (b.f4010a == 3) {
            eVar = this.f4029d.f4023n;
            b.f4018i = (long) eVar.a(b.f4014e, b.f4013d);
            b.f4015f++;
            b.b(this.f4029d);
            if (b.f4015f > 30) {
                eVar2 = this.f4029d.f4023n;
                eVar2.a();
                b.f4015f = 3L;
            }
            double d10 = (b.f4018i * 0.68d) + (b.f4017h * 0.27d) + (b.f4016g * 0.05d);
            b.f4016g = b.f4017h;
            b.f4017h = b.f4018i;
            if (b.f4018i < b.f4016g * 0.65d || b.f4018i > b.f4016g * 2.0d) {
                b.f4018i = d10;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(b.f4014e), "mKalmanTimeUsed", Long.valueOf(b.f4013d), "speed", Double.valueOf(b.f4018i), "mSpeedKalmanCount", Long.valueOf(b.f4015f));
            }
            i10 = this.f4029d.f4022m;
            if (i10 > 5 || b.f4015f == 2) {
                a.a().a(b.f4018i);
                this.f4029d.f4022m = 0;
                this.f4029d.f4021l = b.f4018i < b.f4019j ? 1 : 5;
                ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
            }
            b.f4013d = 0L;
            b.f4014e = 0L;
            b.f4010a = 0;
        }
    }
}
