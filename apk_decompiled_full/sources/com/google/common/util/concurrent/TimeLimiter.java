package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@DoNotMock("Use FakeTimeLimiter")
/* loaded from: classes2.dex */
public interface TimeLimiter {
    @CanIgnoreReturnValue
    <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit);

    @CanIgnoreReturnValue
    <T> T callWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit);

    <T> T newProxy(T t10, Class<T> cls, long j10, TimeUnit timeUnit);

    void runUninterruptiblyWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit);

    void runWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit);
}
