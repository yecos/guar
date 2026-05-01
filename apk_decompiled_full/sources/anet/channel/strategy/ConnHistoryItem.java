package anet.channel.strategy;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;

/* loaded from: classes.dex */
class ConnHistoryItem implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    byte f4141a = 0;

    /* renamed from: b, reason: collision with root package name */
    long f4142b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f4143c = 0;

    public void a(boolean z10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (z10 ? this.f4142b : this.f4143c) > NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            this.f4141a = (byte) ((this.f4141a << 1) | (!z10 ? 1 : 0));
            if (z10) {
                this.f4142b = currentTimeMillis;
            } else {
                this.f4143c = currentTimeMillis;
            }
        }
    }

    public boolean b() {
        return (this.f4141a & 1) == 1;
    }

    public boolean c() {
        return a() >= 3 && System.currentTimeMillis() - this.f4143c <= 300000;
    }

    public boolean d() {
        long j10 = this.f4142b;
        long j11 = this.f4143c;
        if (j10 <= j11) {
            j10 = j11;
        }
        return j10 != 0 && System.currentTimeMillis() - j10 > 86400000;
    }

    public int a() {
        int i10 = 0;
        for (int i11 = this.f4141a & UnsignedBytes.MAX_VALUE; i11 > 0; i11 >>= 1) {
            i10 += i11 & 1;
        }
        return i10;
    }
}
