package z8;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class i implements d1 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f20644a = new AtomicLong();

    @Override // z8.d1
    public void add(long j10) {
        this.f20644a.getAndAdd(j10);
    }
}
