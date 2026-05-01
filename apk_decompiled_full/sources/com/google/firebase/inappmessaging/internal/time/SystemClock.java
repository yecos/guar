package com.google.firebase.inappmessaging.internal.time;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SystemClock implements Clock {
    @Inject
    public SystemClock() {
    }

    @Override // com.google.firebase.inappmessaging.internal.time.Clock
    @CanIgnoreReturnValue
    public long now() {
        return System.currentTimeMillis();
    }
}
