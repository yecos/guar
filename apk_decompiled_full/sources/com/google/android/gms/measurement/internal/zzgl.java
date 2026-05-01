package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
abstract class zzgl extends zzgk {
    private boolean zza;

    public zzgl(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzt.zzD();
    }

    public void zzaA() {
    }

    public abstract boolean zzf();

    public final void zzu() {
        if (!zzx()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzf()) {
            return;
        }
        this.zzt.zzB();
        this.zza = true;
    }

    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaA();
        this.zzt.zzB();
        this.zza = true;
    }

    public final boolean zzx() {
        return this.zza;
    }
}
