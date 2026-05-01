package com.google.android.gms.cast.framework.media.widget;

/* loaded from: classes.dex */
public final class zzb {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzb(int i10, int i11, boolean z10) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzb) && this.zza == ((zzb) obj).zza;
    }

    public final int hashCode() {
        return Integer.valueOf(this.zza).hashCode();
    }
}
