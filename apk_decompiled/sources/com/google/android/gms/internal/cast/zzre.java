package com.google.android.gms.internal.cast;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzre {
    private static final zzre zza = new zzre(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;

    private zzre(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
    }

    public static zzre zzc() {
        return zza;
    }

    public static zzre zzd(zzre zzreVar, zzre zzreVar2) {
        int i10 = zzreVar.zzb;
        int i11 = zzreVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzreVar.zzc, 0);
        System.arraycopy(zzreVar2.zzc, 0, copyOf, 0, 0);
        Object[] copyOf2 = Arrays.copyOf(zzreVar.zzd, 0);
        System.arraycopy(zzreVar2.zzd, 0, copyOf2, 0, 0);
        return new zzre(0, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzre)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zza() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzb() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        this.zze = 0;
        return 0;
    }

    public final void zze(StringBuilder sb, int i10) {
    }

    private zzre() {
        this(0, new int[8], new Object[8], true);
    }
}
