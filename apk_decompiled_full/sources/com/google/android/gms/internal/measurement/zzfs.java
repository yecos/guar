package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzfs extends zzkb implements zzln {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzfs() {
        super(r0);
        zzft zzftVar;
        zzftVar = zzft.zza;
    }

    public final int zza() {
        return ((zzft) this.zza).zzb();
    }

    public final long zzb() {
        return ((zzft) this.zza).zzc();
    }

    public final long zzc() {
        return ((zzft) this.zza).zzd();
    }

    public final zzfs zzd(Iterable iterable) {
        zzaG();
        zzft.zzm((zzft) this.zza, iterable);
        return this;
    }

    public final zzfs zze(zzfw zzfwVar) {
        zzaG();
        zzft.zzk((zzft) this.zza, (zzfx) zzfwVar.zzaC());
        return this;
    }

    public final zzfs zzf(zzfx zzfxVar) {
        zzaG();
        zzft.zzk((zzft) this.zza, zzfxVar);
        return this;
    }

    public final zzfs zzg() {
        zzaG();
        ((zzft) this.zza).zze = zzkf.zzbE();
        return this;
    }

    public final zzfs zzh(int i10) {
        zzaG();
        zzft.zzo((zzft) this.zza, i10);
        return this;
    }

    public final zzfs zzi(String str) {
        zzaG();
        zzft.zzp((zzft) this.zza, str);
        return this;
    }

    public final zzfs zzj(int i10, zzfw zzfwVar) {
        zzaG();
        zzft.zzj((zzft) this.zza, i10, (zzfx) zzfwVar.zzaC());
        return this;
    }

    public final zzfs zzk(int i10, zzfx zzfxVar) {
        zzaG();
        zzft.zzj((zzft) this.zza, i10, zzfxVar);
        return this;
    }

    public final zzfs zzl(long j10) {
        zzaG();
        zzft.zzr((zzft) this.zza, j10);
        return this;
    }

    public final zzfs zzm(long j10) {
        zzaG();
        zzft.zzq((zzft) this.zza, j10);
        return this;
    }

    public final zzfx zzn(int i10) {
        return ((zzft) this.zza).zzg(i10);
    }

    public final String zzo() {
        return ((zzft) this.zza).zzh();
    }

    public final List zzp() {
        return Collections.unmodifiableList(((zzft) this.zza).zzi());
    }

    public final boolean zzq() {
        return ((zzft) this.zza).zzu();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zzfs(zzfk zzfkVar) {
        super(r1);
        zzft zzftVar;
        zzftVar = zzft.zza;
    }
}
