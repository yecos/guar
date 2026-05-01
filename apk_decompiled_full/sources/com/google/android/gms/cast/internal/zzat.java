package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzco;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzat {

    @VisibleForTesting
    zzar zzc;

    @VisibleForTesting
    Runnable zzd;
    private final long zzf;
    private static final Logger zze = new Logger("RequestTracker");
    public static final Object zza = new Object();

    @VisibleForTesting
    long zzb = -1;
    private final Handler zzg = new zzco(Looper.getMainLooper());

    public zzat(long j10) {
        this.zzf = j10;
    }

    public static /* synthetic */ void zza(zzat zzatVar) {
        synchronized (zza) {
            if (zzatVar.zzb == -1) {
                return;
            }
            zzatVar.zzh(15, null);
        }
    }

    private final void zzg(int i10, Object obj, String str) {
        zze.d(str, new Object[0]);
        Object obj2 = zza;
        synchronized (obj2) {
            zzar zzarVar = this.zzc;
            if (zzarVar != null) {
                zzarVar.zza(this.zzb, i10, obj);
            }
            this.zzb = -1L;
            this.zzc = null;
            synchronized (obj2) {
                Runnable runnable = this.zzd;
                if (runnable != null) {
                    this.zzg.removeCallbacks(runnable);
                    this.zzd = null;
                }
            }
        }
    }

    private final boolean zzh(int i10, Object obj) {
        synchronized (zza) {
            long j10 = this.zzb;
            if (j10 == -1) {
                return false;
            }
            zzg(i10, null, String.format(Locale.ROOT, "clearing request %d", Long.valueOf(j10)));
            return true;
        }
    }

    public final void zzb(long j10, zzar zzarVar) {
        zzar zzarVar2;
        long j11;
        Object obj = zza;
        synchronized (obj) {
            zzarVar2 = this.zzc;
            j11 = this.zzb;
            this.zzb = j10;
            this.zzc = zzarVar;
        }
        if (zzarVar2 != null) {
            zzarVar2.zzb(j11);
        }
        synchronized (obj) {
            Runnable runnable = this.zzd;
            if (runnable != null) {
                this.zzg.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.google.android.gms.cast.internal.zzas
                @Override // java.lang.Runnable
                public final void run() {
                    zzat.zza(zzat.this);
                }
            };
            this.zzd = runnable2;
            this.zzg.postDelayed(runnable2, this.zzf);
        }
    }

    public final boolean zzc(int i10) {
        return zzh(CastStatusCodes.CANCELED, null);
    }

    public final boolean zzd(long j10, int i10, Object obj) {
        synchronized (zza) {
            long j11 = this.zzb;
            if (j11 == -1 || j11 != j10) {
                return false;
            }
            zzg(i10, obj, String.format(Locale.ROOT, "request %d completed", Long.valueOf(j10)));
            return true;
        }
    }

    public final boolean zze() {
        boolean z10;
        synchronized (zza) {
            z10 = this.zzb != -1;
        }
        return z10;
    }

    public final boolean zzf(long j10) {
        boolean z10;
        synchronized (zza) {
            long j11 = this.zzb;
            z10 = false;
            if (j11 != -1 && j11 == j10) {
                z10 = true;
            }
        }
        return z10;
    }
}
