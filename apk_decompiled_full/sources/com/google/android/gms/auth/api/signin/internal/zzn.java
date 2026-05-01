package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class zzn extends zzc {
    private final /* synthetic */ zzm zzbm;

    public zzn(zzm zzmVar) {
        this.zzbm = zzmVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void zzf(Status status) {
        this.zzbm.setResult((zzm) status);
    }
}
