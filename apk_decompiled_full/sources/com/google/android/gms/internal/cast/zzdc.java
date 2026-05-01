package com.google.android.gms.internal.cast;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzdc<T> extends zzdf<T> {
    static final zzdc<Object> zza = new zzdc<>();

    private zzdc() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.cast.zzdf
    @CheckForNull
    public final T zza() {
        return null;
    }
}
