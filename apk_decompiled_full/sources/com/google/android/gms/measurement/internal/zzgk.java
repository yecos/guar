package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
class zzgk implements zzgm {
    protected final zzfr zzt;

    public zzgk(zzfr zzfrVar) {
        Preconditions.checkNotNull(zzfrVar);
        this.zzt = zzfrVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Context zzau() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Clock zzav() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzab zzaw() {
        throw null;
    }

    public void zzax() {
        this.zzt.zzaz().zzax();
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzeh zzay() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzfo zzaz() {
        throw null;
    }

    public void zzg() {
        this.zzt.zzaz().zzg();
    }
}
