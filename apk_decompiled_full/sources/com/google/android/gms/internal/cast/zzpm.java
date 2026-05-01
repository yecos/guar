package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public class zzpm {
    private static final zzon zzb = zzon.zza();
    protected volatile zzqe zza;
    private volatile zzoe zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpm)) {
            return false;
        }
        zzpm zzpmVar = (zzpm) obj;
        zzqe zzqeVar = this.zza;
        zzqe zzqeVar2 = zzpmVar.zza;
        if (zzqeVar == null && zzqeVar2 == null) {
            return zzb().equals(zzpmVar.zzb());
        }
        if (zzqeVar != null && zzqeVar2 != null) {
            return zzqeVar.equals(zzqeVar2);
        }
        if (zzqeVar != null) {
            zzpmVar.zzc(zzqeVar.zzs());
            return zzqeVar.equals(zzpmVar.zza);
        }
        zzc(zzqeVar2.zzs());
        return this.zza.equals(zzqeVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzoc) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzq();
        }
        return 0;
    }

    public final zzoe zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzoe.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            return this.zzc;
        }
    }

    public final void zzc(zzqe zzqeVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzqeVar;
                    this.zzc = zzoe.zzb;
                } catch (zzpj unused) {
                    this.zza = zzqeVar;
                    this.zzc = zzoe.zzb;
                }
            }
        }
    }
}
