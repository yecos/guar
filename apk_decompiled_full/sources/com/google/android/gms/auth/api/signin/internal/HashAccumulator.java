package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
/* loaded from: classes.dex */
public class HashAccumulator {

    @VisibleForTesting
    static int zaa = 31;
    private int zab = 1;

    @CanIgnoreReturnValue
    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        this.zab = (zaa * this.zab) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zab;
    }

    @CanIgnoreReturnValue
    public final HashAccumulator zaa(boolean z10) {
        this.zab = (zaa * this.zab) + (z10 ? 1 : 0);
        return this;
    }
}
