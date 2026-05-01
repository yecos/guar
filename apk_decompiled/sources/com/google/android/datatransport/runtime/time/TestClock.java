package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class TestClock implements Clock {
    private final AtomicLong timestamp;

    public TestClock(long j10) {
        this.timestamp = new AtomicLong(j10);
    }

    public void advance(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("cannot advance time backwards.");
        }
        this.timestamp.addAndGet(j10);
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.timestamp.get();
    }

    public void tick() {
        advance(1L);
    }
}
