package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes2.dex */
interface LongAddable {
    void add(long j10);

    void increment();

    long sum();
}
