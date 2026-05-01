package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class zzl extends zzc {
    private final /* synthetic */ zzk zzbl;

    public zzl(zzk zzkVar) {
        this.zzbl = zzkVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void zze(Status status) {
        this.zzbl.setResult((zzk) status);
    }
}
