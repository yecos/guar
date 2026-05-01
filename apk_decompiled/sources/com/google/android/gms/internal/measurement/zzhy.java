package com.google.android.gms.internal.measurement;

import android.net.Uri;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzhy {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;

    @Nullable
    final zzif zzi;

    private zzhy(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, @Nullable zzif zzifVar) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = z10;
        this.zzf = false;
        this.zzg = z12;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzhy zza() {
        return new zzhy(null, this.zzb, this.zzc, this.zzd, this.zze, false, true, false, null);
    }

    public final zzhy zzb() {
        if (this.zzc.isEmpty()) {
            return new zzhy(null, this.zzb, this.zzc, this.zzd, true, false, this.zzg, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzib zzc(String str, double d10) {
        return new zzhw(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzib zzd(String str, long j10) {
        return new zzhu(this, str, Long.valueOf(j10), true);
    }

    public final zzib zze(String str, String str2) {
        return new zzhx(this, str, str2, true);
    }

    public final zzib zzf(String str, boolean z10) {
        return new zzhv(this, str, Boolean.valueOf(z10), true);
    }

    public zzhy(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }
}
