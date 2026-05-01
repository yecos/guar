package io.reactivex.internal.util;

import fb.c;

/* loaded from: classes3.dex */
public interface QueueDrain<T, U> {
    boolean accept(c cVar, T t10);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i10);

    long produced(long j10);

    long requested();
}
