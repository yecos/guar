package com.google.android.gms.internal.cast;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzdf<T> implements Serializable {
    public static <T> zzdf<T> zzb(@CheckForNull T t10) {
        return t10 == null ? zzdc.zza : new zzdk(t10);
    }

    @CheckForNull
    public abstract T zza();
}
