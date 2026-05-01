package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzfe extends zzkb implements zzln {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzfe() {
        super(r0);
        zzff zzffVar;
        zzffVar = zzff.zza;
    }

    public final int zza() {
        return ((zzff) this.zza).zzb();
    }

    public final zzfd zzb(int i10) {
        return ((zzff) this.zza).zzd(i10);
    }

    public final zzfe zzc() {
        zzaG();
        ((zzff) this.zza).zzj = zzkf.zzbE();
        return this;
    }

    public final zzfe zzd(int i10, zzfc zzfcVar) {
        zzaG();
        zzff.zzo((zzff) this.zza, i10, (zzfd) zzfcVar.zzaC());
        return this;
    }

    public final String zze() {
        return ((zzff) this.zza).zzi();
    }

    public final List zzf() {
        return Collections.unmodifiableList(((zzff) this.zza).zzj());
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzff) this.zza).zzk());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zzfe(zzez zzezVar) {
        super(r1);
        zzff zzffVar;
        zzffVar = zzff.zza;
    }
}
