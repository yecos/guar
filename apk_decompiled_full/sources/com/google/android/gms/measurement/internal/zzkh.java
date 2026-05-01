package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
abstract class zzkh extends zzkg {
    private boolean zza;

    public zzkh(zzkt zzktVar) {
        super(zzktVar);
        this.zzf.zzM();
    }

    public final void zzW() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzb();
        this.zzf.zzH();
        this.zza = true;
    }

    public final boolean zzY() {
        return this.zza;
    }

    public abstract boolean zzb();
}
