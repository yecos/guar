package com.google.android.gms.internal.cast;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzdk<T> extends zzdf<T> {
    private final T zza;

    public zzdk(T t10) {
        this.zza = t10;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzdk) {
            return this.zza.equals(((zzdk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 13);
        sb.append("Optional.of(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.cast.zzdf
    public final T zza() {
        return this.zza;
    }
}
