package io.reactivex.internal.fuseable;

import fb.d;

/* loaded from: classes3.dex */
public interface QueueSubscription<T> extends QueueFuseable<T>, d {
    @Override // fb.d
    /* synthetic */ void cancel();

    @Override // fb.d
    /* synthetic */ void request(long j10);
}
